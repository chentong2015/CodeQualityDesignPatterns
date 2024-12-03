package pattern1_creation.singleton;

// 1. 使用变量来访问单列的实例对象: Thread-safe
// 2. 使用方法来提供访问单列的实例对象: Not Thread-safe

// ex: Runtime.getRuntime();
// 1. 如果过度使用，会对程序性能造成影响
// 2. 很难单元测试
// 3. 注意和Factory模式的区别, java.util.Calendar is not a singleton
public class SingletonBasic {

    // 1. Lazy instantiation: 只有当该类型第一被加载时才会创建对象
    //    Until the first time class loaded, and call the instance method
    // 2. 这里的属性可以不设置成final
    private static SingletonBasic instance = new SingletonBasic();

    // Only the class can create instance of itself
    private SingletonBasic() {
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to create");
        }
    }

    public static SingletonBasic instance() {
        return instance;
    }

    // Lazy instantiation: 只有在第一次需要(调用instance()方法)时才创建实例对象
    public static SingletonBasic getInstance() {
        if (instance == null) {
            /**
             * Not thread-safe 非线程安全：违反单列的设计模式 !!!
             * thread 1可能在判断完null之后中断，然后切换给thread 2
             * thread 2在判断完null之后创建instance实例对象，然后切换给thread 1
             * thread 1继续判断后的执行，创建第二个instance实例对象
             */
            instance = new SingletonBasic();
        }
        return instance;
    }
}


