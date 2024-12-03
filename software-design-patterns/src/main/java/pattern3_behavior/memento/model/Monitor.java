package pattern3_behavior.memento.model;

public class Monitor {

    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    // 保存当前的状态到备忘录
    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    // 恢复到备忘录的一个指定状态
    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}
