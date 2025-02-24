package design_patterns.pattern2_structure.adapter;

// TODO: 基于服务端提供的无法满足多线程安全的要求的类型或者API
//   构建类型的Adapter适配器，保证线程安全，并将操作委托给Server端的类型或者API
// 相当于给类型添加一个一个Wrapper包装器
// 把IntIterator的功能委托给一个后备对象IntIteratorAdapter
public class IntIteratorAdapter {

    private IntIterator integerIterator = new IntIterator();

    public synchronized Integer getNextOrNull() {
        if (integerIterator.hasNext()) {
            return integerIterator.next();
        }
        return null;
    }
}
