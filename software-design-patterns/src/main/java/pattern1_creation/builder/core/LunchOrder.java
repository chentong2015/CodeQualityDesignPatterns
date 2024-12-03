package pattern1_creation.builder.core;

public class LunchOrder {

    // 保证类型的属性值不会改变
    private final String bread;
    private final String condiments;
    private final String dressing;
    private final String meat;

    // TODO: 构造器需要设置成private, 防止外部的访问
    // 只能通过内部的Builder来构建对象
    private LunchOrder(Builder builder) {
        this.bread = builder.bread;
        this.condiments = builder.condiments;
        this.dressing = builder.dressing;
        this.meat = builder.meat;
    }

    // 通过内部类来提供对象(属性)的构造
    // TODO: 使用时可以任意组合要设置的属性值, 而无需存在相应的构造函数
    public static class Builder {

        private String bread;
        private String condiments;
        private String dressing;
        private String meat;

        public Builder() {

        }

        public LunchOrder build() {
            return new LunchOrder(this);
        }

        public Builder bread(String bread) {
            this.bread = bread;
            return this;
        }

        public Builder condiments(String condiments) {
            this.condiments = condiments;
            return this;
        }

        public Builder dressing(String dressing) {
            this.dressing = dressing;
            return this;
        }

        public Builder meat(String meat) {
            this.meat = meat;
            return this;
        }
    }

    // 只提供get方法，保证immutable
    public String getBread() {
        return bread;
    }

    public String getCondiments() {
        return condiments;
    }

    public String getDressing() {
        return dressing;
    }

    public String getMeat() {
        return meat;
    }
}
