package design_patterns.pattern3_behavior.command.model;

public class OrderBuyStock implements Order {

    private final Stock abcStock;

    public OrderBuyStock(Stock abcStock) {
        this.abcStock = abcStock;
    }

    public void execute() {
        abcStock.buy();
    }
}
