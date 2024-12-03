package pattern1_creation.builder.core;

public class People {

    private String name;
    private int age;

    // 设置成protected为了被继承类型调用，完成基本属性的初始化
    protected People(Builder<?> builder) {
        this.name = builder.name;
        this.age = builder.age;
    }

    // 可以将Builder类设置成抽象类型
    public abstract static class Builder<T extends Builder<T>> {

        private String name;
        private int age;

        // TODO: 因为这里的方法一定会被Builder<T>的继承类所实现的
        //  所以这里可以使用该方法来获取到继承类型的this，从而继续build的过程
        public abstract T getThis();

        public People build() {
            return new People(this);
        }

        public T name(String name) {
            this.name = name;
            return this.getThis();
        }

        public T age(int age) {
            this.age = age;
            return this.getThis();
        }
    }

    // PeopleBuilder 这里返回的Builder需要实现其中定义的抽象方法
    public static Builder builder() {
        return new Builder() {
            @Override
            public Builder getThis() {
                return this;
            }
        };
    }

    @Override
    public String toString() {
        return "name: " + this.name + ", age: " + this.age;
    }
}
