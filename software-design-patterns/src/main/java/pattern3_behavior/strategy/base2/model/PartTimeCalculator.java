package pattern3_behavior.strategy.base2.model;

import pattern3_behavior.strategy.base1.model.Employee;

public class PartTimeCalculator implements TaxCalculator {

    @Override
    public double calculate(Employee employee) {
        return employee.getWorkDays() * 1.0 + 50;
    }
}
