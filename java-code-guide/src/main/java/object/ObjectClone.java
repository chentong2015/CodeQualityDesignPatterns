package object;

// TODO. clone方法就是另一个构造器，在不影响原始对象的情况下，确保正确的创建克隆对象中的约束
// 实现Cloneable的类型是为了提供以一个功能适当的共有clone()方法
public class ObjectClone implements Cloneable {

    private Object[] elements;
    private final String finalValue;

    public ObjectClone(String finalValue) {
        elements = new Object[10];
        this.finalValue = finalValue;
    }

    // 类的clone()方法返回的对象应该是通过super.clone获得，而非调用构造器
    @Override
    public ObjectClone clone() {
        try {
            // 调用super.clone的类型必须实现Cloneable接口
            // clone时应该先调用super.clone
            ObjectClone clone = (ObjectClone) super.clone();

            // 在数组上调用clone，复制数组
            clone.elements = elements.clone();

            // TODO. clone方法禁止给final域赋值 => clone架构和可变对象final域的用法不同
            // clone.finalValue = finalValue;
            return clone;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            throw new AssertionError();
        }
    }
}
