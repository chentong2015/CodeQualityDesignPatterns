package core_behavior_patterns.iterator.model;

// 迭代器的职责: 判断是否有下一个元素，返回下一个元素
public interface Iterator {

    boolean hasNext();

    Object next();
}
