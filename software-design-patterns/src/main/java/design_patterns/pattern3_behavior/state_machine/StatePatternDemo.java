package design_patterns.pattern3_behavior.state_machine;

import design_patterns.pattern3_behavior.state_machine.model.StateStart;
import design_patterns.pattern3_behavior.state_machine.model.Context;
import design_patterns.pattern3_behavior.state_machine.model.StateStop;

// State状态机: 描述有限状态之间的切换(嵌套switch/case语句)
public class StatePatternDemo {

    // 创建表示各种状态的对象和一个行为随着状态对象改变而改变的context对象
    public static void main(String[] args) {
        Context context = new Context();

        StateStart startState = new StateStart();
        startState.doAction(context);
        System.out.println(context.getState().toString());

        StateStop stopState = new StateStop();
        stopState.doAction(context);
        System.out.println(context.getState().toString());
    }
}
