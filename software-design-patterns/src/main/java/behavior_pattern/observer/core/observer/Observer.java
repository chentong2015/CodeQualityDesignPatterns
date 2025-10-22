package behavior_pattern.observer.core.observer;

import behavior_pattern.observer.core.subject.Subject;

public abstract class Observer {

    protected Subject subject;

    public abstract void update();
}
