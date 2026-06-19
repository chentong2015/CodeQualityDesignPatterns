package interview.product;

import interview.product.model.Item;

// Junior Level: 直接根据不同的Item Type做数值的更新操作即可
public class GildedRoseKataLevel1 {

    private Item[] items;
    private static String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static String AGED_BRIE = "Aged Brie";

    public GildedRoseKataLevel1(Item[] items) {
        this.items = items;
    }

    // TODO. IF条件判断随着Type类型增加而暴涨
    public void updateQuality() {
        for (Item item : items) {
            // Sulfuras no changes
            if (SULFURAS.equals(item.name)) {
                continue;
            }

            // Aged Brie
            if (AGED_BRIE.equals(item.name)) {
                increaseQuality(item);
                item.sellIn--;
                if (item.sellIn < 0) {
                    increaseQuality(item);
                }
                continue;
            }

            // Backstage passes
            if (BACKSTAGE.equals(item.name)) {
                increaseQuality(item);
                if (item.sellIn <= 10) {
                    increaseQuality(item);
                }
                if (item.sellIn <= 5) {
                    increaseQuality(item);
                }
                item.sellIn--;
                if (item.sellIn < 0) {
                    item.quality = 0;
                }
                continue;
            }

            // normal items 过期之后加快变质
            decreaseQuality(item);
            item.sellIn--;
            if (item.sellIn < 0) {
                decreaseQuality(item);
            }
        }
    }

    // 质量始终维持在有限的区间中
    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }
}
