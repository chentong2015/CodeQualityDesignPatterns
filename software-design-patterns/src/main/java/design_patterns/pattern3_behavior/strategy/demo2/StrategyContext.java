package design_patterns.pattern3_behavior.strategy.demo2;

public class StrategyContext {

    private IWork iWork;

    // 注入接口，使每一个具体实现都能被"通用算法"所操纵
    public StrategyContext(IWork iWork) {
        this.iWork = iWork;
    }

    // 通用的算法逻辑: 将具体的工作"委托"给接口去完成(调用接口方法去完成)
    public void run() {
        iWork.init();
        iWork.work();
        iWork.cleanup();
    }
}
