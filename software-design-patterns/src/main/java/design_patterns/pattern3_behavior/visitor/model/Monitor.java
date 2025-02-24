package design_patterns.pattern3_behavior.visitor.model;

import design_patterns.pattern3_behavior.visitor.visitor.ComputerPartVisitor;

public class Monitor implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor visitor) {
        visitor.visit(this);
    }
}
