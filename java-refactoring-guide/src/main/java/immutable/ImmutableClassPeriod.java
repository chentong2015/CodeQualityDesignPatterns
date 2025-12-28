package immutable;

import java.util.Date;

// TODO. 保护性地设计程序，避免对象造到破坏 => 构建真正的不可变类型
// 除了MyImmutablePeriod自身以外，任何类都无法访问该类型实例中的任何一个可变域
public class ImmutableClassPeriod {

    private Date start;
    private Date end;

    // 1. 由于Date是可变对象，在构造器赋值时需要使用"保护性拷贝"来对属性赋值
    //    避免在对象外部修改Date，从而对该对象内部造成的损害
    public ImmutableClassPeriod(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());

        // 有效性检测
        if (this.start.compareTo(this.end) > 0) {
            throw new IllegalArgumentException(this.start + " after " + this.end);
        }
    }

    // 2. 由于Date是可变对象，使用"保护性拷贝"来避免将对象内部组件的引用返回给外部(外部可能修改可变对象)
    // make defensive copies of internal fields (Page 233)
    public Date start() {
        return new Date(start.getTime());
    }

    public Date end() {
        return new Date(end.getTime());
    }
}
