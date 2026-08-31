package com.exercise.io;

import com.exercise.exception.FileSourceException;
import com.exercise.helper.TestResourceHelper;

import com.exercise.model.Coordinate;
import com.exercise.model.Direction;
import com.exercise.model.Order;
import com.exercise.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class FileSourceManagerTest {

    @Test
    void testLoadFileSimpleCase() throws FileSourceException {
        String fullPath = TestResourceHelper.getFullPath("file_simple_case.txt");
        FileSourceManager fileSourceManager = new FileSourceManager(fullPath);

        Coordinate borderCoordinate = fileSourceManager.getBorderCoordinate();
        Assertions.assertEquals(5, borderCoordinate.getX());
        Assertions.assertEquals(5, borderCoordinate.getY());

        Position position = fileSourceManager.getPositionByIndex(0);
        Assertions.assertEquals(1, position.getCoordinate().getX());
        Assertions.assertEquals(2, position.getCoordinate().getY());
        Assertions.assertEquals(Direction.N, position.getDirection());
        List<Order> orderList = fileSourceManager.getOrderListByIndex(0);
        Assertions.assertEquals("[G, A, G, A, G, A, G, A, A]", orderList.toString());

        position = fileSourceManager.getPositionByIndex(1);
        Assertions.assertEquals(3, position.getCoordinate().getX());
        Assertions.assertEquals(3, position.getCoordinate().getY());
        Assertions.assertEquals(Direction.E, position.getDirection());
        orderList = fileSourceManager.getOrderListByIndex(1);
        Assertions.assertEquals("[A, A, D, A, A, D, A, D, D, A]", orderList.toString());
    }
}
