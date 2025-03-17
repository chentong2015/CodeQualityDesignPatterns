package base_concepts.dependency_injection;

public class DependencyInjection {

    private final IDependencyClass iDependencyClass;

    // TODO. 在创建新实例时，将要依赖的对象传入构造器中
    //  - 将依赖的对象直接inject到对象中
    //  - 将资源工厂传递给构造器，使用工厂来创建依赖对象
    public DependencyInjection(IDependencyClass iDependencyClass) {
        this.iDependencyClass = iDependencyClass;
    }

    // 与DependencyClass形成紧耦合的关系
    // 1. 当类型发生移动时，也必须移动组件和依赖
    // 2. 如果想使用别的类型(的功能)，必须要修改这个类里面的成员，违反了OCP原则
    public void callDependencyClassMethod() {
        DependencyClass dependencyClass = new DependencyClass();
        dependencyClass.doSomething();
    }

    interface IDependencyClass {
        void doSomething();
    }

    class DependencyClass implements IDependencyClass {
        @Override
        public void doSomething() {
            System.out.println("do something ...");
        }
    }
}
