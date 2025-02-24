package design_patterns.pattern3_behavior.chain_of_responsibility.demo2;

public abstract class AbstractLogger {

    protected LoggerLevel level;

    // TODO. 包含下一个logger的引用，以便移交给下一个logger来处理
    // 指向责任链上的下一个element: next element in chain of responsibility
    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    // 日志输出的逻辑: 低于指定level参数的Logger都会处理message的输出
    public void logMessage(LoggerLevel level, String message) {
        if (this.level.ordinal() <= level.ordinal()) {
            write(message);
        }
        // 调用责任链上的下一个logger
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    abstract protected void write(String message);
}
