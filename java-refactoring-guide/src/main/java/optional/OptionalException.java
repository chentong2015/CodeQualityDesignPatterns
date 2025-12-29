package optional;

import java.util.*;

public class OptionalException {

    // TODO. 直接从Optional<T>中获取结果可能抛出异常
    public static void main(String[] args) {
        Collection<String> words = new ArrayList<>();
        Optional<String> result = max(words);

        // java.util.NoSuchElementException: No value present
        String result0 = result.get();

        // 1. 先判断存在再获取值
        if (result.isPresent()) {
            System.out.println(result.get());
        }

        // 2. 通过orElse来返回默认值
        String result1 = result.orElse("no max");
        String result2 = result.orElseThrow(() -> new RuntimeException("no max"));

        // 3. 通过ifPresent来判断 => 保证成的健壮性
        result.filter(w -> w.equals("no value"))
              .ifPresent(word -> System.out.println(word));
    }

    // Returns an Optional describing the maximum element of this stream,
    // or an empty Optional if the stream is empty
    public static <E extends Comparable<E>> Optional<E> max(Collection<E> collection) {
        return collection.stream().max(Comparator.naturalOrder());
    }
}
