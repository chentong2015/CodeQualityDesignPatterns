package exception.unchecked;

// unchecked异常中包含Throwable(一个抛出异常的类型)
public class BuildException extends RuntimeException {

    // TODO: cause异常抛出的真正原因，封装在自定义的unchecked exception内部
    private Throwable cause;

    public BuildException(String message) {
        super(message);
    }

    public BuildException(String message, Throwable cause) {
        super(message);
        this.cause = cause;
    }

    public BuildException(Throwable cause) {
        super(cause.toString());
        this.cause = cause;
    }

    @Override
    public Throwable getCause() {
        return cause;
    }
}
