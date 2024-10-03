package patterns.behavior_patterns.strategy.base2;

import patterns.behavior_patterns.strategy.base1.model.Employee;
import patterns.behavior_patterns.strategy.base1.model.FullTimeEmployee;
import patterns.behavior_patterns.strategy.base1.model.PartTimeEmployee;
import patterns.behavior_patterns.strategy.base2.model.FullTimeCalculator;
import patterns.behavior_patterns.strategy.base2.model.InternCalculator;
import patterns.behavior_patterns.strategy.base2.model.PartTimeCalculator;
import patterns.behavior_patterns.strategy.base2.model.TaxCalculator;

// 使用工厂模式来构建指定的实例对象
// 1. 工程模式同样需要建立Factory interface
// 2. 对于每一个新增，只需要添加一个新的类型，而不会对原有的架构造影响
public class TaxCalculatorFactory {

    public static TaxCalculator create(Employee employee) {
        if (employee instanceof FullTimeEmployee) {
            return new FullTimeCalculator();
        } else if (employee instanceof PartTimeEmployee) {
            return new PartTimeCalculator();
        } else {
            return new InternCalculator();
        }
    }
}
