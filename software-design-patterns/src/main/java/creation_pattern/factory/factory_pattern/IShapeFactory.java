package creation_pattern.factory.factory_pattern;

import creation_pattern.factory.factory_pattern.model.IShape;

// 1. A factory method is a non-constructor operation that creates and returns class instances
// 2. Widely used in mid-level design patterns and in object-oriented programming
// 3. Create new instances using constructors or cloning,
//    not rely on any special technique for class instantiation
public interface IShapeFactory {

    // 为了避免每添加一个IShape的实现类型，都需要修改接口工厂
    // 1. 通过传递"类型名称"来实现通用的对象的创建
    // 2. 将"类型名称"设计成枚举类型
    // IShape make(String shapeName) throws Exception;

    IShape makeSquare();

    IShape makeCircle();
}
