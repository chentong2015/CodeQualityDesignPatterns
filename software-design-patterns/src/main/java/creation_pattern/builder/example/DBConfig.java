package creation_pattern.builder.example;

import java.util.Collections;
import java.util.Map;

// 实战项目: 多参数标准builder模式的运行
public class DBConfig {

    private final String logicalName;
    private final String configFile;
    private final String driver;
    private final String driverClass;
    private final String xaDataSourceClass;
    private final String hostName;
    private final int portNumber;
    private final String databaseOrSchemaName;
    private final String serverOrServiceName;
    private final String url;
    private final String user;
    private final DbPassword password;
    private final String characterSet;
    private final int maxPoolSize;
    private final int packetSize;
    private final int connectionTimeOut;
    private final int maxConnectionReuseCount;
    private final long maxConnectionReuseTime;
    private final Map<String, String> properties;
    private final int socketTimeout;

    private DBConfig(Builder builder) {
        this.logicalName = builder.logicalName;
        this.configFile = builder.configFile;
        this.driver = builder.driver;
        this.driverClass = builder.driverClass;
        this.xaDataSourceClass = builder.xaDataSourceClass;
        this.hostName = builder.host;
        this.portNumber = builder.port;
        this.databaseOrSchemaName = builder.databaseOrSchema;
        this.serverOrServiceName = builder.serverOrService;
        this.url = builder.url;
        this.user = builder.user;
        this.password = builder.password;
        this.characterSet = builder.characterSet;
        this.maxPoolSize = builder.maxPoolSize;
        this.packetSize = builder.packetSize;
        this.connectionTimeOut = builder.connectionTimeOut;
        this.maxConnectionReuseCount = builder.maxConnectionReuseCount;
        this.maxConnectionReuseTime = builder.maxConnectionReuseTime;
        this.properties = builder.properties;
        this.socketTimeout = builder.socketTimeout;
    }

    public String getLogicalName() {
        return logicalName;
    }

    public String getConfigFile() {
        return configFile;
    }

    public String getDriver() {
        return driver;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public String getXADataSourceClass() {
        return xaDataSourceClass;
    }

    public String getHostName() {
        return hostName;
    }

    public int getPortNumber() {
        return portNumber;
    }

    public String getDatabaseOrSchemaName() {
        return databaseOrSchemaName;
    }

    public String getServerOrServiceName() {
        return serverOrServiceName;
    }

    public String getURL() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getRawPassword() {
        return password.getRawPassword();
    }

    public String getPassword() {
        return password.getPassword();
    }

    public String getCharacterSet() {
        return characterSet;
    }

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public int getPacketSize() {
        return packetSize;
    }

    public int getConnectionTimeOut() {
        return connectionTimeOut;
    }

    public int getMaxConnectionReuseCount() {
        return maxConnectionReuseCount;
    }

    public long getMaxConnectionReuseTime() {
        return maxConnectionReuseTime;
    }

    public Map<String, String> getProperties() {
        return (properties != null) ? Collections.unmodifiableMap(properties) : null;
    }

    public int getSocketTimeout() {
        return socketTimeout;
    }

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Nested Classes 
    //~ ----------------------------------------------------------------------------------------------------------------

    private static class DbPassword {

        private final String mDBPassword;
        private final boolean mCrypted;

        DbPassword(String password, boolean encrypted) {
            this.mDBPassword = password;
            this.mCrypted = encrypted;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("password ");
            builder.append("(Crypted:").append(mCrypted ? "Y" : "N").append(")");
            builder.append(": ");
            builder.append("'").append(mDBPassword).append("'");
            return builder.toString();
        }

        String getRawPassword() {
            return mDBPassword;
        }

        String getPassword() {
            return mDBPassword;
        }
    }

    public static class Builder {

        private int socketTimeout;
        private String logicalName;
        private String configFile;
        protected String driver;
        private String driverClass;
        private String xaDataSourceClass;
        protected String host;
        protected int port;
        protected String databaseOrSchema;
        protected String serverOrService;
        private String url;
        private String user;
        private DbPassword password;
        protected String characterSet;
        private int maxPoolSize = 8;
        private int packetSize;
        private int connectionTimeOut = 240000;
        private int maxConnectionReuseCount = 0;
        private long maxConnectionReuseTime = 0;
        private Map<String, String> properties;

        public Builder(DBConfig dbConfig) {
            this.logicalName = dbConfig.logicalName;
            this.configFile = dbConfig.configFile;
            this.driver = dbConfig.driver;
            this.driverClass = dbConfig.driverClass;
            this.xaDataSourceClass = dbConfig.xaDataSourceClass;
            this.host = dbConfig.hostName;
            this.port = dbConfig.portNumber;
            this.databaseOrSchema = dbConfig.databaseOrSchemaName;
            this.serverOrService = dbConfig.serverOrServiceName;
            this.url = dbConfig.url;
            this.user = dbConfig.user;
            this.password = dbConfig.password;
            this.characterSet = dbConfig.characterSet;
            this.maxPoolSize = dbConfig.maxPoolSize;
            this.packetSize = dbConfig.packetSize;
            this.connectionTimeOut = dbConfig.connectionTimeOut;
            this.maxConnectionReuseCount = dbConfig.maxConnectionReuseCount;
            this.maxConnectionReuseTime = dbConfig.maxConnectionReuseTime;
            this.properties = dbConfig.properties;
            this.socketTimeout = dbConfig.socketTimeout;
        }

        public Builder logicalName(String logicalName) {
            this.logicalName = logicalName;
            return this;
        }

        public Builder configFile(String configFile) {
            this.configFile = configFile;
            return this;
        }

        public Builder driver(String driver) {
            this.driver = driver;
            return this;
        }

        public Builder driverClass(String driverClass) {
            this.driverClass = driverClass;
            return this;
        }

        public Builder xaDataSourceClass(String xaDataSourceClass) {
            this.xaDataSourceClass = xaDataSourceClass;
            return this;
        }

        public Builder host(String host) {
            this.host = host;
            return this;
        }

        public Builder port(int port) {
            this.port = port;
            return this;
        }

        public Builder databaseOrSchema(String databaseOrSchema) {
            this.databaseOrSchema = databaseOrSchema;
            return this;
        }

        public Builder serverOrService(String serverOrService) {
            this.serverOrService = serverOrService;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder user(String user) {
            this.user = user;
            return this;
        }

        public Builder password(String password, boolean encrypted) {
            this.password = new DbPassword(password, encrypted);
            return this;
        }

        public Builder characterSet(String characterSet) {
            this.characterSet = characterSet;
            return this;
        }

        public Builder maxPoolSize(int maxPoolSize) {
            this.maxPoolSize = (maxPoolSize <= 0) ? Short.MAX_VALUE : maxPoolSize;
            return this;
        }

        public Builder packetSize(int packetSize) {
            this.packetSize = packetSize;
            return this;
        }

        public Builder connectionTimeOut(int connectionTimeOut) {
            this.connectionTimeOut = connectionTimeOut;
            return this;
        }

        public Builder maxConnectionReuseCount(int maxConnectionReuseCount) {
            this.maxConnectionReuseCount = maxConnectionReuseCount;
            return this;
        }

        public Builder maxConnectionReuseTime(long maxConnectionReuseTime) {
            this.maxConnectionReuseTime = maxConnectionReuseTime;
            return this;
        }

        public Builder properties(Map<String, String> properties) {
            this.properties = properties;
            return this;
        }

        public Builder socketTimeout(int socketTimeoutInSecond) {
            this.socketTimeout = socketTimeoutInSecond;
            return this;
        }

        // TODO. 最后Builder在build对象时，可以根据之前配置的参数多相关的判断和默认值的设置
        public DBConfig build() {
            return new DBConfig(this);
        }
    }
}
