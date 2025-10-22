package creation_pattern.builder.inherit;

public interface IDataSource {

    String getDBConfig();

    boolean isHighAvailable();

    class Builder<T extends Builder<T>> {

        private String dbConfig;
        private boolean isHighAvailable;

        public Builder(String DBConfig) {
            this.dbConfig = DBConfig;
            this.isHighAvailable = false;
        }

        public T highAvailable(boolean isHighAvailable) {
            this.isHighAvailable = isHighAvailable;
            return (T) this;
        }

        // 构建实现IDataSource接口的类型(匿名类型)的对象
        public IDataSource build() {
            return new IDataSource() {
                @Override
                public String getDBConfig() {
                    return dbConfig;
                }

                @Override
                public boolean isHighAvailable() {
                    return isHighAvailable;
                }
            };
        }
    }
}
