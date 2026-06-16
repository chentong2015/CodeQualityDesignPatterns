package interview;

public class GildedRoseKataRefactoring {

    private Item[] items;
    private static String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static String AGED_BRIE = "Aged Brie";

    public GildedRoseKataRefactoring(Item[] items) {
        this.items = items;
    }

    // 直接根据不同的Item Type做数值的更新操作即可
    public void updateQuality() {
        for (Item item : items) {
            // Sulfuras 不变
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

            // 普通商品
            decreaseQuality(item);
            item.sellIn--;
            if (item.sellIn < 0) {
                decreaseQuality(item);
            }
        }
    }

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

    class Item {
        public String name;
        public int sellIn;
        public int quality;

        public Item(String name, int sellIn, int quality) {
            this.name = name;
            this.sellIn = sellIn;
            this.quality = quality;
        }

        @Override
        public String toString() {
            return name + ", " + sellIn + ", " + quality;
        }
    }
}
