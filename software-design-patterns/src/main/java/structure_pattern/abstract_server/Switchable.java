package structure_pattern.abstract_server;

// 从客户角度确定的的接口，任何电器必须实现开关两个级别方法
// 接口的命名来自于客户和接口之间的逻辑绑定关系，强于它和它的继承类之间的逻辑 !!
public interface Switchable {

    void turnOn();

    void turnOff();
}
