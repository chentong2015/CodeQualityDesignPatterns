package behavior_pattern.visitor.model;

import behavior_pattern.visitor.visitor.ComputerPartVisitor;

public class Keyboard implements ComputerPart {

    // 原来实现的接口方法，可以能由于某种原因需要改变逻辑
    // 为了保证原有类型结构的稳定，将新的操作(算法)隔离出来，这时通过visitor访问类来实现
    @Override
    public void accept(ComputerPartVisitor visitor) {
        // 具体实现会交给具体Visitor来完成, 不同Visitor提供不同逻辑算法，但是不影响原始的类型结构
        visitor.visit(this);
    }
}
