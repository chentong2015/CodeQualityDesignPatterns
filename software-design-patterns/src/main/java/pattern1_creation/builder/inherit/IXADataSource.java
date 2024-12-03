package pattern1_creation.builder.inherit;

public interface IXADataSource extends IDataSource {

    String getXAUsage();

    class Builder extends IDataSource.Builder<Builder> {

        public Builder(String dbConfig) {
            super(dbConfig);
        }

        // 重写父类的build()方法，构建继承接口的实现对象(匿名类型)
        @Override
        public IXADataSource build() {
            return new IXADataSource() {
                @Override
                public String getXAUsage() {
                    return null;
                }

                @Override
                public String getDBConfig() {
                    return null;
                }

                @Override
                public boolean isHighAvailable() {
                    return false;
                }
            };
        }
    }
}
