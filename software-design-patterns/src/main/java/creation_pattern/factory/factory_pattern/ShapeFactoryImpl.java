package creation_pattern.factory.factory_pattern;

import creation_pattern.factory.factory_pattern.model.Circle;
import creation_pattern.factory.factory_pattern.model.Square;
import creation_pattern.factory.factory_pattern.model.IShape;

public class ShapeFactoryImpl implements IShapeFactory {

    @Override
    public IShape makeSquare() {
        return new Square();
    }

    @Override
    public IShape makeCircle() {
        return new Circle();
    }
}
