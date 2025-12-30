package exception.undeclared;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ExceptionalInvocationHandler implements InvocationHandler {

    // 如果调用的方法名称是size, 则会抛出一个原始方法上没有声明的checked exception
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("size")) {
            throw new SomeCheckedException("Always fails");
        }

        throw new RuntimeException();
    }
}
