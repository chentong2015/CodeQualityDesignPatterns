package utils;

// 特殊工具类: 当工具类中混合存在static方法和实例方法时
public class JavaUtilHelper {

    private static final JavaUtilHelper UTIL_HELPER = new JavaUtilHelper();

    private JavaUtilHelper() {
    }

    // 静态方法通过内部创建的实例对象来调用实例方法
    public static void test1() {
        UTIL_HELPER.test2();
    }

    // 即使设置public修饰符也无法被外部访问(无法在外部创建对象)
    public void test2() {
        System.out.println("test2");
    }
}
