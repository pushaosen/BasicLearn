package com.luban;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlCon {

    public static void main(String[] args) throws SQLException {
        //Class.forName("com.mysql.jdbc.Driver");
        //Driver
        //jvm  load
        //new DriverClass.forName
        //register driver
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai","root","1234");
        System.out.println(connection);
        System.out.println(System.getProperties());
    }

}
