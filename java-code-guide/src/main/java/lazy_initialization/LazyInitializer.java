package lazy_initialization;

// 自定义任何类型的懒加载器: 只有在需要对象的时候才创建对象
// 所有继承该抽象类型的类型都具有懒加载的特性
public abstract class LazyInitializer<T> {

    private T instance;

    public synchronized T get() {
        if (instance == null) {
            instance = makeInstance();
        }
        return instance;
    }

    // 创建实例的细节交给具体的类型去实现
    protected abstract T makeInstance();

    public synchronized boolean isInitialized() {
        return instance != null;
    }
}
