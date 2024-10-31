package method;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

// 实战项目: 方法质量问题
// 1. 不要定义没有使用的方法参数
// 2. 特别注意传入的实参对象是否被重新初始化, 修改其本身的属性
// 3. 应该将方法的多个参数封装到对象中传递, 而非依次传递某个对象的多个属性
public class JavaMethodClean {

    // TODO. 重构存在问题的方法
    // 1. 存在没有使用的参数
    // 2. id, infoList, size多个属性属于同一个对象
    // 3. hasBeenTruncated 在方法内部对其设置初始值, 在调用时无效重复设置
    public String validateField(String validator, String id, List<String> infoList, int size, AtomicBoolean hasBeenTruncated) {
        hasBeenTruncated.set(false);
        if (size > 10) {
            hasBeenTruncated.set(true);
            infoList.add(validator);
            return "truncated";
        }
        return validator + "end";
    }
}
