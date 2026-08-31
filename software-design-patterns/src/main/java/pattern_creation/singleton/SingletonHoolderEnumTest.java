package pattern_creation.singleton;

public class SingletonHoolderEnumTest {

    // 外层可以看到Resource类型，但却无法创建它的实例
    public static void main(String[] args) {
        SingletonHolderEnum.Resource resource1 = SingletonHolderEnum.SINGLETON_RESOURCE.getResource();
        SingletonHolderEnum.Resource resource2 = SingletonHolderEnum.SINGLETON_RESOURCE.getResource();

        System.out.println(resource1 == resource2); // true
        resource1.print();
    }
}