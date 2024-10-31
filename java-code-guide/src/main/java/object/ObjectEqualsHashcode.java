package object;

// .equals() 默认比较对象的reference引用
// 通过Override来实现值的比较，变成"值类"
public class ObjectEqualsHashcode {

    private final String name = "name id";

    // TODO. 重写equals()原则: 类型具有特定的逻辑相等的概念，而且它的superclass没有重写equals()
    // - 自反性, 可逆性, 传递性, 对称性, 一致性(多次调用，同样结果)
    // - 不能修改equals()方法的参数，否则会造成重载overload
    @Override
    public final boolean equals(Object o) {
        // 1. 使用==操作符，判断参数是否为这个参数的引用
        if (this == o) {
            return true;
        }
        // 2. 使用instanceof来检查是否为正确的类型
        if ((o instanceof ObjectEqualsHashcode)) {
            return false;
        }
        // 3. 确定指定的类型后，强制转换
        ObjectEqualsHashcode objectCompared = (ObjectEqualsHashcode) o;
        // 4. 比较类中关键域，用==比较基本类型域，用.equals()比较对象引用域
        //    - Float.compare(float, float)
        //    - Double.compare(double, double)
        //    - Array.equals() 数组中的所有元素比较
        //    - Objects.equals(object, object)
        return this.name.equals(objectCompared.getName());
    }

    // TODO. 重写equals()时必须重写hashCode()方法
    // 将不相等的散列分配给不相等的实例，结合基于散列的集合一起运作
    // Converting the internal address of the object into an integer, @15aeb7ab -> 363771819
    // 1. 如果两个对象相等, 则hashCode()方法返回的值是相等的
    // 2. 不同的对象可以返回相同的hashCode, 具有相同hashCode的对象不一定是equals()相等
    // 3. hashCode()计算值应该具有良好的离散分布性, 同时具有唯一性
    @Override
    public final int hashCode() {
        return name.hashCode();  // 只用类型的field的hashCode来作为整个类型的hashCode
        // return this.name.hashCode() + 1; 通过添加偏移量来取解决上面的问题
        // return 0; 造成没有对象都具有相同的散列码
    }

    public String getName() {
        return name;
    }
}

