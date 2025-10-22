package structure_pattern.flyweight;

import structure_pattern.flyweight.model.Circle;
import structure_pattern.flyweight.model.Shape;

import java.util.HashMap;
import java.util.Map;

// 统一管理程序中一致的对象，重用对象，如果不存在则创建对象
// Flyweight pattern is primarily used to reduce the number of objects created
// and to decrease memory footprint and increase performance.
//
// 应用场景:
// 1. 系统中存在大量的相似对象 / 对象象没有特定身份
// 2. 池化技术，数据库连接池，线程池
public class ShapeFlyweight {

    private static final Map<String, Shape> circleMap = new HashMap<>();

    // Flyweight pattern tries to reuse already existing similar kind objects by storing them
    // and creates new object when no matching object is found.
    public static Shape getCircle(String color) {
        Circle circle = (Circle) circleMap.get(color);
        if (circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color : " + color);
        }
        return circle;
    }
}
