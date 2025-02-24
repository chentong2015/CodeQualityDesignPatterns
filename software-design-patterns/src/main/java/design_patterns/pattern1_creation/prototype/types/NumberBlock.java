package design_patterns.pattern1_creation.prototype.types;

public class NumberBlock implements IBlock {

    private int number;

    public NumberBlock(int number) {
        this.number = number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    // 每个具体的类型有独自的创建副本的方式(规则)
    @Override
    public IBlock copy() {
        return new NumberBlock(number);
    }
}
