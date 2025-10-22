package behavior_pattern.intercepter.mybatis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 拦截器链，用于保存从配置文件解析后的所有拦截器
public class InterceptorChain {

    private final List<Interceptor> interceptors = new ArrayList<>();

    public void addInterceptor(Interceptor interceptor) {
        interceptors.add(interceptor);
    }

    // target参数: 所使用的executor执行器
    public Object pluginAll(Object target) {
        for (Interceptor interceptor : interceptors) {
            target = interceptor.plugin(target);
        }
        return target;
    }

    public List<Interceptor> getInterceptors() {
        return Collections.unmodifiableList(interceptors);
    }
}
