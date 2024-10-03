package patterns.behavior_patterns.strategy.demo1;

public abstract class ValidationStrategy {

    protected abstract boolean isValid(CreditCard creditCard);

    protected boolean checkCvvNumber() {
        // Use Common Algo
        return true;
    }
}
