package design_patterns.pattern3_behavior.observer.demo1;

import design_patterns.pattern3_behavior.observer.demo1.observer.ObserverA;
import design_patterns.pattern3_behavior.observer.demo1.observer.ObserverB;
import design_patterns.pattern3_behavior.observer.demo1.subject.Observed;

// 当一个对象被修改时，则会自动通知依赖它的对象
// Observer pattern is used when there is one-to-many relationship between objects
// if one object is modified, its dependent objects are to be notified automatically.

// 多用于实现订阅功能的场景, 订阅某账号后, 自动收到通知
public class DemoObserverPattern {

    public static void main(String[] args) {
        // 被观察者
        Observed observedObject = new Observed();

        // 观察者
        ObserverA observerA = new ObserverA(observedObject);
        ObserverB observerB = new ObserverB(observedObject);

        // 注册: 指定观察者观察"被观察者"
        observedObject.register(observerA);
        observedObject.register(observerB);

        observedObject.change();
    }
}
