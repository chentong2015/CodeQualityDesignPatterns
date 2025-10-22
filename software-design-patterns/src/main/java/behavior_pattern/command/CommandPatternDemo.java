package behavior_pattern.command;

import behavior_pattern.command.model.CommandInvokerClass;
import behavior_pattern.command.model.OrderBuyStock;
import behavior_pattern.command.model.OrderSellStock;
import behavior_pattern.command.model.Stock;

public class CommandPatternDemo {

    public static void main(String[] args) {
        // 同一只股票的不同Order请求
        Stock abcStock = new Stock();

        // A request is wrapped under an object as command
        OrderBuyStock buyStockOrder = new OrderBuyStock(abcStock);
        OrderSellStock sellStockOrder = new OrderSellStock(abcStock);

        // Pass command to invoker object.
        CommandInvokerClass invoker = new CommandInvokerClass();
        invoker.takeOrder(buyStockOrder);
        invoker.takeOrder(sellStockOrder);

        // Invoker object 最终执行处理这些请求
        invoker.handleOrders();
    }
}
