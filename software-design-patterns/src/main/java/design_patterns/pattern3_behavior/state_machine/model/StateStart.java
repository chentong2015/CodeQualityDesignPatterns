package design_patterns.pattern3_behavior.state_machine.model;

public class StateStart implements State {

    // 更新context中的状态
    public void doAction(Context context) {
        context.setState(this);
        System.out.println("Player is in start state");
    }

    public String toString() {
        return "Start State";
    }
}
