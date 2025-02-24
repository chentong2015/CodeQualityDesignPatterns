package base_solid_principles.isp;

// ISP 接口隔离
// Interface Segregation Principle
// 将大的接口改成小的接口，隔离同一个逻辑和功能
// 该接口是一个大接口，包含两种"方面"的逻辑，会给接口的实现造成问题
public interface BaseISP {

    void processData();

    void handleData();

    void writeReport();

    void copyReport();
}
