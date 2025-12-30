package optional;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class OptionalDemo {

    // TODO. 从optional读取时需要额外的开销，不利于性能
    public static void main(String[] args) {
        Optional<String> optional = Optional.empty();
        System.out.println(optional.isPresent()); // false

        // OptionalInt等效于Optional<Integer>
        OptionalInt sum = OptionalInt.of(0);
        System.out.println(sum.isPresent()); // true

        testOptionalOrElse(null);
    }

    // TODO. Optional + orElse可能存在Side Effect副作用
    // - 不适用于方法调用和参数传递, 替换成orElseGet保证执行一次
    // - 使用boolean字面量值不会造成副作用, 返回正确判断结果
    private static void testOptionalOrElse(String str) {
        // printf的返回值是PrintStream
        Optional.ofNullable(str)
                .map(s -> System.out.printf(s + " is not empty \n"))
                .orElse(System.out.printf("orElse invoked !"));

        // orElseGet只有在Optional为空时才会执行
        Optional.ofNullable(str)
                .map(s -> System.out.printf(s + " is not empty \n"))
                .orElseGet(() -> System.out.printf("orElseGet invoked !")); // 不一定执行 !!

        boolean result = Optional.ofNullable(str)
                .filter(String.class::isInstance)
                .map(s -> !s.isBlank())
                .orElse(false);
        System.out.println(result);
    }
}
