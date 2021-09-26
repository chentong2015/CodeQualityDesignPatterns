package core_patterns.intercepter_chain.spring_aop;

// Spring AOP实现切面通知的顺序时，使用"责任链 + 层层递归"驱动
public class BaseSpringAop {

    // JdkDynamicAopProxy
    // public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    //    ...
    //    Get the interception chain for this method.
    //	  // TODO: 将链接器中的advisor(@Before, @After..)取出来，转成拦截器的链条
    //	  List<Object> chain = this.advised.getInterceptorsAndDynamicInterceptionAdvice(method, targetClass);
    // }

    // ReflectiveMethodInvocation
    // public Object proceed() throws Throwable {
    //		// We start with an index of -1 and increment early.
    //		// 责任链条中一共5个结点，在执行到最后一个链条时返回
    //		if (this.currentInterceptorIndex == this.interceptorsAndDynamicMethodMatchers.size() - 1) {
    //			return invokeJoinpoint();
    //		}
    //
    //		// ++this.currentInterceptorIndex移动到链条中的下一个
    //		Object interceptorOrInterceptionAdvice = this.interceptorsAndDynamicMethodMatchers.get(++this.currentInterceptorIndex);
    //		if (interceptorOrInterceptionAdvice instanceof InterceptorAndDynamicMethodMatcher) {
    //			// Evaluate dynamic method matcher here: static part will already have
    //			// been evaluated and found to match.
    //			InterceptorAndDynamicMethodMatcher dm = (InterceptorAndDynamicMethodMatcher) interceptorOrInterceptionAdvice;
    //			Class<?> targetClass = (this.targetClass != null ? this.targetClass : this.method.getDeclaringClass());
    //			if (dm.methodMatcher.matches(this.method, targetClass, this.arguments)) {
    //				return dm.interceptor.invoke(this);
    //			}
    //			else {
    //				// Dynamic matching failed.
    //				// Skip this interceptor and invoke the next in the chain.
    //				return proceed();
    //			}
    //		}
    //		else {
    //			// It's an interceptor, so we just invoke it: The pointcut will have
    //			// been evaluated statically before this object was constructed.
    //			return ((MethodInterceptor) interceptorOrInterceptionAdvice).invoke(this);
    //		}
    //	}
}
