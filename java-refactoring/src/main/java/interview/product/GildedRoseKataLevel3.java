package interview.product;

import interview.product.handler.IHandler;
import interview.product.model.Item;
import interview.product.handler.GenericHandler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Senior Level: Scalability 抽象底层逻辑, 提高可扩展性
public class GildedRoseKataLevel3 {

    private final Item[] items;
    private final HashMap<String, IHandler> itemHandlerMap;

    // Load by Configuration Properties file
    private HashMap<String, String> typeMapping;

    // 是否保证Item Immutable不可变性 -> Deep Copy ?
    public GildedRoseKataLevel3(Item[] items) {
        this.items = items;
        this.itemHandlerMap = new HashMap<>();
        initItemHandlerMap();
    }

    // TODO. 如何通过名称获取Handler处理器, 循环注入 ?
    // - Refection   反射获取并创建对象(影响性能)
    // - Spring IOC  直接根据名称获取Bean对象(ApplicationContext.getBeanByName(name))
    private void initItemHandlerMap() {
        for (Map.Entry<String, String> entry : typeMapping.entrySet()) {
            IHandler handler = new GenericHandler();
            this.itemHandlerMap.put(entry.getKey(), handler);
        }
    }

    // 确定Type名称一定有对应的Handler处理器
    public void updateQuality() {
        Arrays.stream(items).forEach(item -> this.itemHandlerMap.get(item.name).update(item));
    }
}
