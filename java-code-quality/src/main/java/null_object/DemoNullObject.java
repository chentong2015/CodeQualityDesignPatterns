package null_object;

public class DemoNullObject {

    public static void main(String[] args) {
        int value = parseInteger("t");
        System.out.println(value);
    }

    // 在数据解析过程中返回的Wrapper类对象可能造成调用端的异常
    // 可以先判断值的有效性，然后再执行解析并使用
    public static Integer parseInteger(String s) {
        try {
            return Integer.valueOf(s);
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    public static Boolean parseBoolean(String s) {
        if (Boolean.TRUE.toString().equals(s)) {
            return Boolean.TRUE;
        }
        if (Boolean.FALSE.toString().equals(s)) {
            return Boolean.FALSE;
        }
        return null;
    }
}
