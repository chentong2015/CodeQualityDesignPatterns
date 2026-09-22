package optional;

import java.util.Optional;
import java.util.OptionalInt;

public class OptionalOrElse {

    // TODO. Optional.ofNullable() 常用于null空对象的判断逻辑, 替换if-else逻辑
    private static void testOptionalOrElse(String str) {
        // orElse可能存在副作用: 因为printf的返回值是PrintStream !!
        Optional.ofNullable(str)
                .map(s -> System.out.printf(s + " is not empty \n"))
                .orElse(System.out.printf("orElse invoked !"));

        // 无副作用: orElseGet只有在Optional为空时才会执行
        Optional.ofNullable(str)
                .map(s -> System.out.printf(s + " is not empty \n"))
                .orElseGet(() -> System.out.printf("orElseGet invoked !")); // 不一定执行 !!

        // 无副作用: 使用boolean字面量值返回正确判断结果
        boolean result = Optional.ofNullable(str)
                .filter(String.class::isInstance)
                .map(s -> !s.isBlank())
                .orElse(false);
        System.out.println(result);
    }
}
