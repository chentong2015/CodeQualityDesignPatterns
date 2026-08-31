package com.exercise;

import com.exercise.exception.IndexOutOfBorderException;
import com.exercise.model.Coordinate;
import com.exercise.model.Direction;
import com.exercise.model.Order;
import com.exercise.model.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MowerMachine {

    private final Position currentPosition;
    private final Coordinate borderCoordinate;
    private static final Logger LOGGER = LoggerFactory.getLogger(MowerMachine.class);

    public MowerMachine(Coordinate borderCoordinate, Position position) throws IndexOutOfBorderException {
        this.borderCoordinate = borderCoordinate;
        this.currentPosition = position;
        if (isOutsideOfBorder()) {
            throw new IndexOutOfBorderException("Init position is out of Border");
        }
        LOGGER.info("Init Mower Machine with position: {}", position);
    }

    public void moveByOrders(List<Order> orderList) {
        for (Order order : orderList) {
            if (order == Order.A) {
                moveOneStep();
            } else if (order == Order.D) {
                currentPosition.turnDirectionRight();
            } else {
                currentPosition.turnDirectionLeft();
            }
            // If mower machine moves outside area, keep direction and stop moving
            if (isOutsideOfBorder()) {
                LOGGER.info("Mower machine moves outside area, it will stop moving");
                break;
            }
        }
    }

    // TODO. 类型成员属性的具体职责的划分，需要重点考虑方法定义在什么类型之中
    private void moveOneStep() {
        Direction direction = currentPosition.getDirection();
        if (direction == Direction.E) {
            currentPosition.getCoordinate().goForward();
        } else if (direction == Direction.S) {
            currentPosition.getCoordinate().goDown();
        } else if (direction == Direction.W) {
            currentPosition.getCoordinate().goBack();
        } else {
            currentPosition.getCoordinate().goUp();
        }
    }

    private boolean isOutsideOfBorder() {
        int currentX = currentPosition.getCoordinate().getX();
        int currentY = currentPosition.getCoordinate().getY();
        return currentX < 0 || currentX > borderCoordinate.getX()
                || currentY < 0 || currentY > borderCoordinate.getY();
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }
}
