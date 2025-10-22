package creation_pattern.singleton;

import java.io.Serial;
import java.io.Serializable;

// TODO. Double Check Lock 双检锁设计
// 2. private私有构造器的设计
// 3. init()初始化方法的创建, 代表初始化类型的对象 => 存在构造器
// 4. 单列方法的线程安全问题
// 5. 单列模式不允许再被继承(子类创建的实例也是一种父类的实例，违反单列的原则)
public final class SingletonDoubleCheckLock implements Serializable {

    // TODO. volatile一般适用在"特别"高并发的场景，或具有随机性 !
    private static SingletonDoubleCheckLock instance = null;

    // TODO. 客户端可以使用AccessibleObject.setAccessible反射机制来调用构造器
    //  为了防御反射攻击，让私有构造器在被要求创建第二个实例时抛出异常
    private SingletonDoubleCheckLock() {
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to create instance");
        }
        // init here for instance
    }

    // TODO. Double Check Locking
    public static SingletonDoubleCheckLock getInstance() {
        if (instance == null) {
            synchronized (SingletonDoubleCheckLock.class) {
                if (instance == null) {
                    instance = new SingletonDoubleCheckLock();
                }
            }
        }
        return instance;
    }

    // TODO. 在内部的方法中可以创建多次实例对象，造成非单列
    private void testCreateInstance1() {
        instance = new SingletonDoubleCheckLock();
    }

    private void testCreateInstance2() {
        instance = new SingletonDoubleCheckLock();
    }

    // TODO. 实例对象的方法需要考虑线程并发
    public synchronized void runSomething() {
    }

    // TODO. 防止在反序列化"单列的序列化实例"时构建新对象
    @Serial
    private Object readResolve() {
        return instance;
    }
}
