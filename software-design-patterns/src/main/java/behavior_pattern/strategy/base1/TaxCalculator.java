package behavior_pattern.strategy.base1;

import behavior_pattern.strategy.base1.model.Employee;
import behavior_pattern.strategy.base1.model.FullTimeEmployee;
import behavior_pattern.strategy.base1.model.PartTimeEmployee;

public class TaxCalculator {

    // 对于如下的方法：
    // 如果要新增一种类型的计算方式，则必须添加新判断条件
    // 导致方法不断扩充和增加异常的风险，引起更多的依赖问题

    // TODO: 两种解决方法
    // 1. 使用继承来重新提供一个计算的类型，重新该方法
    // 2. 使用Strategy策略模式，通过接口来实现扩充
    public double calculate(Employee employee) {
        double tax;
        if (employee instanceof FullTimeEmployee) {
            tax = employee.getWorkDays() * 1.5 + 100;
        } else if (employee instanceof PartTimeEmployee) {
            tax = employee.getWorkDays() * 0.5 + 10;
        } else {
            tax = 1.0;
        }
        return tax;
    }
}
