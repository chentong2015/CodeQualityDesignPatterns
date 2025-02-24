package design_patterns.pattern3_behavior.intercepter;

// Interceptor 拦截器:
// Software systems or frameworks want to offer a way to change,
// or augment, their usual processing cycle
public class BaseInterceptor {

    // 1. 作为插件: MyBatis插件，自定义要拦截的内容

    // 2. 网页拦截器: 应用在Web Request请求拦截
    //  @Override
    //	public void addInterceptors(InterceptorRegistry registry) {
    //		registry.addInterceptor(new LoginInterceptor())
    //			    .addPathPatterns("/admin/**")
    //			    .excludePathPatterns("/admin")
    //			    .excludePathPatterns("/admin/login");
    //	}
}

