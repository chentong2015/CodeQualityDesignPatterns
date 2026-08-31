package com.exercise;

import com.exercise.exception.FileSourceException;
import com.exercise.exception.IndexOutOfBorderException;
import com.exercise.io.FileSourceManager;
import com.exercise.model.Coordinate;
import com.exercise.model.Order;
import com.exercise.model.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MainApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainApplication.class);

    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println("Please input at least one parameter of filepath !");
            return;
        }
        try {
            for (String filepath: args) {
                playMowerMachine(filepath);
            }
            System.out.println("Success: Check .log file for more details under /log folder");
        } catch (Exception exception) {
            LOGGER.error(exception.getMessage(), exception);
            System.out.println("Failed: Find error information in .log file under /log folder");
        }
    }

    public static void playMowerMachine(String filepath) throws FileSourceException, IndexOutOfBorderException {
        LOGGER.info("Loading filepath: {}", filepath);
        FileSourceManager fileSourceManager = new FileSourceManager(filepath);
        Coordinate borderCoordinate = fileSourceManager.getBorderCoordinate();

        for (int index = 0; index < fileSourceManager.countMachineDeployed(); index++) {
            Position initPosition = fileSourceManager.getPositionByIndex(index);
            List<Order> orderList = fileSourceManager.getOrderListByIndex(index);

            MowerMachine mowerMachine = new MowerMachine(borderCoordinate, initPosition);
            mowerMachine.moveByOrders(orderList);
            LOGGER.info("Final Position: {}", mowerMachine.getCurrentPosition());
        }
    }
}
