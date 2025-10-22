package structure_pattern.proxy.jdk;

import java.lang.reflect.InvocationHandler;

// 使用抽象类，则可以不在该类中实现invoke()方法，而是在使用时(在匿名类中)自定义
public abstract class AbstractInvocationHandler implements InvocationHandler {

    private final Object target;

    public AbstractInvocationHandler(Object target) {
        this.target = target;
    }

    public Object getTarget() {
        return target;
    }
}
