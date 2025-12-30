package exception.checked;

// 自定义异常的类型, 提供两种构造器, 允许提供异常的信息
public class TestException extends Exception {

    // 封装异常相关的属性，为捕获异常时的debug提供关键细节信息
    private boolean status;

    public TestException() {
        this("this is a checked exception");
    }

    public TestException(String message) {
        this(message, false);
    }

    public TestException(String message, boolean status) {
        super(message);
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }
}
