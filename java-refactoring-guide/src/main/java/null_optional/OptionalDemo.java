package null_optional;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

// TODO. 从optional读取时需要额外的开销，不利于性能
public class OptionalDemo {

    public static void main(String[] args) {
        // 创建一个没有包含元素的Optional容器
        Optional<String> optional = Optional.empty();
        System.out.println(optional.isPresent());

        // OptionalInt int值的一个容器对象, 等效于Optional<Integer>
        OptionalInt sum = OptionalInt.of(0);
        System.out.println(sum.isPresent());

        OptionalInt total = IntStream.of(1, 2).reduce(Integer::sum);
        System.out.println(total.isPresent());
        System.out.println(total.getAsInt());
    }
}
