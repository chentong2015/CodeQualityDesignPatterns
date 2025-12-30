package exception;

import exception.unchecked.BuildException;
import exception.unchecked.BuildInfo;
import exception.unchecked.BuildWarning;

public class JavaExceptionTester {

    public static void main(String[] args) {
        boolean buildFailed = false;
        try {
            // 1. 调用的方法可能抛出异常，注意异常的类型
            testThrowBuildException();

            // 2. 直接抛出BuildWarning异常，不算构建失败
            throw new BuildWarning("errorMessage.toString()");
        } catch (Throwable throwable) {
            buildFailed = handleException(throwable);
        }
        System.out.println(buildFailed);
    }

    // TODO. 由于try-catch的原因，该方法只能抛出BuildException异常，而非BuildWarning异常
    private static void testThrowBuildException() throws BuildException {
        System.out.println("call build exception method");
        try {
            // do something here ...
            throw new BuildWarning("errorMessage.toString()");
        } catch (final Exception e) {
            // 这里会显示Warning中自定义的信息，同时包含exception调用栈的完整信息
            throw new BuildException(e);
        }
    }

    // 先判断外层的异常类型，再判断内层Throwable的类型决定日志的输出
    private static boolean handleException(Throwable th) {
        boolean failed = true;
        if ((th instanceof BuildWarning) || (th instanceof BuildInfo)) {
            failed = false; // not a failure
        }
        if (!(th instanceof BuildException)) {
            failed = true;
        }

        // 通过getCause访问底层的异常(原因)，可将原因的堆栈轨迹集成到高层的异常中
        Throwable cause = th.getCause();
        if (cause instanceof ExceptionInInitializerError) {
            // LogFactory.getLog(getClass()).error(buffer.toString());
            failed = false;
        } else {
            if (th instanceof BuildWarning) {
                // LogFactory.getLog(getClass()).warn(cause);
            }
        }
        return failed;
    }
}
