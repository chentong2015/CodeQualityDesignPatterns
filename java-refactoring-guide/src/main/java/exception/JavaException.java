package exception;

import java.util.NoSuchElementException;
import java.util.Scanner;

// 1. 处理异常的两种方式: LBYL & EAFP
// 2. 异常的两种类别: checked(无法忽略) & unchecked
// 3. StackTrace: 抛出异常背后的方法调用堆栈
public class JavaException {

    // TODO. 先检查条件，确保是“安全”的再去执行
    // 1. 提供更好的直观性和错误的来源, 一般适用于可定义的/可预见的错误
    // 2. LBYL is needed when the failure is expected to happen but rarely.
    // 3. LBYL are not atomic 不是原子(操作), 由于文件的判断和操作之间所存在的时间间隔, 造成异常
    private static int getIntLBYL() {
        Scanner scanner = new Scanner(System.in);
        boolean isValid = true;
        String inputStr = scanner.next();
        for (int i = 0; i < inputStr.length(); i++) {
            if (!Character.isDigit(inputStr.charAt(i))) {
                isValid = false;
                break;
            }
        }
        return isValid ? Integer.parseInt(inputStr) : 0;
    }

    // TODO. 先执行，如果出错再捕获异常处理
    // 1. EAFP is a good way to do validation
    // 2. 适用于IO操作, 确保操作过程的完成
    private static int getIntEAFP() {
        // try后面必须至少接一个catch或者是finally
        try {
            return new Scanner(System.in).nextInt();
        } catch (NoSuchElementException | ArithmeticException exception) {
            // 0. 尽可能的具体到指定的异常类型
            // 1. 可以同时捕获多个异常 -> Java 7之后，支持同时捕获
            // 2. 这里的代码尽量简单，确保不会抛出新的异常
            // 3. 不要使用嵌套的异常捕获
            // 4. 重新抛出异常，自定义输出的信息
            // 5. 不要在catch中忽略掉捕获到的异常
            throw new ArithmeticException("No suitable input ");
        } finally {
            // TODO: 这里放置一定会执行的代码, 在try中的return返回之前执行
        }
    }
}
