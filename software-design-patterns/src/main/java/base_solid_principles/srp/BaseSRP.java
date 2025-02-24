package base_solid_principles.srp;

// SRP 单一职责
// Single Responsibility Principles
// Every function, class or module has only one raison to change
// 处理数据，发送Http请求，生成报告
public class BaseSRP {

    // Identifying Multiple Reasons to Change: 注意职责和功能的划分, 引起改变的原因
    // 1. If-Statement
    // 2. Switch-Statement
    // 3. Monster Methods
    // 4. God Class
    // 5. People

    // The Danger of Multiple Responsibilities:
    // 1. Harder to Read
    // 2. Poor Quality
    // 3. Unexpected Behaviour
    // 4. High Coupling

    // IWork SRP:
    // 1. 提取class, function, module中多个原因改变的集中的地方
    // 2. 抽离到不同的局部中，变得短小，使得改变容易且减少相互间依赖
}
