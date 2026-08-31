package pattern_behavior.visitor.model;

import pattern_behavior.visitor.visitor.ComputerPartVisitor;

public interface ComputerPart {

    void accept(ComputerPartVisitor visitor);

}
