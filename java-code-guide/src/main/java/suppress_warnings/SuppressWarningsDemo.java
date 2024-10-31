package suppress_warnings;

import java.util.ArrayList;
import java.util.List;

// 如何自定义要抑制的提示 ?
// Indicates that the named compiler warnings should be suppressed in the annotated element.
//
// 1. @SuppressWarnings注解抑制代码编译方面的警告, 没有自动继承性
// 2. 添加在class上的抑制名称会作用到它的全部方法, 但应该减小抑制的Scope
// 3. 不应该抑制废弃API的提示, 特别是对于即将废弃的API

@SuppressWarnings("deprecation")
// @SuppressWarnings("removal")
public class SuppressWarningsDemo {

    // TODO. 当且仅当在使用泛型集合时无法确定实例类型时，才不指定并抑制提示 !!
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void testChild() {
        // 1. rawtypes warning
        // 泛型集合在使用时通常需要特化泛型，否则会出现rawtypes的提示
        List words = new ArrayList();

        // 2. unchecked warning
        // 在没有特化泛型类型的集合中添加元素会造成unchecked的提示
        words.add("hello");
    }
}
