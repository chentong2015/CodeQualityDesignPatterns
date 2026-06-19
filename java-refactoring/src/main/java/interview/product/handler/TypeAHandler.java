package interview.product.handler;

import interview.product.model.Item;

public class TypeAHandler implements IHandler {

    @Override
    public void update(Item item) {
        decreaseQuality(item);
        item.sellIn--;
        if (item.sellIn < 0) {
            decreaseQuality(item);
        }
    }
}
