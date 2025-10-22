package structure_pattern.proxy.static_proxy;

// 静态代理：
// 1. 在"编译时"确定, 无需反射, 必须为每个被代理对象创建一个代理类
// 2. 接口一旦新增加方法, 目标对象和代理对象都要进行修改
public class TestStaticProxy {

    public void testStaticProxy() {
        // 直接调用
        Bird bird = new Bird();
        bird.running();

        // 通过代理间接调用
        Animal proxy = new ProxyAnimal(bird);
        proxy.running();
    }
}
