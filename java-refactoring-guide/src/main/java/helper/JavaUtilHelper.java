package helper;

// 特殊工具类: 当工具类中混合存在static方法和实例方法时
public class JavaUtilHelper {

    private static final JavaUtilHelper UTIL_HELPER = new JavaUtilHelper();

    private JavaUtilHelper() {
    }

    // 静态方法通过内部创建的实例对象来调用实例方法
    public static void test1() {
        UTIL_HELPER.test2();
    }

    // 私有的构造器约束了以下实例方法不能被外部调用到
    // 与改实例方法定义的可访问性无关
    public void test2() {
        System.out.println("test2");
    }
}
