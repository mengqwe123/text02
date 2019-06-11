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
         * 1. ������������DriverManager
         */
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }

        /*
         * 2. �ṩJDBC���ӵ�URL����д��ʽ�� Э�飺��Э�飺//����Դ��ʶ/���ݿ�����
         */
        String url = "jdbc:mysql://localhost:3306/text";
        String userName = "root";
        String password = "287396";

        /*
         * 3. ��ȡConnection����
         */
        Connection connection = DriverManager.getConnection(url, userName, password);

        /*
         * 4. ����Statement����
         */
        Statement statement = connection.createStatement();

        /*
         * 5. ִ��Query���
         */
        ResultSet rs = statement.executeQuery("SELECT * FROM emp");

        /*
         * 6. ��������
         */
        while(rs.next()) {
            System.out.println(rs.getInt(1));
        }

        /*
         * 7. �ر���Դ
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
