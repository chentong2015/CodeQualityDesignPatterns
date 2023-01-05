package core_patterns.strategy.core.impl;

import core_patterns.strategy.base.model.Employee;
import core_patterns.strategy.core.model.TaxCalculator;

public class PartTimeCalculator implements TaxCalculator {

    @Override
    public double calculate(Employee employee) {
        return employee.getWorkDays() * 1.0 + 50;
    }
}