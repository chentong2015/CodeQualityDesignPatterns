package interview;

/*
 TODO. 注意题目中给出的案例/类型/测试数据
 * We have shop, called GildedRose, holding an inventory of Items
 * Each item has 3 properties:
 * - A name, a string that discriminates the type of item (e.g. tomato, brie, etc)
 * - A SellIn value, an integer that denotes the number of days until the expiration date (positive = in the future, negative = in the past)
 * - A Quality, an integer that denotes how valuable the item is
 *     - The Quality of an item is never negative
 *     - The Quality of an item is never more than 50
 *
 * At the end of each day our system lowers the SellIn and Quality for every item
 * Once the sell by date has passed, Quality degrades twice as fast
 *
 * "Aged Brie" actually increases in Quality the older it gets
 * "Sulfuras, Hand of Ragnaros", being a legendary item, never has to be sold or decreases in Quality
 * "Backstage passes to a TAFKAL80ETC concert", like aged brie, increases in Quality as its SellIn value approaches 0
 *
 * - Quality increases by 2 when there are 10 days or less, and by 3 when there are 5 days or less
 * - but Quality drops to 0 after the concert
 */
public class GildedRoseKata {

    // normally to add private for the field
    private Item[] items;

    public GildedRoseKata(Item[] items) {
        this.items = items;
    }

    // 坚持往好的方面想, 保证正确的思路
    // 在垃圾的代码上继续修改, 只能越该越乱

    // Comment:
    // part1 - name / Aged Brie
    // part2 - "Sulfuras, Hand of Ragnaros"
    // part3 -
    // part4 -
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }

            if (!items[i].name.equals("Aged Brie") && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) { // use constant string
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality--;
                    }
                }
            } else {
                // Aged Brie or Backstage passes to a TAFKAL80ETC concert
                handleAgedBrie(i);
                handleBackstage(i);
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn--;
            }

            // too many if conditions
            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        // handle for Sulfuras
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = 0;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality++;
                    }
                }
            }
        }
    }

    private void handleAgedBrie(int i) {
        if (items[i].quality < 50) {
            // do nothing
        }
    }

    private void hanldeSulfuras(int index) {

    }

    private void handleBackstage(int i) {
        if (items[i].quality < 50) { // special number, use by constant
            items[i].quality++;
            if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].sellIn < 11) {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1; // ++
                    }
                }
                if (items[i].sellIn < 6) {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
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
            return this.name + ", " + this.sellIn + ", " + this.quality;
        }
    }

}
