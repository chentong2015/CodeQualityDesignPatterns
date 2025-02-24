package design_patterns.pattern3_behavior.observer.demo1.subject;

public class Observed extends Subject {

    private int number;

    // 观察者从被观察者中"拉出数据"
    public int getSecretNumber() {
        return number;
    }

    // 在任何时候，被观察者发生变化时，立即通过其所有的注册观察者
    public void change() {
        System.out.println("Observed Object changes ...");
        number = 10;
        notifyAllObservers();
    }
}
