package pattern1_creation.builder.core;

public class LunchOrderDemo {

    public void testBuilderPattern() {
        LunchOrder.Builder builder = new LunchOrder.Builder();
        // 可以自定义组合，进行构造
        builder.bread("bread").condiments("mayo").meat("meat");
        LunchOrder lunchOrder = builder.build();

        System.out.println(lunchOrder.getBread());
        System.out.println(lunchOrder.getMeat());
    }
}
