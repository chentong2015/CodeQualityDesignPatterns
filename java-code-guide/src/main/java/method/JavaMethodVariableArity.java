package method;

import java.util.Arrays;

// TODO. ...可变参数，只能放在参数列表的最后一个位置，支持提供0个到多个的参数
// 可变参数机制: 根据传递的参数数量，先创建一个数组，将参数值传递到数组，在将数组传递给方法
// 可变参数性能: 调用带有可变参数的方法会导致一次数组的分配和初始化，
public class JavaMethodVariableArity {

    private static String testMoreParameters(String... more) {
        // 对于引用类型的可变参数，考虑判断是否为null
        if (more == null || more.length == 0) {
            return null;
        }
        return Arrays.stream(more).min(String::compareToIgnoreCase).orElse(null);
    }

    private static int getMin(int... values) {
        if (values.length == 0) {
            return -1;
        }
        return Arrays.stream(values).min().orElse(-1);
    }

    // TODO. 可变参数的使用场景和策略
    // 1. 当方法的参数数量小于等于3个时，避免使用"可变参数"来对性能造成影响
    // 2. 当参数的具体数量无法确定时，才考虑使用
    // 3. 方法必须提供至少一个或两个参数时，可以将必要的测试写在前面
    private int minValue(int firstValue, int... remainingValues) {
        int min = firstValue;
        for (int value : remainingValues) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    // 4. 可变参数的方法重载可能会造成调用时无法判定
    // 第二个方法的packageName参数在使用时无法确定是作为必须参数还是可选参数中的数据 !!
    public void testFunction1(String logPath, String... names) {
    }

    public void testFunction1(String logPath, String packageName, String... names) {
    }
}
