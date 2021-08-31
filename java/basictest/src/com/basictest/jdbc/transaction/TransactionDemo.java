package com.basictest.jdbc.transaction;

import com.basictest.jdbc.utils.ConnMysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created in 2021/4/6 11:10
 *
 * @author: huxingxin
 */
public class TransactionDemo {
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
            preparedStatement = connection.prepareStatement("insert into user_avatar(length ) values(?)");
            preparedStatement.setInt(1,962464);
            preparedStatement.executeUpdate();
            preparedStatement.setString(1,"图片长度");
            preparedStatement.executeUpdate();
            connection.commit();
        }catch(Exception e){
            System.out.println(e.getMessage());
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
