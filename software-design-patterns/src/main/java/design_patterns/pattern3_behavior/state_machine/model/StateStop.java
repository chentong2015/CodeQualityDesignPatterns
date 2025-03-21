package design_patterns.pattern3_behavior.state_machine.model;

public class StateStop implements State {

    public void doAction(Context context) {
        context.setState(this);
        System.out.println("Player is in stop state");
    }

    public String toString() {
        return "Stop State";
    }
}
