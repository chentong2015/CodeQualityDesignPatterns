package behavior_pattern.visitor.model;

import behavior_pattern.visitor.visitor.ComputerPartVisitor;

public interface ComputerPart {

    void accept(ComputerPartVisitor visitor);

}
