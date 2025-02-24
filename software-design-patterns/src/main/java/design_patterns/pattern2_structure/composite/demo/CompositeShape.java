package design_patterns.pattern2_structure.composite.demo;

import java.util.ArrayList;
import java.util.List;

public class CompositeShape implements Shape {

    // 包容一致对象的列表，方便一致的处理
    private List<Shape> itsShapes = new ArrayList<>();

    public void addShape(Shape shape) {
        itsShapes.add(shape);
    }

    // 最终通过Composite中一个方法，批量的"对待"组合中的对象
    // 循环遍历的代码只是在Composite组合类中出现一次
    @Override
    public void draw() {
        for (Shape shape : itsShapes) {
            shape.draw();
        }
    }
}
