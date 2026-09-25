package pattern_structure.proxy.jdk;

import pattern_structure.proxy.ProxyHelper;
import pattern_structure.proxy.jdk.base.Person;
import pattern_structure.proxy.jdk.base.PersonImpl;
import pattern_structure.proxy.jdk.handler.PersonInvocationHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

// TODO: 动态代理是在运行时动态生成类字节码，并加载到JVM
//   生成一个动态代理类，该类继承自Proxy类，同时实现Person接口(可调所有的方法)
// $Proxy0是代理类在系统内部的编号
// SimpleName = $Proxy0 name =com.sun.proxy.$Proxy0
// implements Interfaces = [interface JavaProxy.DynamicProxy.model.Person]
// superClass = class java.lang.reflect.Proxy
public class JdkDynamicProxyBasic {

    public static void main(String[] args) {
        // 创建一个实例对象, 这个对象是被代理的对象, 委托类
        Person person = new PersonImpl("chen");

        // 创建一个与代理类相关联的InvocationHandler
        // 每一个代理类都有一个关联的InvocationHandler, 并将代理类引用传递进去
        InvocationHandler handler = new PersonInvocationHandler<>(person);

        // TODO. 创建一个代理对象personProxy来代理person
        // 创建的代理对象每个执行方法都会被替换执行InvocationHandler接口中invoke方法 !!
        Person proxyPerson = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[]{Person.class}, handler);
        ProxyHelper.showProxyInfos(proxyPerson.getClass());

        // 通过"代理类"执行"委托类"的代码逻辑, 最终会执行handler中invoke()方法
        String name = proxyPerson.getName();
        proxyPerson.work(name, "Place 01");
    }
}