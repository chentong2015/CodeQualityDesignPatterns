package design_patterns.pattern3_behavior.strategy.base2.model;

import design_patterns.pattern3_behavior.strategy.base1.model.Employee;

public class PartTimeCalculator implements TaxCalculator {

    @Override
    public double calculate(Employee employee) {
        return employee.getWorkDays() * 1.0 + 50;
    }
}
