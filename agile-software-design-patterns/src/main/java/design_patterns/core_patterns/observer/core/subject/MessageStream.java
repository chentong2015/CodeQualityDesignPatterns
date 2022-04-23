package design_patterns.core_patterns.observer.core.subject;

import java.util.ArrayList;
import java.util.List;

public class MessageStream extends Subject {

    private List<String> messages = new ArrayList<>();

    // 只要有任何更新的状态，则通知所有的观察者
    @Override
    public void setState(String message) {
        messages.add(message);
        this.notifyObservers();
    }

    @Override
    public String getState() {
        return messages.get(0);
    }
}
