package design_patterns.pattern2_structure.filter;

// 所有继承Filter的类型都拥有一个自己的过滤器
// Filter decorator = new Filter();
// decorator = new SourceMySqlFilter(decorator);
// decorator = new TargetOracleFilter(decorator);
public class Filter {

    // 上层API, 针对数据的提取和写入做属性的适配
    public void updateAttributes() {
        // to adapt table attributes
    }
}
