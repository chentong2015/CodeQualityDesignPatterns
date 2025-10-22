package behavior_pattern.intercepter.mybatis;

public interface Interceptor {

    Object intercept(Invocation invocation) throws Throwable;

    default Object plugin(Object target) {
        // 将每一个拦截器，动态代理到Plugin(动态代理类)
        // return Plugin.wrap(target, this);
        return null;
    }
}

// 如果自定义的拦截器上没有添加注解，没有要拦截的目标，则直接返回target，反之则使用Proxy动态代理
// public static Object wrap(Object target, Interceptor interceptor) {
//     Map<Class<?>, Set<Method>> signatureMap = getSignatureMap(interceptor);
//     Class<?> type = target.getClass();
//     Class<?>[] interfaces = getAllInterfaces(type, signatureMap);
//     if (interfaces.length > 0) {
//         return Proxy.newProxyInstance(target.getClass().getClassLoader(),
//                 interfaces, new Plugin(target, interceptor, signatureMap));
//     }
//     return target;
// }
