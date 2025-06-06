package design_patterns.pattern3_behavior.visitor.visitor;

import design_patterns.pattern3_behavior.visitor.model.Keyboard;
import design_patterns.pattern3_behavior.visitor.model.Monitor;

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
