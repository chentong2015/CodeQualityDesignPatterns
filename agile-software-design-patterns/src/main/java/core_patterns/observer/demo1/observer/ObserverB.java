package core_patterns.observer.demo1.observer;

import core_patterns.observer.demo1.subject.Observed;

public class ObserverB implements Observer {

    private Observed observed;

    public ObserverB(Observed observed) {
        this.observed = observed;
    }

    @Override
    public void update() {
        System.out.println("ObserverB gets new update number = " + observed.getSecretNumber());
    }
}
