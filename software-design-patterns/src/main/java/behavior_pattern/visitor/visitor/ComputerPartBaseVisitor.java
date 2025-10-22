package behavior_pattern.visitor.visitor;

import behavior_pattern.visitor.model.Keyboard;
import behavior_pattern.visitor.model.Monitor;

public class ComputerPartBaseVisitor implements ComputerPartVisitor {

    double amount = 0;

    @Override
    public void visit(Monitor monitor) {
        amount += 3.0;
    }

    @Override
    public void visit(Keyboard keyboard) {
        amount += 5.0;
    }
}
