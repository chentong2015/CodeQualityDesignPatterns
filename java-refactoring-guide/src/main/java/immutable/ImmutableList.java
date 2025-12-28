package immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableList {

    // TODO. 返回的空"可变列表"，可以添加数据
    private static List<Integer> getMutableList(int value) {
        if (value < 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        result.add(value);
        result.add(value + 1);
        return result;
    }

    // TODO. 使用Collections.emptyList()返回空"不可变列表"
    private static List<Integer> getImmutableList(int value) {
        if (value < 0) {
            // Returns an empty list (immutable). This list is serializable.
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        result.add(value);
        result.add(value + 1);
        return result;
    }

    public static void main(String[] args) {
        List<Integer> listMutable = getMutableList(-10);
        listMutable.add(10);
        System.out.println(listMutable.size());

        // Not support for Immutable List
        List<Integer> listImmutable = getImmutableList(-10);
        listImmutable.add(10);
        System.out.println(listImmutable.size());
    }
}
