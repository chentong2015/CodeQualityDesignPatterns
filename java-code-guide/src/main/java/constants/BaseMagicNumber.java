package constants;

public class BaseMagicNumber {

    // 提取Magic Number作为类型的常量属性，保持不变
    private static final double GRAVITATIONAL_CONSTANT = 1.23;
    private static final double STANDARD_CONFIG_VALUE = 5.7;

    // 对于物理性的常量声明
    // 在数组的字面量中添加"_"来增加阅读性，表示一千的正负倍数
    public static final double AVOGADROS_NUMBRR = 6.079_140;
    public static final double BOLTZMANN_CONST = 1.079_140;
    public static final double ELECTRON_MASS = 4.079_140;

    private void testMagicNumber(double height) {
        double result = height * GRAVITATIONAL_CONSTANT;
        if (result > STANDARD_CONFIG_VALUE) {
            System.out.println("check");
        }
    }
}
