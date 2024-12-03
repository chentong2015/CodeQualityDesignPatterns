package switch_case;

public class SwitchCaseDemo {

    public static void main(String[] args) {
         testSwitchCase1(3);
         testSwitchCase1(6);
    }

    private static void testSwitchCase1(int value) {
        switch (value) {
            case 1:
                System.out.println("case invoked One");
                break;
            case 2:
            case 3:
                System.out.println("case invoked Two");
                break;
            case 4:
            case 5:
            // case 6: 连续几个case统一执行相同逻辑
            // 删除case时不能连带删除执行语句块，否则前面case执行后续错误逻辑
                System.out.println("case invoked Three");
                break;
            case 7:
                System.out.println("case invoked Four");
                break;
            default:
                System.out.println("default");
        }
    }
}
