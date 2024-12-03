package pattern2_structure.abstract_server;

// Abstract Server 抽象服务:
// 从扩展"使用对象"的角度进行抽象，使得原来依赖于具体类的"使用者(对象)"依赖接口
// 从而在"被使用对象"增加的情况下，无需改变"使用者(对象)"
public class AbstractServer {

    // Switch能够(并且只能)控制任何实现Switchable接口的东西
    public void controlDevise(Switchable devise) {
        devise.turnOff();
        devise.turnOn();
    }
}
