package design_patterns.pattern3_behavior.strategy.base2.model;

import design_patterns.pattern3_behavior.strategy.base1.model.Employee;

public class InternCalculator implements TaxCalculator {

    @Override
    public double calculate(Employee employee) {
        return 1.0;
    }
}
