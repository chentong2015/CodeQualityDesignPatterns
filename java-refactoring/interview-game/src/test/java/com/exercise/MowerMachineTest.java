package com.exercise;

import com.exercise.exception.FileSourceException;
import com.exercise.exception.IndexOutOfBorderException;
import com.exercise.helper.TestResourceHelper;
import com.exercise.io.FileSourceManager;
import com.exercise.model.Coordinate;
import com.exercise.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MowerMachineTest {

    @Test
    void testSimpleCase() throws FileSourceException, IndexOutOfBorderException {
        String fullPath = TestResourceHelper.getFullPath("file_simple_case.txt");
        FileSourceManager fileSourceManager = new FileSourceManager(fullPath);
        Coordinate borderCoordinate = fileSourceManager.getBorderCoordinate();

        MowerMachine mowerMachine = new MowerMachine(borderCoordinate, fileSourceManager.getPositionByIndex(0));
        mowerMachine.moveByOrders(fileSourceManager.getOrderListByIndex(0));
        Assertions.assertEquals("1 3 N", mowerMachine.getCurrentPosition().toString());

        mowerMachine = new MowerMachine(borderCoordinate, fileSourceManager.getPositionByIndex(1));
        mowerMachine.moveByOrders(fileSourceManager.getOrderListByIndex(1));
        Assertions.assertEquals("5 1 E", mowerMachine.getCurrentPosition().toString());
    }

    @Test
    void testWithWrongInitPosition() throws FileSourceException {
        String fullPath = TestResourceHelper.getFullPath("file_with_wrong_init_position.txt");
        FileSourceManager fileSourceManager = new FileSourceManager(fullPath);
        Coordinate borderCoordinate = fileSourceManager.getBorderCoordinate();
        Position position = fileSourceManager.getPositionByIndex(0);

        Assertions.assertThrows(IndexOutOfBorderException.class, () -> new MowerMachine(borderCoordinate, position));
    }

    @Test
    void testWithMovingOutside() throws FileSourceException, IndexOutOfBorderException {
        String fullPath = TestResourceHelper.getFullPath("file_with_moving_outside.txt");
        FileSourceManager fileSourceManager = new FileSourceManager(fullPath);
        Coordinate borderCoordinate = fileSourceManager.getBorderCoordinate();

        MowerMachine mowerMachine = new MowerMachine(borderCoordinate, fileSourceManager.getPositionByIndex(0));
        mowerMachine.moveByOrders(fileSourceManager.getOrderListByIndex(0));
        Assertions.assertEquals("1 6 N", mowerMachine.getCurrentPosition().toString());
    }

    @Test
    void testComplexCase() throws FileSourceException, IndexOutOfBorderException {
        String fullPath = TestResourceHelper.getFullPath("file_complex_case.txt");
        FileSourceManager fileSourceManager = new FileSourceManager(fullPath);
        Coordinate borderCoordinate = fileSourceManager.getBorderCoordinate();

        MowerMachine mowerMachine = new MowerMachine(borderCoordinate, fileSourceManager.getPositionByIndex(0));
        mowerMachine.moveByOrders(fileSourceManager.getOrderListByIndex(0));
        Assertions.assertEquals("527 319 E", mowerMachine.getCurrentPosition().toString());
    }
}
