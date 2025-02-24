package design_patterns.pattern3_behavior.chain_of_responsibility.demo2;

public class FileLogger extends AbstractLogger {

    public FileLogger(LoggerLevel level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}
