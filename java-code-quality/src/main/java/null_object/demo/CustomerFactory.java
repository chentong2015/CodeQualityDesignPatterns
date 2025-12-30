package null_object.demo;

// Object Factory 保证工厂创建的对象非null而是空对象
public class CustomerFactory {

    public static final String[] names = {"Rob", "Joe", "Julie"};

    // 创建空对象避免调用端执行额外的判断
    public static AbstractCustomer getCustomer(String name) {
        for (String s : names) {
            if (s.equalsIgnoreCase(name)) {
                return new RealCustomer(name);
            }
        }
        return new NullCustomer();
    }
}
