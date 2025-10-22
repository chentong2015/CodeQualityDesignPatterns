package behavior_pattern.listener;

// 数据监听器: 监听某些事件的发生, 可以有不同的实现
public interface EventListener {

    void startEvent(String event);

    void processEvent(String event);

    void endEvent(String event);
}
