package com.basictest.jdbc.result;

import com.basictest.jdbc.utils.ConnMysql;

import java.sql.*;

/**
 * Created in 2021/4/5 21:56
 *
 * @author: huxingxin
 */
public class ResultDemo1 {
    public static void main(String[] args) throws SQLException {
        query();
    }

    public static void query() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
       try {
           String sql = "select * from sp_user";
           connection = ConnMysql.connection;
           preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
           resultSet = preparedStatement.executeQuery();
           boolean last = resultSet.last();
           int row = resultSet.getRow();
           ResultSetMetaData metaData = resultSet.getMetaData();
           int columnCount = metaData.getColumnCount();
           for (int i = row;i > 0;i--){
               resultSet.absolute(i);
//               resultSet.updateString(2,"青丝缠雪");
//               resultSet.updateRow();
               for (int j=0;j<columnCount;j++){
                   System.out.print(resultSet.getString(j+1)+"\t");
               }

               System.out.println();
           }
       }catch (SQLException e){
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
