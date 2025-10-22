package basic;

// TODO. 不要在源代码中出现其它语言，即使在代码注释中也不行
public class Guide01SourceFiles {

    // 1. file name: 大小写敏感的名称.java
    // 2. source name: 编码格式UTF-8
    // 3. whitespace: 除换行符外, 源文件中出现的唯一空格字符0x20
    //    注意位于字符和字符串中白空格字符的转义
    // 4. special escape sequence
    //    直接使用特殊转义(字符)序列: \b, \t, \n, \f, \r, \", \', \\
    //    避免使用: \012 Octal八进制; Unicode源码转义
    // 5. 对于余下的非ASCII字符
    //    可使用实际Unicode字符(如∞) 或 等效Unicode转义(如\u221e)表示
    public String testCharacters(String content) {
        String unitAbbrev = "μs";       // 直接使用，无需注释
        String unitAbbrev2 = "\u03bcs"; // 不使用，很难理解

        return "\ufeff" + content; // byte order mark 对不可打印的字符使用转义，并进行必要的注释
    }
}
