package pattern2_structure.proxy.jdk;

import pattern2_structure.proxy.ProxyHelper;
import pattern2_structure.proxy.jdk.model.PersonInvocationHandler;
import pattern2_structure.proxy.jdk.model.Person;
import pattern2_structure.proxy.jdk.model.PersonImpl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class JdkDynamicProxyMaster {

    // TODO: Proxy.newProxyInstance()方法底层的细节
    // 根据自定义的InvocationHandler的实现，拿到对应的构造器来创建指定的动态代理类(对象)
    // loader – the class loader to define the proxy class
    // interfaces – the list of interfaces for the proxy class to implement
    // Returns: a proxy class that is defined in the specified class loader and that implements the specified interfaces
    //
    // public static Class<?> getProxyClass(ClassLoader loader,  Class<?>... interfaces)
    //     throws IllegalArgumentException {
    //     Class<?> caller = System.getSecurityManager() == null ? null : Reflection.getCallerClass();
    //     return getProxyConstructor(caller, loader, interfaces).getDeclaringClass();
    // }
    public static void testJavaDynamicProxySourceCodes() throws Exception {
        Person person = new PersonImpl("tong");
        InvocationHandler handler = new PersonInvocationHandler<>(person);

        // 1. getProxyClass静态方法生成一个动态代理类，该类继承自Proxy类，实现Person接口
        // 2. 拿到动态代理类指定参数(带有InvocationHandler参数)的构造器
        // 3. 通过构造器创建一个动态代理类实例
        Class<?> proxyClass = Proxy.getProxyClass(Person.class.getClassLoader(), Person.class);
        ProxyHelper.showProxyInfos(proxyClass);
        Constructor<?> ProxyConstructor = proxyClass.getConstructor(InvocationHandler.class);
        Person proxyInstance = (Person) ProxyConstructor.newInstance(handler);

        // 通过Proxy的静态方法来判断一个类型是否是动态代理类
        // 获取并检测于动态代理类关联的InvocationHandler
        System.out.println("stuProxy isProxy " + Proxy.isProxyClass(proxyInstance.getClass()));
        InvocationHandler handlerObject = Proxy.getInvocationHandler(proxyInstance);
        System.out.println(handlerObject.getClass().getName());

        String name = proxyInstance.getName();
        proxyInstance.work(name, "Place 02");
    }
}
