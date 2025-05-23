package design_patterns.pattern3_behavior.chain_of_responsibility.demo2;

public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(LoggerLevel level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}
