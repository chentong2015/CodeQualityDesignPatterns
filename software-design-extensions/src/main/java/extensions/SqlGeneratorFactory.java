package extensions;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

// TODO. Singleton生成器工厂的设计
// 1. 在第一个次创建实例时，通过SPI机制加载所有指定的接口的实现类型
// 2. 通过register()注入优先级更高的实现类型，来实现API的扩展
public class SqlGeneratorFactory {

    private static SqlGeneratorFactory instance;
    private List<SqlGenerator> generators = new ArrayList<>();

    private SqlGeneratorFactory() {
        try {
            for (SqlGenerator generator : ServiceLoader.load(SqlGenerator.class)) {
                register(generator);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized SqlGeneratorFactory getInstance() {
        if (instance == null) {
            instance = new SqlGeneratorFactory();
        }
        return instance;
    }

    public void register(SqlGenerator generator) {
        if (this.generators.size() == 0) {
            // handle case in tests where we clear out the generators
        }
        generators.add(generator);
    }
}
