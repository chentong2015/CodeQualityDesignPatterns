package core_behavior_patterns.observer.demo1.observer;

import core_behavior_patterns.observer.demo1.subject.Observed;

public class ObserverA implements Observer {

    // 指明要观察的对象
    private Observed observed;

    public ObserverA(Observed observed) {
        this.observed = observed;
    }

    @Override
    public void update() {
        System.out.println("ObserverA gets new update number = " + observed.getSecretNumber());
    }
}
