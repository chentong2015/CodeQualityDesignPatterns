package base_concepts.dependency_injection;

// Dependency Injection: 设计原则，开发模式
// 1. 将紧耦合的关系改成松耦合的关系
// 2. 将对具体类型的依赖改成依赖抽象类型
//    依赖接口类型，从而提高软件程序的可扩展性: 避免程序或者组件移动时造成的问题
// 3. 将要依赖的底层资源，通过构造器传递
//    适配多个底层资源，并且提升可重用性和可测试性
public class BaseIoC {

    private final IDependencyClass iDependencyClass;

    // TODO. 在创建新实例时，将要依赖的对象传入构造器中，将依赖的对象inject到对象中
    //  或者将资源工厂传递给构造器，使用工厂来创建对象依赖的资源
    public BaseIoC(IDependencyClass iDependencyClass) {
        this.iDependencyClass = iDependencyClass;
    }

    // 与DependencyClass形成紧耦合的关系
    // 1. 当类型发生移动时，也必须移动组件和依赖
    // 2. 如果想使用别的类型(的功能)，必须要修改这个类里面的成员，违反了OCP原则
    public void callDependencyClassMethod() {
        DependencyClass dependencyClass = new DependencyClass();
        dependencyClass.doSomething();
    }
}
