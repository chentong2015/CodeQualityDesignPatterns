package core_behavior_patterns.command.model;

public class OrderSellStock implements Order {

    private final Stock abcStock;

    public OrderSellStock(Stock abcStock) {
        this.abcStock = abcStock;
    }

    public void execute() {
        abcStock.sell();
    }
}
