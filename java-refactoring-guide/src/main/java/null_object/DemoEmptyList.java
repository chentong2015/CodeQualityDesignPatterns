package null_object;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DemoEmptyList {

    public static void main(String[] args) {
        List<Integer> list1 = getEmptyList(-10);
        list1.add(10);
        list1.add(100);
        System.out.println(list1.size());

        List<Integer> list2 = getEmptyListOK(-10);
        list2.add(10);
        list2.add(100);
        System.out.println(list2.size());
    }

    // TODO. 返回的空列表时可变的，可以添加数据
    private static List<Integer> getEmptyList(int value) {
        if (value < 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        result.add(value);
        result.add(value + 1);
        return result;
    }

    // TODO. 使用Collections.emptyList()返回空列表
    private static List<Integer> getEmptyListOK(int value) {
        if (value < 0) {
            // Returns an empty list (immutable). This list is serializable.
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        result.add(value);
        result.add(value + 1);
        return result;
    }
}
