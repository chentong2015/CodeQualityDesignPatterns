package design_patterns.pattern3_behavior.iterator.model;

// 迭代器的职责: 判断是否有下一个元素，返回下一个元素
public interface Iterator {

    boolean hasNext();

    Object next();
}
