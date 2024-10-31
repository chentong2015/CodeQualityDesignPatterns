package method;

import java.util.Map;

// Java不支持设置方法参数的默认值
// Java方法签名包括: 方法名称 + 参数列表(类型数目和顺序位置); 不包括: 方法修饰限定符, 返回值, 抛出异常类型 !!
public class JavaMethodBasic {

    // TODO. CognitiveComplexity 认知复杂性: 一个方法应该保证在一个逻辑层面
    // 当方法中的if else逻辑判断过多，会导致认知复杂度的增加，方法的行为容易不受控制

    // TODO. Java方法签名规范
    // 1. 方法的参数控制在4个之内, 并且保持在一个抽象层级
    // 2. 解决过长参数列表的方法:
    //    - 将一个方法分解成多个方法
    //    - 创建辅助类(静态成员类)/过多参数考虑使用Builder模式
    public static int testMethods(boolean gameOver, int score, int levelCompleted, int bonus) {
        // to do something
        return -1; // -1 通常是表示错误，或者是没有搜索到指定的值
    }

    // 3. 对于参数类型，优先考虑接口，而不是实现接口的类
    //    避免传入HashMap<>作为参数, 避免只处理特定的实例
    private void testMap(Map<Integer, String> map) {
    }

    // 4. 对于boolean参数，考虑使用两个元素的枚举类型来增加可读性
    private void testBoolean(boolean isTarget) {
    }

    // 特例分析：如何声明一个能够交换两个变量值的方法
    // Java方法调用只支持参数的"值传递", 以下方法无法实现交换 !!
    private static void swap(String a, String b) {
        String temp = a;
        a = b;
        b = temp;
    }
}
