package design_patterns.pattern3_behavior.observer.core.observer;

import design_patterns.pattern3_behavior.observer.core.subject.Subject;

public abstract class Observer {

    protected Subject subject;

    public abstract void update();
}
