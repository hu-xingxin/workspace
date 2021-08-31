package com.basictest.jdbc.how2j.jdbcdemo.statement;

import com.basictest.utils.LogUtil;

import java.sql.*;

/**
 * @author huxingxin
 * @createTime 2021年07月29日 10:24:55
 * @Description 测试JDBC程序
 */
public class TestJDBC {
    static String URL = "jdbc:mysql://127.0.0.1:3306/nifi_1?characterEncoding=UTF-8";
    static String USERNAME = "root";
    static String PASSWORD = "123456";
    public static void main(String[] args) {
        try {
            //1.初始化 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            LogUtil.log("加载数据库驱动，初始化成功...");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String updateSql = "update nifi_user set name = ? where id = ?";
        String selectSql = "select * from nifi_user";

        try ( //2.建立与数据库的连接
              Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
              //3.创建Statement
              PreparedStatement statement = connection.prepareStatement(updateSql);){

            LogUtil.log("建立与数据库的连接...");
            statement.setString(1,"username");
            statement.setInt(2,2);
            //4.执行sql语句
            boolean execute = statement.execute();
            LogUtil.log(execute+"");

            LogUtil.log(updateSql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
