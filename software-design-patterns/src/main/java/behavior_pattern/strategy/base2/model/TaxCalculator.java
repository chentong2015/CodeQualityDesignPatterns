package behavior_pattern.strategy.base2.model;

import behavior_pattern.strategy.base1.model.Employee;

public interface TaxCalculator {

    double calculate(Employee employee);
}
