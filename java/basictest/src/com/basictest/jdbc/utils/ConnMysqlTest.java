package com.basictest.jdbc.utils;

import java.sql.*;

/**
 * Created in 2021/3/29 16:36
 *
 * @author: huxingxin
 */
public class ConnMysqlTest {
    public static  String URL ="jdbc:mysql://localhost:3306/mydbs?useUnicode=true&allowMultiQueries=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8";
    public static  String USERNAME ="root";
    public static  String PASSWORD ="123456";
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
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //3.创建一个Statement对象
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
//        statementTest();
        preparedStatementTest();

    }

    public static void statementTest() throws SQLException {
        Date date = new Date(System.currentTimeMillis());
        String sql="INSERT INTO `" +
                "sp_user`"+
                "VALUES " +
                "('018d748bedcf4327b22e5349df7265a2', '冠铭城', 'f9569ca7dc9ba87f9df0fc8fe8fed6de', 1, '13851969112', '南京冠铭城电脑科技有限公司', '南京冠铭城','2021-04-05 00:00:00','2021-04-05 00:00:00', 'admin', '超级管理员', 'admin', 'dbd0205069a74e9985167655e9db5eaa');";

        System.out.println(sql);
       long beginTime = System.currentTimeMillis();
        try{
            for (int i = 100; i > 0; i--) {
                statement.execute(sql);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
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
        long endTime = System.currentTimeMillis();
        long executeTime = endTime - beginTime;
        System.out.println("使用statement耗时:" + executeTime);
    }

    public static void preparedStatementTest() throws SQLException {
        long beginTime = System.currentTimeMillis();
        try{
            preparedStatement = connection.prepareStatement("insert into sp_user(USER_ID,USER_NAME,PASSWORD,STATE,seller_id,name,nick_name,CREATE_TIME,UPDATE_TIME,CREATE_BY,CREATE_DEPT,UPDATE_BY,DEPT_ID) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            for (int i = 100; i > 0; i--) {
                preparedStatement.setString(1,"018d748bedcf4327b22e5349df7265a2");
                preparedStatement.setString(2,"冠铭城");
                preparedStatement.setString(3,"f9569ca7dc9ba87f9df0fc8fe8fed6de");
                preparedStatement.setInt(4,1);
                preparedStatement.setString(5,"13851969112");
                preparedStatement.setString(6,"南京冠铭城电脑科技有限公司");
                preparedStatement.setString(7,"南京冠铭城");
                preparedStatement.setDate(8, new Date(System.currentTimeMillis()));
                preparedStatement.setDate(9, new Date(System.currentTimeMillis()));
                preparedStatement.setString(10, "admin");
                preparedStatement.setString(11, "超级管理员");
                preparedStatement.setString(12, "admin");
                preparedStatement.setString(13, "dbd0205069a74e9985167655e9db5eaa");
                preparedStatement.executeUpdate();
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            if (resultSet!=null){
                resultSet.close();
            }
            if (preparedStatement!=null){
                preparedStatement.close();
            }
            if (connection!=null){
                connection.close();
            }
        }
        long endTime = System.currentTimeMillis();
        long executeTime = endTime - beginTime;
        System.out.println("preparedStatement耗时:" + executeTime);
    }

    public static void callProcedure() throws SQLException {
        try {
            callableStatement=connection.prepareCall("{call user_state(?,?,?,?)}");
            callableStatement.registerOutParameter(1,Types.INTEGER);
            callableStatement.registerOutParameter(2,Types.INTEGER);
            callableStatement.registerOutParameter(3,Types.VARCHAR);
            callableStatement.registerOutParameter(4,Types.VARCHAR);
            callableStatement.execute();
            Integer user_num = callableStatement.getInt(1);
            Integer role_num = callableStatement.getInt(2);
            String new_user = callableStatement.getString(3);
            String new_role = callableStatement.getString(4);
            System.out.println(user_num);
            System.out.println(role_num);
            System.out.println(new_user);
            System.out.println(new_role);

            callableStatement=connection.prepareCall("{call callprocedure(?)}");
            callableStatement.registerOutParameter(1,Types.INTEGER);
            callableStatement.execute();
            Integer c = callableStatement.getInt(1);
            System.out.println(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (callableStatement!=null){
                callableStatement.close();
            }
            if (connection!=null){
                connection.close();
            }
        }
    }
}
