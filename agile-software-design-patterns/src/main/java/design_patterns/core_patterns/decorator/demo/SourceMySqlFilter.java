package design_patterns.core_patterns.decorator.demo;

public class SourceMySqlFilter extends Filter {

    private final Filter decorator;

    public SourceMySqlFilter(Filter decorator) {
        this.decorator = decorator;
    }

    @Override
    public void updateAttributes() {
        decorator.updateAttributes();
        // 过滤从MySQL中提取的数据
    }
}
