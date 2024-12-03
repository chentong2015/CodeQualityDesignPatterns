package pattern2_structure.proxy.jdk;

import pattern2_structure.proxy.ProxyHelper;
import pattern2_structure.proxy.jdk.model.PersonInvocationHandler;
import pattern2_structure.proxy.jdk.model.Person;
import pattern2_structure.proxy.jdk.model.PersonImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// TODO: "动态"是指在程序运行时基于反射动态的创建出动态代理类，而不在"编译"期间确定
//   JDK动态代理的特点: 只能代理实现接口的类 & 代理类必须继承Proxy类
// https://docs.oracle.com/javase/7/docs/technotes/guides/reflection/proxy.html
public class JdkDynamicProxyBasic {

    // TODO: 动态代理是在运行时动态生成类字节码，并加载到JVM
    //   生成一个动态代理类，该类继承自Proxy类，同时实现Person接口(可调所有的方法)
    // $Proxy0是代理类在系统内部的编号
    // SimpleName = $Proxy0 name =com.sun.proxy.$Proxy0
    // implements Interfaces = [interface JavaProxy.DynamicProxy.model.Person]
    // superClass = class java.lang.reflect.Proxy

    // 为特定的接口返回代理的实例对象，以此来分发接口方法的调用给特定的"InvocationHandler"调用处理器
    // Returns a proxy instance for the specified interfaces that dispatches method invocations to the specified invocation handler.
    // public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h) {
    //     Objects.requireNonNull(h);
    //     final Class<?> caller = System.getSecurityManager() == null ? null: Reflection.getCallerClass();
    //     Constructor<?> cons = getProxyConstructor(caller, loader, interfaces);
    //     return newProxyInstance(caller, cons, h);
    // }
    public static void main(String[] args) {
        // 创建一个实例对象, 这个对象是被代理的对象, 委托类
        Person person = new PersonImpl("chen");
        // 创建一个与代理类相关联的InvocationHandler, 每一个代理类都有一个关联的InvocationHandler, 并将代理类引用传递进去
        InvocationHandler handler = new PersonInvocationHandler<>(person);

        // 创建一个代理对象personProxy来代理person
        // TODO: 创建的代理对象每个执行方法都会被替换执行InvocationHandler接口中invoke方法
        Person proxyPerson = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[]{Person.class}, handler);
        ProxyHelper.showProxyInfos(proxyPerson.getClass());

        // 通过"代理类"执行"委托类"的代码逻辑, 最终会执行handler中invoke()方法
        String name = proxyPerson.getName();
        proxyPerson.work(name, "Place 01");
    }

    // Proxy: 代理person setName()方法的调用, 对其做一个装配
    // 代理类型调用.setName()方法将会在触发InvocationHandler中的invoke()方法
    public void testDecoratePersonSetNameMethod() {
        Person person = new PersonImpl("base name");
        System.out.println(person.getName());

        Person proxyPerson = decoratePersonSetNameMethod(person);
        proxyPerson.setName("new name");
        System.out.println(proxyPerson.getName());
    }

    private static Person decoratePersonSetNameMethod(Person person) {
        return (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[]{Person.class},
           new AbstractInvocationHandler(person) {
               @Override
               public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                   if (method.getName().equals("setName")) {
                       Object[] newArgs = {"proxy name"};
                       return method.invoke(getTarget(), newArgs);
                   } else {
                       return method.invoke(getTarget(), args);
                   }
               }
           }
        );
    }
}
