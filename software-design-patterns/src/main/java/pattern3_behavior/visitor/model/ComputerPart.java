package pattern3_behavior.visitor.model;

import pattern3_behavior.visitor.visitor.ComputerPartVisitor;

public interface ComputerPart {

    void accept(ComputerPartVisitor visitor);

}
