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
    }

    // TODO. Optional + orElse可能存在副作用(Side Effect)
    // 不适用于方法调用和参数传递
    // 可以替换成orElseGet保证执行一次
    private static void testOptionalOrElse() {
        String str = "xxx";
        Optional.ofNullable(str)
                .map(s -> System.out.printf(s + " is not empty \n"))
                .orElseGet(() -> System.out.printf("invoked !"));
    }
}
