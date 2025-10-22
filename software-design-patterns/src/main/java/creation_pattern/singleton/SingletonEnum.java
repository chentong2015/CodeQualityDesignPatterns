package creation_pattern.singleton;

// TODO. 使用单元素的枚举类型来实现单列效果(最佳实践)
// 1. 线程安全: JVM保证枚举的实例只会被创建一次
// 2. 防反序列化破坏: 枚举的序列化机制天生防止单例被破坏
// 3. 防反射攻击: 无法通过反射再次实例化枚举
public class SingletonEnum {

    public static void main(String[] args) {
        SingletonInstanceHoler.Resource resource1 = SingletonInstanceHoler.SINGLETON_RESOURCE.getResource();
        SingletonInstanceHoler.Resource resource2 = SingletonInstanceHoler.SINGLETON_RESOURCE.getResource();

        System.out.println(resource1 == resource2);
        resource1.print();
    }

    // TODO. 始终只有一个元素类型持有唯一的单列对象
    enum SingletonInstanceHoler {
        SINGLETON_RESOURCE;

        private final Resource resource;

        // TODO. 可用访问嵌套类型的Private构造器
        SingletonInstanceHoler() {
            this.resource = new Resource();
        }

        public Resource getResource() {
            return resource;
        }

        class Resource {
            private Resource() {}

            public void print() {
                System.out.println("singleton resource");
            }
        }
    }
}
