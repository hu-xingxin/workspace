package com.basictest.jdbc.how2j.jdbcdemo;

import com.basictest.utils.LogUtil;
import sun.security.util.Password;

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
        LogUtil logUtil = LogUtil.getLogUtil(TestJDBC.class);

        try {
            //1.初始化 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            logUtil.info("加载数据库驱动，初始化成功...");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try ( //2.建立与数据库的连接
              Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
              //3.创建Statement
              Statement statement = connection.createStatement();){

            logUtil.info("建立与数据库的连接...");
            //4.执行sql语句
            String updateSql = "update nifi_user set name = 'name' where id = 1";
            String selectSql = "select * from nifi_user";
            boolean execute = statement.execute(selectSql);

            //查询到的结果集
            ResultSet resultSet = statement.getResultSet();
            logUtil.info(selectSql);

            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String sex = resultSet.getString(3);
                int age = resultSet.getInt(4);
                logUtil.info("id：" + id + " name：" + name + " sex：" + sex + " age：" + age);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
