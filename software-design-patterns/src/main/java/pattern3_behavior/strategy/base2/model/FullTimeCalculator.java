package pattern3_behavior.strategy.base2.model;

import pattern3_behavior.strategy.base1.model.Employee;

public class FullTimeCalculator implements TaxCalculator {

    @Override
    public double calculate(Employee employee) {
        return employee.getWorkDays() * 1.5 + 100;
    }
}
