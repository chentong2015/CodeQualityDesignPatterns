package pattern_structure.proxy.jdk;

import pattern_structure.proxy.jdk.base.Person;
import pattern_structure.proxy.jdk.base.PersonImpl;
import pattern_structure.proxy.jdk.handler.AbstractInvocationHandler;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkDynamicProxyDecorated {

    // 装配模式: 通过Proxy代理setName()方法的调用
    // 代理类型调用.setName()方法将会在触发InvocationHandler中的invoke()方法
    public static void main(String[] args) {
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
