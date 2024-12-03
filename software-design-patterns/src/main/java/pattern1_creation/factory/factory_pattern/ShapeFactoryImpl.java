package pattern1_creation.factory.factory_pattern;

import pattern1_creation.factory.factory_pattern.model.Circle;
import pattern1_creation.factory.factory_pattern.model.IShape;
import pattern1_creation.factory.factory_pattern.model.Square;

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
