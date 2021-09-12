package core_patterns.TemplateMethod_Strategy;

import core_patterns.TemplateMethod_Strategy.strategy.Application;

// Strategy策略模式：使用委托来解决问题
// 1. 可以用来分离"通用算法"和具体的上下文(接口的实现)，使通用的算法依赖于抽象(使用接口)

// TODO: 每一个Application的具体实现，都可以被多个不同的"通用算法"所操纵
//       减少了通用算法和"算法所控制的实现细节"之间的耦合度
public class BaseStrategy {

    private Application itsApplication;

    // 通过在构造中传入不同的Application，该类型可以被重用
    public BaseStrategy(Application itsApplication) {
        this.itsApplication = itsApplication;
    }

    // 通过注入的接口，将具体的工作"委托"给接口去完成(调用接口方法去完成)
    public void run() {
        itsApplication.init();
        while (!itsApplication.done()) {
            itsApplication.work();
        }
        itsApplication.cleanup();
    }
}
