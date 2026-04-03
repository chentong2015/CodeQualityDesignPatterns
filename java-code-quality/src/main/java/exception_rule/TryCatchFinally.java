package exception_rule;

public class TryCatchFinally {

    public static void main(String[] args) {
        testTryCatchFinally();
    }

    // TODO. try-catch-finally 执行策略: 用于必须执行的逻辑
    // - finally模块即使在捕获异常情况下依然会执行
    // - finally模块会保证在方法返回前执行
    public static void testTryCatchFinally() {
        long totalCount = 0;
        try {
            System.out.println("running");
            totalCount += 10;
            throw new RuntimeException("runtime exception");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            System.out.println("Finally message: " + totalCount);
        }
    }
}
