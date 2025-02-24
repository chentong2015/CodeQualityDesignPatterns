package design_patterns.pattern1_creation.builder.inherit;

public class DemoProjectBuilder {

    public static void main(String[] args) {
        String dbConfig = "db config";
        // 调用IDataSource中的Builder构造器，需要设置<>标识泛型
        IDataSource iDataSource = new IDataSource.Builder<>(dbConfig).build();
        System.out.println(iDataSource);

        // 使用IXADataSource则不需要泛型
        IXADataSource ixaDataSource = new IXADataSource.Builder(dbConfig).build();
        System.out.println(ixaDataSource);
    }
}
