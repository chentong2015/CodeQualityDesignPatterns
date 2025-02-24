package design_patterns.pattern2_structure.proxy.jdk.chain_of_resp;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.ResultSet;

public class MyStatementHandler extends AbstractInvocationHandler {

    public MyStatementHandler(Object target) {
        super(target);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            if (method.getName().equals("executeQuery")) {
                return handleExecuteQuery(method, args);
            } else if (method.getName().equals("getResultSet")) {
                Object rs = method.invoke(getTarget(), args);

                // 在Invoke方法中再调用另外一个Proxy代理
                return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                        new Class[]{ResultSet.class},
                        new MyResultSetHandler(rs));
            }
            return method.invoke(this.getTarget(), args);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        }
    }

    private Object handleExecuteQuery(Method method, Object[] args) {
        return null;
    }
}
