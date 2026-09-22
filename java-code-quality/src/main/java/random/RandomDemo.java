package random;

import java.security.DrbgParameters;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.SplittableRandom;
import java.util.concurrent.ThreadLocalRandom;

import static java.security.DrbgParameters.Capability.RESEED_ONLY;

// TODO. 从Java7开始，不再使用Random生成随机数
// - Random 使用线程安全的伪随机数生成器，造成过度同步  => 将每个操作都进行同步
// - SecureRandom 推荐实战运用中使用
// - ThreadLocalRandom 产出高质量的随机数，高性能 => 只用于单线程
// - SplittableRandom 并行一共随机数Stream，速度快
public class RandomDemo {

    public void getRandomNumber(int n) throws NoSuchAlgorithmException {
        int value1 = new Random().nextInt(n);
        int value2 = ThreadLocalRandom.current().nextInt(n);
        int value3 = new SplittableRandom().nextInt();

        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextInt();

        Random rand = SecureRandom.getInstanceStrong();
        int value4 = rand.nextInt();
    }

    // DRBG: 确定性随机位生成器算法
    public static void main(String[] args) throws NoSuchAlgorithmException {
        DrbgParameters.Instantiation instantiation = DrbgParameters.instantiation(128, RESEED_ONLY, null);
        SecureRandom random = SecureRandom.getInstance("DRBG", instantiation);

        byte[] bytes = new byte[20];
        random.nextBytes(bytes);
        for (byte b : bytes) {
            System.out.print(b + " ");
        }
        System.out.println();
    }
}
