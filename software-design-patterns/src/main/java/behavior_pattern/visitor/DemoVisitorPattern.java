package behavior_pattern.visitor;

import behavior_pattern.visitor.model.Keyboard;
import behavior_pattern.visitor.model.Monitor;
import behavior_pattern.visitor.visitor.ComputerPartBaseVisitor;
import behavior_pattern.visitor.visitor.ComputerPartDisplayVisitor;

// Visitor Pattern: 访问者类可以改变原始类型层次的执行算法
// Separate an algorithm from an object structure
// Visitor class can change the executing algorithm of an element class.

// 应用场景:
// 1. 对象结构比较稳定，但经常需要在此对象结构上定义新的操作，执行不同的逻辑算法
// 2. 需要对一个对象结构中的对象进行很多不同的并且不相关的操作，而需要避免这些操作“污染”这些对象的类，也不希望在增加新操作时修改这些类
// 3. 为数据结构/类型层次生成不同类型的报表，结构层次不因新添加的报表类型而改变
public class DemoVisitorPattern {

    public static void main(String[] args) {
        ComputerPartOrder order = new ComputerPartOrder();
        order.addPart(new Monitor());
        order.addPart(new Keyboard());

        // 新增一个新的Visitor时，对原有的数据结构没有任何的影响
        // 不同的Visitor中实现不同的逻辑，包含全部的不同类型
        order.accept(new ComputerPartBaseVisitor());
        order.accept(new ComputerPartDisplayVisitor());
    }
}
