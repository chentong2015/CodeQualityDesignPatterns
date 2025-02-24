package base_concepts.dependency_injection;

public class DependencyClass implements IDependencyClass {

    @Override
    public void doSomething() {
        System.out.println("do something ...");
    }
}
