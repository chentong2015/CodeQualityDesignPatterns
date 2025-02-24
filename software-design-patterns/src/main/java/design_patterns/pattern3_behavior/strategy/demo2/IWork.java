package design_patterns.pattern3_behavior.strategy.demo2;

// Iwork接口代表一种抽象策略，它的实现类则代表一种具体策略
public interface IWork {

    void init();

    void work();

    void cleanup();
}
