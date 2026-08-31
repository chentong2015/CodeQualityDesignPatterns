package pattern_creation.factory.factory_pattern;

import pattern_creation.factory.factory_pattern.model.Circle;
import pattern_creation.factory.factory_pattern.model.Square;
import pattern_creation.factory.factory_pattern.model.IShape;

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
