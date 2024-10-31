package random;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.SplittableRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {

    // TODO. 从Java7开始，不再使用Random生成随机数
    // - Random使用线程安全的伪随机数生成器，造成过度同步  => 将每个操作都进行同步
    // - ThreadLocalRandom能够产出高质量的随机数，高性能 => 只用于单线程
    // - SplittableRandom并行一共随机数Stream，速度快
    public void getRandomNumber(int n) throws NoSuchAlgorithmException {
        int value1 = new Random().nextInt(n);
        int value2 = ThreadLocalRandom.current().nextInt(n);
        int value3 = new SplittableRandom().nextInt();

        // SecureRandom is preferred to Random 实战运用中使用
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextInt();

        Random rand = SecureRandom.getInstanceStrong();
        int value4 = rand.nextInt();
    }

    // TODO. 自动义生成某范围内的随机数的API
    // Generate Random Number
    // Design algo to generate an int number between 0 and bound
    // 0 <= ? < bound 什么样的逻辑能够使得数字均匀的生成 ??
    public int generateRandomNumber(int bound) {
        if (bound <= 0) {
            throw new IllegalArgumentException("bound must be positive");
        }
        // bound is a power of 2
        if ((bound & -bound) == bound) {
            // return (int)((bound * (long)next(31)) >> 31);
            return bound / 2;
        }
        int bits, val;
        do {
            // bits = next(31);
            bits = 10;
            val = bits % bound;
        } while (bits - val + (bound - 1) < 0);
        return val;
    }
}
