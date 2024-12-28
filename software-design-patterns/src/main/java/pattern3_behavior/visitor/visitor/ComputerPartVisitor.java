package pattern3_behavior.visitor.visitor;

import pattern3_behavior.visitor.model.Keyboard;
import pattern3_behavior.visitor.model.Monitor;

// 在Visitor中使用方法重载来处理不同类型的算法逻辑
public interface ComputerPartVisitor {

    void visit(Monitor monitor);

    void visit(Keyboard keyboard);
}