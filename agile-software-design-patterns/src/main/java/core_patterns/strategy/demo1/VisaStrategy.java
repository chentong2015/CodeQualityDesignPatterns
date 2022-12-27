package core_patterns.strategy.demo1;

public class VisaStrategy extends ValidationStrategy {

    @Override
    protected boolean isValid(CreditCard creditCard) {
        return creditCard.getNumber().startsWith("78");
    }
}
