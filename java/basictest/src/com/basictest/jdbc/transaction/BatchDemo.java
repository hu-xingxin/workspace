package com.basictest.jdbc.transaction;

import com.basictest.jdbc.utils.ConnMysql;

import java.sql.*;

/**
 * Created in 2021/4/6 11:40
 *
 * @author: huxingxin
 */
public class BatchDemo {
    public static void main(String[] args) throws SQLException {
        insert();
    }

    public static void insert() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = ConnMysql.connection;
            connection.setAutoCommit(false);
            DatabaseMetaData metaData = connection.getMetaData();
            boolean isSupport = metaData.supportsBatchUpdates();
            preparedStatement = connection.prepareStatement("insert into user_avatar(length ) values(?)");
            if(isSupport){
                preparedStatement.setInt(1,1024);
                preparedStatement.addBatch();
                preparedStatement.setInt(1,1024);
                preparedStatement.addBatch();
                preparedStatement.setInt(1,1024);
                preparedStatement.addBatch();
                preparedStatement.setInt(1,1024);
                preparedStatement.addBatch();
//            preparedStatement.setString(1,"ahhh");
//                preparedStatement.addBatch();
                connection.commit();
                int[] ints = preparedStatement.executeBatch();
                for (int i:ints ) {
                    System.out.println(i);
                }
            }
        }catch(Exception e){
           e.printStackTrace();
        }finally {
            if (resultSet != null){
                resultSet.close();
            }
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }
}
