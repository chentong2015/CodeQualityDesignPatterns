package basic;

public class Guide03Formatting {

    // 1. 以下语句块中都需要使用大括号，即使其中不包含任何的statement
    //    if, else, for, do, while

    // 2. 大括号的标准使用规则: K & R style
    //    左大括号起始不换行，右边换行
    //    右大括号起始换行，右边根据情况来换行
    //    每一层的语句块缩进两个空格

    // 3. 空语句块，可以直接关闭 {}
    //    多语句块(if/else, try/catch/finally)，不能包含简洁的语句块 {}
    //    try {
    //      doSomething();
    //    } catch (Exception e) {}  这里需要按照捕获异常的规则来处理

    // 4. 每一行包含一个statement声明

    // 5. Java列字符的限制为100，超过则需要使用"line-wrapping换行(逻辑上是一行语句)"
    //    5.1 特殊长字符串不可换行，可以违背规则: long URL, long JSNI
    //    5.2 package和import行可以违背此规则
    //    5.3 注释中command line命令行(正对shell命令)

    // 6. Line-wrapping换行
    //    6.1 为了避免超过列字符的限制
    //    6.2 为了使代码更加简洁，并不是追求行的code更少的原则
    //    即使没有超过限制，也能决定使用换行，或者使用方法和局部变量和避免超过限制

    // 7. break换行点的规则:
    //    7.1 对于非赋值符号(.)，一般在符号前选择换行
    //    7.2 读于赋值符合(=)，一般在前或者在后都可以
    //    7.3 方法和构造函数名称一般紧接着左括号(
    //    7.4 ,逗号和它前面的行留在一起
    //    7.5 Lambda表达式一般不会断行
    //        在大括号语句块中间断开
    //        箭头后面只包含一个不含大括号的主体，可以从箭头后面断开
    //        Predicate<String> predicate = str ->
    //            longExpressionInvolving(str);

    // 8. Indent continuation换行缩进
    //    8.1 一般连续的下一行需要往后缩进4个空格
    //    8.2 相同的语法结构需要保持在同层级

    // 9. Vertical Whitespace垂直空白
    //    空白行出现的位置：方法之间，构造器之间
    //    一般fields之间不需要添加空行，fields属性之间可以使用空行来创建共同逻辑属性的分组
    //    不推荐使用连续多个空行
    //    类内的第一个成员前或最后一个成员后的空行是可选的

    // 10. Horizontal whitespace水平空白
    //    注意ASCII space空格出现的指定位置

    // 11. Horizontal alignment
    //     Java不要求左水平列的对齐

    // 12. Grouping parentheses
    //     使用括号(分组)来显示的提示Java运算符的先后顺序

    // 13. Enum Class枚举类型定义中，每个值之间可以间隔一个空行
    //     对于没有方法和注释的Enum，可以直接使用一行表示
    //     private enum Suit { CLUBS, HEARTS, SPADES, DIAMONDS }

    // 14. One variable per declaration 每一行只针对一个变量声明
    //     int a, b; 不允许同时声明两个变量
    //     for (int a=0,b=1; ;) for循环语句块中可以声明多个变量

    // 15. 局部变量的声明要保证最小的作用域
    //     声明一般带有初始化，或者紧接着初始化
    //     不要在一个代码块的开头把局部变量一次性都声明了 !! (c语言才这么做)

    // 16. 数组的初始化: 像语句块一样使用，并且方括号写在类型后面，不是变量名称后面
    //     int[] nums = new int[] {
    //       1, 2, 3, 4
    //     }

    // 17. Switch的声明
    //     case 1: 后的缩进和换行
    //     case 2:
    //        // comments 添加注释来说明
    //        break; continue; return; throws Exception来说明
    //     default: 必须包含一个默认的语句组，即使不做任何操作

    // 18. Annotations注解的使用规范
    //     18.1 一行只写一个注解，不是换行，也没有缩进级别
    //          @Override
    //          @Nullable
    //     18.2 单个的注解可以和被注解的第一行处于同一行
    //          @Override public int hashCode() { ... }
    //     18.3 多个注解可以和字段位于同一行
    //          @Partial @Mock DataLoader loader;

    // 19. Comments注释: 除非需要"必要解释"的情况下，否则不写注释
    //     // /* ... */ 单行注释或者多行注释
    //     一般不适用多个//来写多行注释

    // 20. Numeric Literals
    //     long长整型的标识字符为L，而不是使用小写字符
}
