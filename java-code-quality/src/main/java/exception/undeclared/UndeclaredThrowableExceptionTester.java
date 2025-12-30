package exception.undeclared;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;
import java.util.List;

// TODO. 在java runtime运行时:
//  原方法可能被proxy动态代理，导致方法抛出checked exception，而方法主体上没有声明
//  抛出checked exception会被包装到UndeclaredThrowableException中抛出
//  UndeclaredThrowableException本身是一个unchecked exception

// 应用场景
// - Java Dynamic Proxy
// - Spring Aspect
public class UndeclaredThrowableExceptionTester {

    public static void main(String[] args) {
        ClassLoader classLoader = UndeclaredThrowableExceptionTester.class.getClassLoader();
        InvocationHandler invocationHandler = new ExceptionalInvocationHandler();

        // 原始类型的size方法上没有异常的抛出
        List<String> list = new ArrayList<>();
        list.size();

        // 创建proxy代理类，调用size()方法会抛出checked exception
        List<String> proxyList = (List<String>) Proxy.newProxyInstance(classLoader, new Class[]{List.class}, invocationHandler);
        // proxyList.size();

        // catch UndeclaredThrowableException, 获取动态代理调用方法所抛出的异常
        try {
            proxyList.size();
        } catch (UndeclaredThrowableException undeclaredException) {
            Throwable throwable = undeclaredException.getUndeclaredThrowable();
            System.out.println(throwable.getMessage());

            // if (throwable.getClass() == HttpHostConnectException.class) {
            //     throw (HttpHostConnectException) throwable;
            // }
        }
    }

    // Exception in thread "main" java.lang.reflect.UndeclaredThrowableException
    //	 at com.sun.proxy.$Proxy0.size(Unknown Source)
    //	 at exception.undeclared.UndeclaredThrowableExceptionTester.main(UndeclaredThrowableExceptionTester.java:20)
    // Caused by: exception.undeclared.SomeCheckedException: Always fails
    //   at exception.undeclared.ExceptionalInvocationHandler.invoke(ExceptionalInvocationHandler.java:12)
}
