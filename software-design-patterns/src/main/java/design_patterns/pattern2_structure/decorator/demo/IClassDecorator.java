package design_patterns.pattern2_structure.decorator.demo;

public class IClassDecorator implements IClass {

    // TODO. 这里可以理解成对IClass实现对象的一种delegate委托
    private final IClass iClass;

    public IClassDecorator(IClass iClass) {
        this.iClass = iClass;
    }

    // 通过装饰器，修改抽象方法的原始实现，在其中添加功能
    @Override
    public void print() {
        System.out.println("start printing ...");
        iClass.print();
        postPrint();
    }

    // 通过装饰器，添加新的方法逻辑
    public void postPrint() {
        System.out.println("post print");
    }
}
