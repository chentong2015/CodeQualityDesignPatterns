package immutable;

import java.util.Date;

// 将以下的类型设计成不可变类型，类型的实例在被创建后不可变化
// 1. init 在初始化对象属性值时创建另一个对象
// 2. getter 返回具有相同属性值的另一个对象
public class TestImmutableClass {

    // TODO. String作为不可变类型，本身不会影响类型的不可变性
    // String变量每次修改或赋值时都会重新创建新的对象，并将新对象的引用赋值给变量
    private String name;
    private Date dateTime;

    public TestImmutableClass(String name, Date dateTime) {
        this.name = name;
        this.dateTime = dateTime;
        // this.dateTime = new Date(dateTime.getTime());
    }

    public String getName() {
        return name;
    }

    public Date getDateTime() {
        return dateTime;
        // return new Date(dateTime.getTime());
    }

    public static void main(String[] args) {
        TestImmutableClass demo = new TestImmutableClass("name", new Date());
        String name = demo.getName();
        name = "new name";
        System.out.println(demo.getName());

        // 在外部修改对象的"引用类型的属性"时会间接修改原对象
        Date date = demo.getDateTime();
        date.setTime(100l);
        System.out.println(demo.getDateTime().getTime());
    }
}
