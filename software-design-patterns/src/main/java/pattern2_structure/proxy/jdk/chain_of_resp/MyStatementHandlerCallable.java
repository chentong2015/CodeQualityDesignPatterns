package pattern2_structure.proxy.jdk.chain_of_resp;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyStatementHandlerCallable extends MyStatementHandler {

    public MyStatementHandlerCallable(Object target) {
        super(target);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            // 形成责任链，在代理的时候往上调用invoke
            return super.invoke(proxy, method, args);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        }
    }
}
