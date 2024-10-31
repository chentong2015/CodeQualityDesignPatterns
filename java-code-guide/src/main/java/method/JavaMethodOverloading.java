package method;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

// TODO: Overloading 重载: Compile Time Polymorphism 编译时的多态性
// - 要调用哪个重载方法是在"编译时"决定的, 区别于"运行时"真正执行的方法
// - 对于具有相同参数数目的方法而言，应该避免重载方法

// 一般而言，只有返回值不同的"重载方法"在编译时会报错，被视为一样的"方法签名"
// 但是，只有返回值不同的"重载方法"可以在编译后的Class文件格式中共存 !!
public class JavaMethodOverloading {

    public static int calculateScore(String playerName, int score) {
        System.out.println(playerName + " has score is " + score);
        return score * 100;
    }

    public String calculateScore(Object playerName, int score) {
        return "check";
    }

    // TODO: 以下两个方法虽然泛型中其中一个参数不同，但是仍然属于方法重载 !!
    // public void testOverloadingMethod(Function<Object, Integer> function) {
    // }
    //
    // public int testOverloadingMethod(Function<String, String> function) {
    //     return 1;
    // }

    // 由于List<E>接口有两个重载的remove()方法，造成运行时"实际调用"和"期待调用"的方法不同
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = -3; i < 3; i++) {
            set.add(i);
            list.add(i);
        }
        for (int i = 0; i < 3; i++) {
            set.remove(i);
            list.remove(i);
        }
        System.out.println(set + " " + list);
    }
}
