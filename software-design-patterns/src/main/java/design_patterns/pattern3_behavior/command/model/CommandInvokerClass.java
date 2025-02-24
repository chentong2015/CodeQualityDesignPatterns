package design_patterns.pattern3_behavior.command.model;

import java.util.ArrayList;
import java.util.List;

public class CommandInvokerClass {

    private final List<Order> orderList = new ArrayList<>();

    public void takeOrder(Order order) {
        orderList.add(order);
    }

    public void handleOrders() {
        for (Order order : orderList) {
            if (order instanceof OrderBuyStock) {
                System.out.println("count order for buying stock");
            }
            order.execute();
        }
        orderList.clear();
    }
}
