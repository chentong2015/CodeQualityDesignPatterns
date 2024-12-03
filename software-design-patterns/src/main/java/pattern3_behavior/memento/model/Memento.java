package pattern3_behavior.memento.model;

public class Memento {

    // 这里保存的对象的状态为String, 可以保存具体的状态
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
