package basic;

import java.util.HashSet;
import java.util.Set;

// 命名规范问题
// Pascal命名法     -> object pascal团队   -> 微软C#语言的发展: @开头 var === auto (C++
// Camel驼峰命名法   -> java
public class Guide04Naming {

    // 1. identifiers变量名称规范: TODO. 满足正则表达式'^[a-z][a-zA-Z0-9]*$'
    //    ASCII letters and digits 首字母小写 + 字母和数字，不使用下滑线
    //    name_, mName, s_name, kName 不使用这几种前缀和后缀

    // 2. Package names
    //    包名称全部小写，使用点连接，不使用大写字母或者下划线
    //    有关键字的时，需要使用下划线
    //    可以包含.但是不能含有其他的字符, 每一个.下面会划分成一个新的目录
    //    com.example.deepspace com.example.deepSpace com.example.deep_space
    //
    //    java.lang 包含基本类型, 自动被引入
    //    java.io
    //    org.xml.sax.helpers
    //    Switch.supplier.com  -> com.supplier._switch
    //    1World.com           -> com._1world
    //    Export-exchange.com  -> com.experts._exchange

    // 3. Class names: UpperCamelCase
    //    Class类型名称为名词或者名称短语，
    //    Interface名称为名词或者名称短语，有时可以为形容词，或者形容词短语 ex: Readable
    //    Annotation注解的名称没有特别的约束
    //    Test Case测试类型名称: 测试的类型+Test

    // 4. Method names: lowerCamelCase
    //    方法名称为动词或者动词短语
    //    Test Method测试方法的名称可以使用下划线，用于区分名称的逻辑

    // 5. Constant names: CONSTANT_CASE
    //    static final字段，常量是严格不变的 -> 常量的运行效率更快(直接使用常量的值，不需要通过变量进行寻址?)
    //    常量名称为名词或者名词短语，全部使用大写字母，使用下滑下分割
    //    TODO: 包括基元，字符串，不可变类型和不可变类型的不可变集合，static final字段不一定都是常量 !!
    static final int NUMBER = 5;
    // Collections.unmodifiableList(List<String> sourceList); 构建不可变的类型(集合)
    // static final ImmutableList<String> NAMES = ImmutableList.of("Ed", "Ann");
    // static final ImmutableMap<String, Integer> AGES = ImmutableMap.of("Ed", 35, " Ann", 32);
    // static final Joiner COMMA_JOINER = Joiner.on(’,’); // because Joiner is immutable
    // static final SomeMutableType[] EMPTY_ARRAY = {};
    // enum SomeEnum {ENUM_CONSTANT}
    // 以下Collection集合可以被修改, 可以转成不可修改的集合
    static final Set<String> mutableCollection = new HashSet<>();

    // 6. Non-constant field names: lowerCamelCase
    //    字段为名词或者名词短语，首字母小写，并采用驼峰法

    // 7. Parameter names: lowerCamelCase
    //    公共方法的参数名词不能只有一个字符
    //    '方法的参数名词多数情况下名词或者名词短语'

    // 8. Local variable names: lowerCamelCase
    //    局部变量即使是final和不可变的，仍然不考虑成Constant，不使用常量命名法

    // 9. Type variable names
    //    对于泛型中的类型参数的命名规则
    //    9.1 A single capital letter + single numeral: E, T, T2
    //    9.2 Class类命名方式 + 大写字母T: RequestT
    public static <RequestT> void testRequestType(RequestT type) {
        // 使用类型变量
    }

    // TODO: Camel case驼峰法的标准定义，如何转变成更加标准命名
    // 1. 将短语转成纯ASCII字符，去掉任何撇号
    // 2. 以空格或连接词将结果划分成单词
    // 3. 将第一单词首字符小写，其余单词首字符大写
    // 4. 连接上面的单词成一个单独的identifier
    // ex:
    // "new customer ID"       -> newCustomerId    ID作为一个单词，不能全大写
    // "inner stopwatch"       -> innerStopwatch   第二个单词作为一个完整的单词，不能拆成两个
    // "supports IPv6 on iOS?" -> supportIpv6OnIos 严格保证一个单词一个大写首字符
    // "XML HTTP request"      -> XmlHttpRequest   第一个单词是严格的专有名称，保留首字母大写个格式
    // "YouTube importer"      -> YoutubeImporter  首单词时专有名词
    // "check nonempty"        -> checkNonempty    存在两种单词的写法，两种标识均可
    // "check non-empty"       -> checkNonEmpty
}
