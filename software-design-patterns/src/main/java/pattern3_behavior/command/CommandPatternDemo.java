package pattern3_behavior.command;

import pattern3_behavior.command.model.CommandInvokerClass;
import pattern3_behavior.command.model.OrderBuyStock;
import pattern3_behavior.command.model.OrderSellStock;
import pattern3_behavior.command.model.Stock;

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
