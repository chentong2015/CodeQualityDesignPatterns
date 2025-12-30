package exception_rule;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

// TODO. 创建异常会捕获堆栈轨迹，因此抛出异常的开销很高
//  异常是为了在异常情况下使用，而不应该用于正常的控制流
// Exception是所有exceptions的superclass, Exception继承自Throwable(不应该被捕获)
// - 异常捕获的规范性: 是否需要合并catch
// - 异常继承的规范性: Java类继承时override重写
// - 异常抛出的层级性: 通过Throwable cause设置它上层抛出的异常

// 在java编译阶段异常抛出的声明:
// 1. 如果方法内部抛出unchecked exception, 则不需要写在方法的主体上
// 2. 如果方法内部抛出checked exception, 则必须在方法主体上throws
public class TryCatchExceptionRules {

    // 3. 如果方法主体上没有显式throws checked exception, 在不能放到try catch中捕获 !!
    // 4. 如果方法上抛出Exception, 则可以在try catch中捕获捕获继承它的异常类型
    // 5. main方法可以安全的声明抛出Exception, 因为它是通过虚拟机调用 !!
    public static void main(String[] args) {
        try {
            testThrow();
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (Exception e) {
            // 输出完整的调用堆栈
            e.printStackTrace();
            e.printStackTrace(System.err);
        }
    }

    // 6. 不要声明一个公有方法直接"throws exception"
    // 没有体现方法能够抛出"哪些"异常, 不利于该方法的使用
    public static void testThrow() throws Exception {
        System.out.println("test throw ");
        throw new Exception("throw exception from testThrow method");
    }

    // 7. 不要忽略异常：API方法抛出的异常是在说明某些事情, 不应该直接被"空的catch块"忽略
    // 如果选择忽略，则应该将变量名称设置成ignored，并且注明原因
    public void testNullCatch() {
        try {
            int value = 10;
            throw new ExecutionException(new RuntimeException());
        } catch (ExecutionException ignored) {
            // 解释异常被忽略的原因
        }
    }

    // 8. 当捕获的小范围异常和大范围异常block中处理逻辑一致时
    // 合并两个异常的捕获 & 只需要保留其中一个异常
    public void test(Connection connection) {
        try {
            connection.createStatement().executeQuery("query");
        } catch (SQLException exception) {
            throw new RuntimeException();
        } catch (Exception exception) {
            throw new RuntimeException();
        }
    }

    // 9. try-catch-finally 错误使用导致方法被多次调用
    // 如果在调用doOtherThing()方法时抛出异常，会导致callMethod()被调用三次 !!
    public void testTryCatchFinally(int value) {
        try {
            TryCatchExceptionRules practice = new TryCatchExceptionRules();
            if (value > 10) {
                // callMethod();
                // doOtherThing();
            }
        } catch (Exception e) {
            // callMethod();
        } finally {
            // callMethod(); 无论如何都会被执行一次
        }
    }
}
