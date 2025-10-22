package behavior_pattern.strategy.base2.model;

import behavior_pattern.strategy.base1.model.Employee;

public class FullTimeCalculator implements TaxCalculator {

    @Override
    public double calculate(Employee employee) {
        return employee.getWorkDays() * 1.5 + 100;
    }
}
