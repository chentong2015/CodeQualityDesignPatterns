package behavior_pattern.strategy.demo1;

// TODO: Strategy pattern core
// 1. There is a impact on the number of objects in the system
//    该模式会造成对象数量的增加(根据不同的策略，都有具体的实现)
// 2. With Strategy, the same behavior can be expressed differently
// 3. Strategy can provide dynamic behavior for us
//    It can help us avoid dealing with complex algorithm-specific data structures
// 4. Additional overhead is needed due to communication between the strategies and their contexts.
public class CreditCard {

    private String number;
    private String date;
    private String cvv;
    private ValidationStrategy strategy;

    // 在构造器中使用抽象类型，可以在创建CreditCard实例时使用定义好的不同策略
    // 通过Strategy模式实现ValidationStrategy不同实现实例的使用
    public CreditCard(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    // Context <-> Strategy
    // Take care of the communication between the strategies and their contexts
    public boolean isValid() {
        return strategy.isValid(this);
    }

    public String getNumber() {
        return number;
    }
}
