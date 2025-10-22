package structure_pattern.adapter;

import java.util.Iterator;

// Server提供的类型，或者API接口，并不支持多线程
public class IntIterator implements Iterator<Integer> {

    private Integer nextValue = 0;

    @Override
    public boolean hasNext() {
        return nextValue < 10000;
    }

    @Override
    public Integer next() {
        if (nextValue == 10000) {
            System.out.println("At the end");
        }
        return nextValue++;
    }

    public Integer getNextValue() {
        return nextValue;
    }
}
