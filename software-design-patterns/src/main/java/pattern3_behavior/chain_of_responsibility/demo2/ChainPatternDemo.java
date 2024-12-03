package pattern3_behavior.chain_of_responsibility.demo2;

public class ChainPatternDemo {

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();
        loggerChain.logMessage(LoggerLevel.INFO, "This is an information.");

        System.out.println("--");
        loggerChain.logMessage(LoggerLevel.DEBUG, "This is an debug level information.");

        System.out.println("--");
        loggerChain.logMessage(LoggerLevel.ERROR, "This is an error information.");
    }

    private static AbstractLogger getChainOfLoggers() {
        AbstractLogger errorLogger = new ErrorLogger(LoggerLevel.ERROR);
        AbstractLogger fileLogger = new FileLogger(LoggerLevel.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(LoggerLevel.INFO);
        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);
        return errorLogger;
    }
}
