package behavior_pattern.interpreter.model;

public interface Expression {

    // 对expression表达式的一种解释
    boolean interpret(String context);
}
