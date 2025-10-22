package behavior_pattern.memento;

import behavior_pattern.memento.model.MementoContainer;
import behavior_pattern.memento.model.Monitor;

public class MementoPatternDemo {

    public static void main(String[] args) {
        MementoContainer container = new MementoContainer();

        Monitor monitor = new Monitor();
        monitor.setState("State #1");
        monitor.setState("State #2");
        // 保存当前的状态到备忘录中
        container.add(monitor.saveStateToMemento());
        monitor.setState("State #3");
        container.add(monitor.saveStateToMemento());
        monitor.setState("State #4");

        System.out.println("Current State: " + monitor.getState());
        monitor.getStateFromMemento(container.get(0));
        System.out.println("First saved State: " + monitor.getState());
        monitor.getStateFromMemento(container.get(1));
        System.out.println("Second saved State: " + monitor.getState());
    }
}
