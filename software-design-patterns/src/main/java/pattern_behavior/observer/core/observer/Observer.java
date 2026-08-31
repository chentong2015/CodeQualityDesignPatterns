package pattern_behavior.observer.core.observer;

import pattern_behavior.observer.core.subject.Subject;

public abstract class Observer {

    protected Subject subject;

    public abstract void update();
}
