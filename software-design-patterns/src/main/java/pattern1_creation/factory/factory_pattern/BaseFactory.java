package pattern1_creation.factory.factory_pattern;

import java.util.Calendar;
import java.util.TimeZone;

// Factory 工厂模式:
// 1. TODO: 不依赖具体的类型，而是依赖"抽象接口"来创建具体对象的实例
// 2. DIP依赖倒置原则，对系统中的易变类型都需要使用工厂模式
// 3. 如果有必要实现Proxy模式，则有可能创建工厂来创建持久化对象

// 工厂模式特点:
// 1. 使用工厂模式会创建额外的接口和实现类型
// 2. 工厂模式可以欺骗对象的创建者，使它无需依赖具体类型的实现
// 3. 不暴露对象实例化的过程和逻辑
// 4. 最好在一开始就完成设计，工厂模式不利于重构
public class BaseFactory {

    // 接口工厂的实现由main初始化创建出来, 负责Square和Circle的创建
    // 在应用的其他地方都不需要创建Square和Circle
    public void testMain() {
        // 创建具体使用的接口工厂
        ShapeFactoryImpl shapeFactory = new ShapeFactoryImpl();
        testShapeFactory(shapeFactory);
    }

    // 直接通过工厂获得具体类型，不依赖任何具体的类型
    public void testShapeFactory(IShapeFactory shapeFactory) {
        // IShape square = shapeFactory.makeSquare();
        // IShape circle = shapeFactory.makeCircle();
        // System.out.println(circle.getShapeName());
    }

    // Calender 根据不同的参数，返回指定构建的对象实例
    // ResourceBundle
    // NumberFormat
    private void testJavaFactoryType() {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar1 = Calendar.getInstance(TimeZone.getDefault());
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
    }
}
