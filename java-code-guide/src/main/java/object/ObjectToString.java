package object;

// TODO. 始终要覆盖toString()
// Object默认返回类名+散列码
// return getClass().getName() + "@" + Integer.toHexString(hashCode());
public class ObjectToString {

    // 重写toString()方法的原则
    // 1. 方法应该提供包含值得关注的信息
    // 2. 是否需要规定返回值的格式
    // 3. helper类和enum类不需要重写toString()
}
