package design_patterns.pattern1_creation.singleton;

public class SingletonDesign {

    // TODO. 使用变量来访问单列的实例对象: Thread-safe
    // 属性可以不设置成final
    private static SingletonDesign instance = new SingletonDesign();

    // Only the class can create instance of itself
    private SingletonDesign() {
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to create");
        }
    }

    public static SingletonDesign instance() {
        return instance;
    }

    // TODO. 使用方法来提供访问单列的实例对象: Not Thread-safe
    // Lazy instantiation: 只有在第一次需要(调用instance()方法)时才创建实例对象
    public static SingletonDesign getInstance() {
        if (instance == null) {
            // 违反单列的设计模式:
            // thread 1可能在判断完null之后中断，然后切换给thread 2
            // thread 2在判断完null之后创建instance实例对象，然后切换给thread 1
            // thread 1继续判断后的执行，创建第二个instance实例对象
            instance = new SingletonDesign();
        }
        return instance;
    }
}


