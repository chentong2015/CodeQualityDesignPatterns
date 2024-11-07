package patterns.structure_patterns.proxy.chain_of_resp;

import java.lang.reflect.InvocationHandler;

public abstract class AbstractInvocationHandler implements InvocationHandler {

    private final Object target;

    public AbstractInvocationHandler(Object target) {
        this.target = target;
    }

    public Object getTarget() {
        return target;
    }
}
