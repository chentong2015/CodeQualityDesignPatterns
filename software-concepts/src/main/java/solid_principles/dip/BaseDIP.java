package solid_principles.dip;

// DIP 依赖倒置
// Dependency Inversion Principle
public class BaseDIP {

    // 将依赖具体改成依赖抽象(Abstract Class & Interface)
    private final IClass demoClass;

    public BaseDIP(IClass demoClass) {
        this.demoClass = demoClass;
    }

    public void test() {
        System.out.println(this.demoClass.getSomething());
    }
}
