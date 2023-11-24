package core_structure_patterns.proxy.chain_of_resp_proxy;

import java.lang.reflect.Method;

public class MyResultSetHandler extends AbstractInvocationHandler {

    public MyResultSetHandler(Object target) {
        super(target);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
