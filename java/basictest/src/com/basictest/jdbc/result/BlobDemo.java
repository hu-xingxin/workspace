package com.basictest.jdbc.result;

import com.basictest.jdbc.utils.ConnMysql;

import javax.xml.transform.Result;
import java.io.*;
import java.sql.*;

/**
 * Created in 2021/4/6 0:05
 *
 * @author: huxingxin
 */
public class BlobDemo {
    public static void main(String[] args) throws SQLException {
//        insertBlob();
        selectBlob();
    }


    public static void insertBlob() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String filePath = "E:\\tmp\\image\\1609241880372.png";
        try{
            connection = ConnMysql.connection;
            preparedStatement = connection.prepareStatement("insert into user_avatar(avatar,length,name) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            File file = new File(filePath);
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            preparedStatement.setBinaryStream(1,fileInputStream);
            preparedStatement.setLong(2,file.length());
            preparedStatement.setString(3,file.getName());
            int i = preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
           if (resultSet.next()){
               String key = resultSet.getString(1);
               System.out.println(key);
           }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
    }

    public static void selectBlob() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Blob blob = null;
        try{
            connection = ConnMysql.connection;
            preparedStatement = connection.prepareStatement("select avatar from user_avatar where id = 1;");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                blob = resultSet.getBlob(1);
            }
            byte[] bytes = blob.getBytes(1, (int) blob.length());
            String filePath = "E:\\tmp\\image\\avatar.png";
            FileOutputStream fos = new FileOutputStream(filePath);
            InputStream is = new ByteArrayInputStream(bytes);
            byte[] buffer = new byte[1024];
            int len = 0;
            while((len=is.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
            is.close();
            fos.close();
        }catch (Exception e){
            e.getMessage();
        }finally {
            if (resultSet!=null){
                resultSet.close();
            }
            if(preparedStatement!=null){
                preparedStatement.close();
            }
            if (resultSet!=null){
                resultSet.close();
            }
        }
    }
}
