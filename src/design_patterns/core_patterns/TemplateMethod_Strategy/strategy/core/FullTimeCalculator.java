package design_patterns.core_patterns.TemplateMethod_Strategy.strategy.core;

import design_patterns.core_patterns.TemplateMethod_Strategy.base.Employee;

public class FullTimeCalculator implements TaxCalculator {

    @Override
    public double calculate(Employee employee) {
        return employee.getWorkDays() * 1.5 + 100;
    }
}
