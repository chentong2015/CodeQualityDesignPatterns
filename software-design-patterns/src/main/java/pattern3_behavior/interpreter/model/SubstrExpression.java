package pattern3_behavior.interpreter.model;

public class SubstrExpression implements Expression {

    private String data;

    public SubstrExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        return context.contains(data);
    }
}
