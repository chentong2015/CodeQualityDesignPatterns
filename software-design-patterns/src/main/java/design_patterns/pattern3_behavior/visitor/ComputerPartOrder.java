package design_patterns.pattern3_behavior.visitor;

import design_patterns.pattern3_behavior.visitor.model.ComputerPart;
import design_patterns.pattern3_behavior.visitor.visitor.ComputerPartVisitor;

import java.util.ArrayList;
import java.util.List;

public class ComputerPartOrder {

    private List<ComputerPart> partList = new ArrayList<>();

    public void addPart(ComputerPart part) {
        partList.add(part);
    }

    // TODO: Visitor模式使用规范
    // 1. 所有的ComputerPart都accept()同一个具体的AtvPartVisitor
    // 2. 所有的ComputerPart accept()方法中都调用重载方法中的一个，实现各种的逻辑
    // 3. 数据结构的呈现和具体算法之间相互独立
    public void accept(ComputerPartVisitor visitor) {
        for (ComputerPart part : partList) {
            part.accept(visitor);
        }
    }
}
