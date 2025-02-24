package base_solid_principles.lsp.demo2;

public class Ostrich extends Bird {

    // 如果重写方法之后，导致Bird类型的对象没有办法执行到正确的fly逻辑
    // 1. 不进行重写，如果没有额外的逻辑加入
    // 2. 先调用父类的方法super.fly(); 然后再自定义逻辑
    @Override
    public void fly(int altitude) {
    }
}
