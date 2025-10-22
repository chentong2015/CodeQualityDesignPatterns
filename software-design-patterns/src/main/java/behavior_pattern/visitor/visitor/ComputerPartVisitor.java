package behavior_pattern.visitor.visitor;

import behavior_pattern.visitor.model.Keyboard;
import behavior_pattern.visitor.model.Monitor;

// 在Visitor中使用方法重载来处理不同类型的算法逻辑
public interface ComputerPartVisitor {

    void visit(Monitor monitor);

    void visit(Keyboard keyboard);
}
