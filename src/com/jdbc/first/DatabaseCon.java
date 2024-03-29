package com.jdbc.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DatabaseCon {
	
	public static void main( String[] args ) throws SQLException
    {
        /*
         * 1. 加载驱动程序到DriverManager
         */
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }

        /*
         * 2. 提供JDBC连接的URL。书写格式： 协议：子协议：//数据源标识/数据库名称
         */
        String url = "jdbc:mysql://localhost:3306/text";
        String userName = "root";
        String password = "287396";

        /*
         * 3. 获取Connection对象
         */
        Connection connection = DriverManager.getConnection(url, userName, password);

        /*
         * 4. 创建Statement对象
         */
        Statement statement = connection.createStatement();

        /*
         * 5. 执行Query语句
         */
        ResultSet rs = statement.executeQuery("SELECT * FROM emp");

        /*
         * 6. 处理结果集
         */
        while(rs.next()) {
            System.out.println(rs.getInt(1));
        }

        /*
         * 7. 关闭资源
         */
        if (rs != null) {
            rs.close();
        }

        if (statement != null) {
            statement.close();
        }

        if (connection != null) {
            connection.close();
        }
    }
}
