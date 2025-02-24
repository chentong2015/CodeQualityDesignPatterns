package design_patterns.pattern2_structure.decorator;

import design_patterns.pattern2_structure.decorator.demo.IClass;
import design_patterns.pattern2_structure.decorator.demo.IClassDecorator;
import design_patterns.pattern2_structure.decorator.demo.SubClassA;
import design_patterns.pattern2_structure.decorator.wrapper.ForwardingSet;
import design_patterns.pattern2_structure.decorator.wrapper.InstrumentedSet;

import java.util.HashSet;
import java.util.List;

// 动态的将新功能附加到对象上，就像打包一个快递，一层一层地给物品添加外层包装
//
// 应用场景:
// 1. 扩展一个类的功能
// 2. 动态增加功能，动态撤销 / 修改方法的实现逻辑
public class DemoDecorator {

    public static void main(String[] args) {
        // IClass iClass = new SubClassA();
        IClass iClass = new IClassDecorator(new SubClassA());
        iClass.print();

        // 将Set<E>的实现类HashSet<>包装到ForwardingSet中
        ForwardingSet<String> wrapperSet = new ForwardingSet<>(new HashSet<>());
        InstrumentedSet<String> instrumentedSet = new InstrumentedSet<>(wrapperSet);

        instrumentedSet.addAll(List.of("aa", "bb", "cc"));
        System.out.println(instrumentedSet.getAddCount());
    }
}
