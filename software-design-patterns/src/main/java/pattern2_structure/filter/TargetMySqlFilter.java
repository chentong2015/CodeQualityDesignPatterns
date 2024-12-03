package pattern2_structure.filter;

public class TargetMySqlFilter extends Filter {

    private final Filter decorator;

    public TargetMySqlFilter(Filter decorator) {
        this.decorator = decorator;
    }

    @Override
    public void updateAttributes() {
        decorator.updateAttributes();
        // 过滤数据写入MySQL数据库
    }
}
