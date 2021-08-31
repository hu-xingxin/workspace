package com.basictest.jdbc.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Created in 2021/3/29 16:36
 *
 * @author: huxingxin
 */
public class ConnMysql {
    public static Connection connection;
    public static Statement statement;
    public static PreparedStatement preparedStatement;
    public static CallableStatement callableStatement;
    public static  ResultSet resultSet;

    static {
        //1.加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取数据库连接
            Properties properties = new Properties();
            properties.load(new FileInputStream("F:\\workspace\\basictest\\src\\com\\basictest\\jdbc\\resource\\sqlconn1.ini"));
            String URL = properties.getProperty("URL");
            String USERNAME = properties.getProperty("USERNAME");
            String PASSWORD = properties.getProperty("PASSWORD");

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //3.创建一个Statement对象
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Deprecated
    public static void  query(String sql) throws SQLException {
        //4.执行SQL语句
        try {
            resultSet = statement.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (resultSet.next()){
                for (int i=0;i<columnCount;i++){
                    System.out.print(resultSet.getString(i+1)+'\t');
                }
                System.out.println();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (resultSet!=null){
                resultSet.close();
            }
            if (statement!=null){
                statement.close();
            }
            if (connection!=null){
                connection.close();
            }
        }

    }

    @Deprecated
    public static void update(String sql) throws SQLException {
        try {
            int i = statement.executeUpdate(sql);
            System.out.println("sql语句执行结果:"+i);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (statement!=null){
                statement.close();
            }
            if (connection!=null){
                connection.close();
            }
        }
    }

    @Deprecated
    public static void execute(String sql) throws SQLException {
        try {
            boolean isHasResult = statement.execute(sql);
            if (isHasResult){
                resultSet = statement.getResultSet();
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                while (resultSet.next()){
                    for (int i=0;i<columnCount;i++){
                        System.out.print(resultSet.getString(i+1)+'\t');
                    }
                    System.out.println();
                }

            }else {
                System.out.println("该sql影响的记录有"+statement.getUpdateCount());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (resultSet!=null){
                resultSet.close();
            }
            if (statement!=null){
                statement.close();
            }
            if (connection!=null){
                connection.close();
            }
        }
    }
}
