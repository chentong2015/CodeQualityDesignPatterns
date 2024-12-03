package pattern3_behavior.state_machine.model;

// Context: 一个状态的上下文
public class Context {

    private State state;

    // 初始状态为空
    public Context() {
        state = null;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}
