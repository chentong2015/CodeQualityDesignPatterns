package com.exercise.io;

import com.exercise.exception.FileSourceException;
import com.exercise.model.Coordinate;
import com.exercise.model.Direction;
import com.exercise.model.Order;
import com.exercise.model.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileSourceManager {

    private Coordinate borderCoordinate;
    private final List<Position> positionList;
    private final List<List<Order>> orderList;

    private static final String LINE_SPACE = " ";
    private static final Logger LOGGER = LoggerFactory.getLogger(FileSourceManager.class);

    // TODO. 正常而言，构造器中一般执行对象的Init操作，而不调用具体的逻辑功能
    public FileSourceManager(String filepath) throws FileSourceException {
        this.positionList = new ArrayList<>();
        this.orderList = new ArrayList<>();
        loadFile(filepath);
    }

    // 确保在对象创建的时候就应该初始化一些数据
    // 对于不向外暴露的方法，需要将方法的可见性设置成private
    public void loadFile(String filepath) throws FileSourceException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            readBorderCoordinate(reader.readLine());
            while (true) {
                String initPositionLine = reader.readLine();
                if (initPositionLine == null) {
                    break;
                }
                String ordersLine = reader.readLine();
                readInitPositionAndOrders(initPositionLine, ordersLine);
            }
        } catch (IOException exception) {
            throw new FileSourceException(exception.getMessage());
        }
    }

    private void readBorderCoordinate(String firstLine) throws FileSourceException {
        LOGGER.info("Read file line '{}' for border coordinate", firstLine);
        if (!LineValidator.isValidBorderCoordinate(firstLine)) {
            throw new FileSourceException("The Border coordinate is not valid");
        }
        String[] strings = firstLine.split(LINE_SPACE);
        int coordinateX = Integer.parseInt(strings[0]);
        int coordinateY = Integer.parseInt(strings[1]);
        this.borderCoordinate = new Coordinate(coordinateX, coordinateY);
    }

    private void readInitPositionAndOrders(String initPositionLine, String ordersLine) throws FileSourceException {
        if (!LineValidator.isValidInitPosition(initPositionLine)) {
            throw new FileSourceException("The format of init position is not correct");
        }
        if (!LineValidator.isValidOrders(ordersLine)) {
            throw new FileSourceException("Wrong order instruction");
        }
        this.positionList.add(getPosition(initPositionLine));
        this.orderList.add(getOrders(ordersLine));
    }

    private Position getPosition(String initPositionLine) {
        LOGGER.info("Read init position '{}'", initPositionLine);
        String[] strings = initPositionLine.split(LINE_SPACE);
        int coordinateX = Integer.parseInt(strings[0]);
        int coordinateY = Integer.parseInt(strings[1]);
        Direction direction = getDirection(strings[2]);

        Coordinate coordinate = new Coordinate(coordinateX, coordinateY);
        return new Position(coordinate, direction);
    }

    private List<Order> getOrders(String ordersLine) {
        LOGGER.info("Read orders line string '{}'", ordersLine);
        List<Order> orders = new ArrayList<>();
        for (char c : ordersLine.toCharArray()) {
            if (c == 'G') {
                orders.add(Order.G);
            } else if (c == 'D') {
                orders.add(Order.D);
            } else {
                orders.add(Order.A);
            }
        }
        return orders;
    }

    private Direction getDirection(String value) {
        switch (value) {
            case "N":
                return Direction.N;
            case "E":
                return Direction.E;
            case "W":
                return Direction.W;
            default:
                return Direction.S;
        }
    }

    public Coordinate getBorderCoordinate() {
        return this.borderCoordinate;
    }

    public int countMachineDeployed() {
        return this.positionList.size();
    }

    // TODO. 对外提供Position和List<Order>时是否需要将其设计成Immutable Class
    // 防止属性的值在被使用时被篡改，但通常情况下是不需要考虑的
    public Position getPositionByIndex(int index) {
        return this.positionList.get(index);
    }

    public List<Order> getOrderListByIndex(int index) {
        return this.orderList.get(index);
    }
}
