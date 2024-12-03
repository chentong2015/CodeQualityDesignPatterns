package pattern3_behavior.visitor.visitor;

import pattern3_behavior.visitor.model.Keyboard;
import pattern3_behavior.visitor.model.Monitor;

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
