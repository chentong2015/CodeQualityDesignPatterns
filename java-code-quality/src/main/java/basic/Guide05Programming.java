package basic;

public class Guide05Programming {

    // 1. @Override 重写注解
    //    总是显式的写出来, 除非父类的方法被标记注解@Deprecated
    //    1.1 重写父类的方法
    //    1.2 实现接口的方法
    //    1.3 一个接口override父级接口的方法

    // 2. Caught exceptions
    //    异常捕获不可忽略: 尽量捕获到精确的异常
    //    捕获异常需要响应: 打印日志或者throws抛出异常
    //    如何不需任何响应: 则添加注释说明，或者将捕获的名称命名成expected

    // 3. Static members
    //    直接类型名称来调用静态方法成员，而不是使用引用或者类型上的表达式
    //    Foo.aStaticMethod();

    // 4. Finalizers
    //    Object.finalize() Object的析构器从Java9开始被废弃@Deprecated，不能重写
}

