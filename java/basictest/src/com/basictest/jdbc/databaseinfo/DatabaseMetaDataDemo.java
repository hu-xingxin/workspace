package com.basictest.jdbc.databaseinfo;

import com.basictest.jdbc.utils.ConnMysql;

import java.sql.*;

/**
 * Created in 2021/4/6 15:59
 * 使用DatabaseMetaData分析数据库信息
 * @author: huxingxin
 */
public class DatabaseMetaDataDemo {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        ResultSet resultSet = null;
        try{
            connection = ConnMysql.connection;
            DatabaseMetaData metaData = connection.getMetaData();

            //mysql支持的所有表类型
            resultSet = metaData.getTableTypes();
//            printResultSet(resultSet);

            //获取当前数据库的所有数据表
            resultSet = metaData.getTables(null, null, "%", new String[]{"TABLE"});
//            printResultSet(resultSet);

            //获取sp_user表的主键
            resultSet = metaData.getPrimaryKeys(null,null,"sp_user");
//            printResultSet(resultSet);

            //获取当前数据库的存储过程
            resultSet = metaData.getProcedures(null,null,"mydbs");
//            printResultSet(resultSet);

            //获取两个表之间的外键约束
            resultSet = metaData.getCrossReference(null, null, "sp_user", null, null, "user_avatar");
//            printResultSet(resultSet);

            //获取sp_user的全部数据列
            resultSet = metaData.getColumns(null,null,"sp_user","%");
            printResultSet(resultSet);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally{
            if(resultSet != null){
                resultSet.close();
            }
            if(connection!=null){
                connection.close();
            }
        }

    }

    @Deprecated
    public static void printResultSet(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();

        int columnCount = metaData.getColumnCount();

        for (int i = 0; i < columnCount; i++) {
            System.out.print(metaData.getColumnName(i+1)+"\t");
        }
        System.out.println();

        while(resultSet.next()){
            for (int i = 0; i < columnCount; i++) {
                System.out.print(resultSet.getString(i+1)+"\t");
            }
            System.out.println();
        }

        resultSet.close();
    }
}
