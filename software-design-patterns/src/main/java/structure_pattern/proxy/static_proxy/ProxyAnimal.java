package structure_pattern.proxy.static_proxy;

// 该类型可以代理任何实现Animal接口的类型，隔离了对实现类型的直接调用
public class ProxyAnimal implements Animal {

    private Animal animal;

    public ProxyAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public void eatFood(String foodName) {
        animal.eatFood(foodName);
    }

    @Override
    public boolean running() {
        return animal.running();
    }
}
