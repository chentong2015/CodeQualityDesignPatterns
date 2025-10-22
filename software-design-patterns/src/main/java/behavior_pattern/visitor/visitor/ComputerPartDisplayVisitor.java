package behavior_pattern.visitor.visitor;

import behavior_pattern.visitor.model.Keyboard;
import behavior_pattern.visitor.model.Monitor;

public class ComputerPartDisplayVisitor implements ComputerPartVisitor {

    @Override
    public void visit(Monitor monitor) {
        System.out.println("Monitor: another algo");
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("Keyboard: another algo");
    }
}
