package core_behavior_patterns.interpreter.model;

public interface Expression {

    // 对expression表达式的一种解释
    boolean interpret(String context);
}
