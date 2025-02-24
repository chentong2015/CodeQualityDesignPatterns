package design_patterns.pattern3_behavior.visitor.model;

import design_patterns.pattern3_behavior.visitor.visitor.ComputerPartVisitor;

public interface ComputerPart {

    void accept(ComputerPartVisitor visitor);

}
