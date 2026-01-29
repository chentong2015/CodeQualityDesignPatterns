package optional;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

// TODO. 从optional读取时需要额外的开销，不利于性能
public class OptionalDemo {

    public static void main(String[] args) {
        Optional<String> optional = Optional.empty();
        System.out.println(optional.isPresent()); // false

        // OptionalInt等效于Optional<Integer>
        OptionalInt sum = OptionalInt.of(0);
        System.out.println(sum.isPresent()); // true

        testOptionalOrElse(null);
    }

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
