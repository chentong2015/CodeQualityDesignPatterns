package behavior_pattern.iterator.model;

public class NamesRepository implements IteratorContainer {

    private final String[] names;

    public NamesRepository() {
        this.names = new String[]{"Robert", "John", "Julie", "Lora"};
    }

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    // 在类型的内部定义Name(字符串)的一个迭代器
    private class NameIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            return index < names.length;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}
