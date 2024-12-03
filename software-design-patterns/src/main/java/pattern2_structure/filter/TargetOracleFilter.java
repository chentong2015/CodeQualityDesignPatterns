package pattern2_structure.filter;

public class TargetOracleFilter extends Filter {

    private final Filter decorator;

    public TargetOracleFilter(Filter decorator) {
        this.decorator = decorator;
    }

    @Override
    public void updateAttributes() {
        decorator.updateAttributes();
        // // 过滤数据写入Oracle数据库
    }
}
