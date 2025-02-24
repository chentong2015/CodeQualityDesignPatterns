package lazy_init;

// 正确的初始化优先于延迟初始化(在需要域的值时才进行初始化)
public class JavaLazyInitialization {

    // 1. 正常初始化，在类的初始化阶段执行<clinit>()
    private final String field = "init value";

    // 2. 延迟初始化，并使用同步
    private String value;

    private synchronized String getValue1() {
        if (value == null) {
            value = "value 1";
        }
        return value;
    }

    // 3. 延迟初始化(无同步) > (Holder Class模式)
    private static String getFieldValue() {
        return FieldHolder.field;
    }

    private static class FieldHolder {
        static final String field = "field value";
    }
}
