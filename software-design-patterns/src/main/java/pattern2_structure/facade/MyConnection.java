package pattern2_structure.facade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

// Facade Pattern: 外观模式
// 1. 为复杂的系统使用统一的API，隐藏和封装底层API的复杂性
// 2. 为子系统中一组接口提供一致的界面，此模式定义高层接口，使得这一子系统更加容易使用
//
// Facade pattern hides the complexities of the system and
// provides an interface to the client using which the client can access the system.
// This type of design pattern comes under structural pattern
// as this pattern adds an interface to existing system to hide its complexities.
public class MyConnection {

    // 封装JDBC Connection底层内部执行的细节以及复杂性
    private Connection delegate;

    public MyConnection(String connectionString) {
        try {
            delegate = DriverManager.getConnection(connectionString);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void storeData(Object data) throws SQLException {
        int count = delegate.createStatement().executeUpdate("sql");
        System.out.println(count);
    }

    public String getDataNameById(int id) throws SQLException {
        ResultSet resultSet = delegate.createStatement().executeQuery("sql");
        if (resultSet.next()) {
            return resultSet.getString("name");
        }
        return "empty";
    }
}
