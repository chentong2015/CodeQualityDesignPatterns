package structure_pattern.proxy.static_proxy;

public class Bird implements Animal {

    @Override
    public void eatFood(String foodName) {
        System.out.println("Tiger eats " + foodName);
    }

    @Override
    public boolean running() {
        System.out.println("Tiger is running ...");
        return true;
    }
}
