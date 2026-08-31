package pattern_behavior.visitor.model;

import pattern_behavior.visitor.visitor.ComputerPartVisitor;

public class Monitor implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor visitor) {
        visitor.visit(this);
    }
}
