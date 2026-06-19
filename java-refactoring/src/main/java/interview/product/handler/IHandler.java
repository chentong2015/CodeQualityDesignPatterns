package interview.product.handler;

import interview.product.model.Item;

public interface IHandler {

    void update(Item item);

    default void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    default void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }
}
