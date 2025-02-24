package design_patterns.pattern3_behavior.interpreter;

import design_patterns.pattern3_behavior.interpreter.model.Expression;
import design_patterns.pattern3_behavior.interpreter.model.OrExpression;
import design_patterns.pattern3_behavior.interpreter.model.AndExpression;
import design_patterns.pattern3_behavior.interpreter.model.SubstrExpression;

public class InterpreterPatternDemo {

    public static void main(String[] args) {
        // Rule: Robert and John are male
        Expression isMale = new OrExpression(new SubstrExpression("Robert"), new SubstrExpression("John"));
        // Rule: Julie is a married women
        Expression isMarriedWoman = new AndExpression(new SubstrExpression("Julie"), new SubstrExpression("married"));

        // TODO. 下面的表达是需要(翻译)解释的
        System.out.println(isMale.interpret("John is male ?"));
        System.out.println(isMale.interpret("Victor is male ?"));
        System.out.println(isMarriedWoman.interpret("Julie is a married women ?"));
    }
}
