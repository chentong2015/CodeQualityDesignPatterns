package structure_pattern.decorator.wrapper;

import java.util.Collection;
import java.util.Set;

// Decorator本质是作为一个Wrapper Class，把Set的集合包装起来
public class InstrumentedSet<E> extends ForwardingSet<E> {

    // 补充子类的额外属性，增加功能性的扩展
    private int addCount = 0;

    // 子类在实例化时，必须调用父类的构造器来进行初始化
    public InstrumentedSet(Set<E> set) {
        super(set);
    }

    // TODO. 这里只是重写了父类ForwardingSet的方法，而非Set<E>实现类的方法
    // Set的wrapper类的addAll()方法并没有调用它自身的add()方法
    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}
