package exception;

import java.io.*;

@SuppressWarnings("PMD.JUnit5TestShouldBePackagePrivate")
public class JavaExceptionDemo {

    // 当异常包含多个Cause，可以整合前面核心的信息然后进行提示并抛出
    private void formatExceptionThrown(Exception exception) throws Exception {
        String fullMessage = String.format("%s : %s", exception.getMessage(), exception.getCause().getMessage());
        throw new Exception(fullMessage, exception.getCause());
    }

    // 自定义assert()方法，在不满足条件时抛出对应的异常
    private void assertCondition(String value) {
        if (value == null || value.contains("false")) {
            throw new IllegalArgumentException("false parameter");
        }
    }

    // 通常显示的异常中最后一部分会被压缩，压缩掉的部分使用...显示
    // 可以显示获取Suppressed压缩的异常并且显示出来
    private void testShowSuppressedException() {
        try {
            Reader reader = new FileReader("file1.txt");
        } catch (IOException exception) {
            for (Throwable throwable : exception.getSuppressed()) {
                System.out.println("Suppressed: " + throwable.getMessage());
            }
        }
    }

    // TODO. 将捕获的Exception Stack Trace转成String
    // 注意PrintWriter的flush和close的问题
    private void convertStaceTraceToString(Exception exception) {
        StringWriter stringWriter = new StringWriter();
        // Prints this throwable and its backtrace to the specified print writer.
        exception.printStackTrace(new PrintWriter(stringWriter));
        String resultString = stringWriter.toString();
    }

    public static String getStackTrace(Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter, true);
        throwable.printStackTrace(printWriter);
        printWriter.flush();
        printWriter.close();
        return stringWriter.toString();
    }
}
