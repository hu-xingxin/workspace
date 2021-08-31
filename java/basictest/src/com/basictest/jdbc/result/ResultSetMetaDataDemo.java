package com.basictest.jdbc.result;

import com.basictest.jdbc.utils.ConnMysql;

import java.sql.*;

/**
 * Created in 2021/4/6 10:23
 *
 * @author: huxingxin
 */
public class ResultSetMetaDataDemo {
    public static void main(String[] args) throws SQLException {
        getResultSetMetaData();
    }

    public static void getResultSetMetaData() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = ConnMysql.connection;
            preparedStatement = connection.prepareStatement("select * from user_avatar;");
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (resultSet.next()){
                for (int i = 0;i<columnCount;i++){
                    System.out.print(metaData.getColumnName(i+1)+"("+metaData.getColumnTypeName(i+1)+"-"+metaData.getColumnDisplaySize(i+1)+")"+"\t");
                }
                System.out.println();
            }
        }catch (Exception e){
            e.getMessage();
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
