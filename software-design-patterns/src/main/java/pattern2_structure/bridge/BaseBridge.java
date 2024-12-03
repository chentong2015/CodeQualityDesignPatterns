package pattern2_structure.bridge;

import pattern2_structure.bridge.model.Circle;
import pattern2_structure.bridge.model.GreenCircle;
import pattern2_structure.bridge.model.RedCircle;
import pattern2_structure.bridge.model.Shape;

// Bridge is used to decouple an abstraction from its implementation so that they can vary independently
// 适用在类型的结构层次具有多个自由度，比如拆分与和并不同策略
public class BaseBridge {

    public static void main(String[] args) {
        // 创建Circle对象的时候，传递实现DrawAPI的具体实例
        Shape redCircle = new Circle(100, 100, 10, new RedCircle());
        Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}
