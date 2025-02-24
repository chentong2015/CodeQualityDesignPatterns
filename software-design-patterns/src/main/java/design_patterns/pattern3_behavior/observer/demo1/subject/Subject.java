package design_patterns.pattern3_behavior.observer.demo1.subject;

import design_patterns.pattern3_behavior.observer.demo1.observer.Observer;

import java.util.ArrayList;
import java.util.List;

// 观察者通过Subject抽象类注册到被观察者中
// 可以注册观察者，也可以移除观察者
public abstract class Subject {

    List<Observer> observers = new ArrayList<>();

    public void register(Observer observer) {
        observers.add(observer);
    }

    protected void notifyAllObservers() {
        // 通知所有的观察者，更新观察者的状态
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
