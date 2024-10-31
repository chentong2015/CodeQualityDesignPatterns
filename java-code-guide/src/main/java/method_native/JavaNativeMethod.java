package method_native;

// TODO. Native Method原生方法(使用本地编程语言实现的方法)优缺点:
// 1. 提供访问特定平台的能力，比如访问注册表
// 2. 提供访问本地遗留代码库的能力
// 3. 通过本地语言来实现重要性能的部分
//
// 1. 本地方法是不安全的，可能造成内存的损害
// 2. 使用本地方法的程序更加难以调试
// 3. 使用本地方法(和平台有关)的应用程序不再能够移植
// 4. 使用本地方法可能降低性能
public class JavaNativeMethod {

    // native含义：
    // A method that is native is implemented in platform-dependent code,
    // typically written in another programming language such as C, C++, FORTRAN,or assembly language.
    // The body of a native method is given as a semicolon only, indicating that the implementation is omitted, instead of a block.

    // JNI 概述：Java Native interface
    // 1. 标准Java类库不支持应用程序所需的平台相关功能
    // 2. 已经有其他语言写好的类库，可以直接通过JNI在Java code中调用
    // 3. 使用诸如汇编之类的较低级语言来实现一小部分对时间要求严格的代码
    // 4. 需要跨系统或者硬件资源(disk or network IO), 需要别的语言(例如C)来实现，需要系统方法能调用native code本机代码来实现 !!
    public native void testJNI();

    // TODO. 使用"类型名_本地方法名称"在Jdk源码中查找native方法的实现
    public native String concat(String a, String b);

}
