package exception.checked;

import java.util.Scanner;

// TODO. 失败的原子性: 失败的方法调用应该使对象保持在被调用之前的状态
// 1. 使用不可变对象
// 2. 在对象状态被修改之前，检查操作的有效性
// 3. 在临时拷贝上执行操作，完成后再替换原始对象
public class TestExceptionDemo {

    public static void main(String[] args) {
        for (String arg : args) {
            try {
                int result = thrower(arg);
                System.out.println("Test OK, no exception");
            } catch (Exception e) {
                System.out.println("threw message: " + e.getMessage());
            }
        }
    }

    // TODO. 如果方法抛出checked exception, 调用该方法的代码就必须在一个或者多个catch中处理异常, 或者声明抛出异常 
    static int thrower(String s) throws TestException {
        try {
            if (s.equals("divide")) {
                int i = 0;
                return i / i;  // Exception: java.lang.ArithmeticException 可以忽略的异常
            }
            if (s.equals("null")) {
                s = null;
                return s.length(); // Exception: java.lang.NullPointerException
            }
            if (s.equals("test")) {
                throw new TestException("Test message"); // 自定义的，不能够被忽略的异常
            }
            return 0;
        } finally {
            System.out.println("[thrower(\"" + s + "\") done]");
        }
    }

    public void testCallException() {
        try {
            test();
        } catch (TestException exception) {
            // 从异常中拿到指定的数据情况
            System.out.println(exception.isStatus());
        }
    }

    public void test() throws TestException {
        try {
            int value = new Scanner(System.in).nextInt();
        } catch (Exception exception) {
            throw new TestException("Test Failed", true);
        }
    }
}
