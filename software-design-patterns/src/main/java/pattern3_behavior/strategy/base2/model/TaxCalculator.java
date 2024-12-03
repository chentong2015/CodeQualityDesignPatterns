package pattern3_behavior.strategy.base2.model;

import pattern3_behavior.strategy.base1.model.Employee;

public interface TaxCalculator {

    double calculate(Employee employee);
}
