package immutable;

import java.util.HashMap;
import java.util.Map;

// 类型的封装：一旦类型对象被创建出来之后, 不可变化 ! 不允许外部改变类型对象
// 1. 不提供setter方法, 不提供改变内部fields的方式
// 2. Make all fields final and private
// 3. Don't allow subclasses to override methods
// 4. 如果实例对象的Fields包含了对可变对象的引用，不要让这些对象改变
//    - 不要提供方法去改变"可变对象" mutable objects
//    - Don't share references to the mutable objects 不要存储外部通过构造器传递进来的引用 ...
public final class MyImmutableClass {

    // 1. 没有提供fields的setter方法，使用final关键字保证它是不可变的
    private final String description;
    private final Map<String, Integer> exits;
    private final byte[] bytesSalt;

    // TODO. 实例的信息应该在创建对象的时候提供，并在对象的整个声明周期内保持不变
    public MyImmutableClass(String description, Map<String, Integer> exits, byte[] bytesSalt) {
        // String类型本身是不可变类型，直接赋值不影响对象的不可变性
        this.description = description;

        // (@NotNull) 这里参数不能为空
        // 不直接存储外部传递进来的引用: 做一个深度拷贝的效果
        this.exits = new HashMap<>(exits);

        // 获取参数字节数组的拷贝，而非直接使用引用
        this.bytesSalt = bytesSalt.clone();
    }

    // 标记final：不能被重写的方法
    // 不将可变对象的引用暴露到外部
    public final Map<String, Integer> getExits() {
        return new HashMap<>(this.exits);
    }

    // 可以构建getter方法
    public String getDescription() {
        return description;
    }

    // 对外返回字节数组的拷贝，使其再外部无法修改该对象的属性
    public byte[] getBytesSalt() {
        return bytesSalt.clone();
    }
}
