
// TODO. 时刻考虑程序的可可扩展性
public class JavaReverseExtension {

    // 测试案例: 只允许tech user创建在一种枚举类型上
    public void testReverseExtension(BearerType type, boolean isTechUser){
        // 使用==条件不利于程序的扩展, 当新增类型时必须修改
        if (isTechUser && type == BearerType.OATUH) {
            System.out.println("Creation failed");
        }

        // 使用!=条件更有利于枚举类型的新增
        if (isTechUser && type != BearerType.FORMBASED) {
            System.out.println("Creation failed");
        }
    }

    enum BearerType {
        FORMBASED,
        OATUH
        // to add new type
    }
}
