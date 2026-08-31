package pattern_creation.singleton;

// TODO. 最佳实践: 单元素的枚举类型实现单列
// 1. 线程安全: JVM保证枚举的实例只会被创建一次
// 2. 防反序列化破坏: 枚举的序列化机制天生防止单例被破坏
// 3. 防反射攻击: 无法通过反射再次实例化枚举
public enum SingletonHolderEnum {

    SINGLETON_RESOURCE;

    private final Resource resource;

    // TODO. 可用访问嵌套类型的Private构造器
    SingletonHolderEnum() {
        this.resource = new Resource();
    }

    public Resource getResource() {
        return resource;
    }


    // TODO. 该嵌套类只能由唯一实例，被外层Enum类型实例所调用
    class Resource {
        private Resource() {}

        public void print() {
            System.out.println("singleton resource");
        }
    }
}
