package design_patterns.pattern2_structure.proxy.jdk.model;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

// InvocationHandler是被动态代理类的实例所实现的接口
// InvocationHandler is the interface implemented by the invocation handler of a proxy instance
public class PersonInvocationHandler<T> implements InvocationHandler {

    // 被代理对象引用，invoke方法里面method需要使用这个被代理对象
    private T target;

    public PersonInvocationHandler(T target) {
        this.target = target;
    }

    // 被动态代理类回调执行
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理类 proxyClass =" + proxy.getClass());
        System.out.println("方法名: " + method.getName());
        System.out.println("方法返回类型：" + method.getReturnType());
        System.out.println("接口方法入参数组: " + (args == null ? "null" : Arrays.toString(args)));
        Thread.sleep(10);
        Object result = method.invoke(target, args); // 调用被代理对象的原始方法
        return result;
    }
}
