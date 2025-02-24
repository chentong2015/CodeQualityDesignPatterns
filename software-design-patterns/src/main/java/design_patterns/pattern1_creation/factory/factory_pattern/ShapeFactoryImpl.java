package design_patterns.pattern1_creation.factory.factory_pattern;

import design_patterns.pattern1_creation.factory.factory_pattern.model.Circle;
import design_patterns.pattern1_creation.factory.factory_pattern.model.Square;
import design_patterns.pattern1_creation.factory.factory_pattern.model.IShape;

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
