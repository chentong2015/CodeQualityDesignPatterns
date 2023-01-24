package java.standard.library;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

// 1. 了解Java源码并使用标准类库(精心设计好的API)，忽略API底层实现的细节
// 2. 其次使用高级第三方类库
// 3. 自定义实现功能
public class JavaStandardLibrary {

    // TODO. 从Java7开始，不再使用Random生成随机数
    // ThreadLocalRandom能够产出高质量的随机数，并具有更好的性能
    public void getRandomNumber(int n) {
        int value1 = new Random().nextInt(n);
        int value2 = ThreadLocalRandom.current().nextInt(n);
    }
}
