package interview.product;

import interview.product.handler.*;
import interview.product.model.Item;

import java.util.HashMap;

// Mid Level: OOP 多态 + 数据结构 + 设计模式
public class GildedRoseKataLevel2 {

    private final Item[] items;
    private final IHandler commonHandler;
    private final HashMap<String, IHandler> itemHandlerMap;

    public GildedRoseKataLevel2(Item[] items) {
        this.items = items;
        this.commonHandler = new GenericHandler();
        this.itemHandlerMap = new HashMap<>();
        injectItemHandler("typeA", new TypeAHandler());
        injectItemHandler("typeB", new TypeBHandler());
        injectItemHandler("typeC", new TypeCHandler());
    }

    // TODO. 注入的调用太多, 不够整洁
    public void injectItemHandler(String name, IHandler handler) {
        this.itemHandlerMap.put(name, handler);
    }

    public void removeItemByName(String name) {
        this.itemHandlerMap.remove(name);
    }

    // TODO. Template Method 通用模版方法
    public void updateQuality() {
        for (Item item : items) {
            this.itemHandlerMap.getOrDefault(item.name, this.commonHandler).update(item);
        }
    }
}
