package com.basictest.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huxingxin
 * @createTime 2021年07月29日 20:33:51
 * @Description
 */
public class SqlUtil {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

//        List<String> importSql = importSql("127.0.0.1", "root","123456","protal","D:\\protal.sql");
//        List<String> exportSql = exportSql("127.0.0.1", "root","123456","tocc","D:\\protal.sql");
        List<String> exportSql = exportSql("10.214.111.149", "root","\"ls_3er4#ER$\"","protal","D:\\protal_new.sql");

        ProcessBuilder builder = new ProcessBuilder(exportSql);

        // 重定向错误流到标准输出流
        builder.redirectErrorStream(true);
        //开始执行
        Process process = builder.start();

        //关闭流释放资源 才能正确继续向下执行
        if(process != null) {
            process.getOutputStream().close();
        }

        try (InputStream is = process.getInputStream()){
        byte[] buff = new byte[1024];
        int index = 0;
        while ((index = is.read(buff)) != -1){
            System.out.println(new String(buff,0,index));
            long endTime = System.currentTimeMillis();
            System.out.println("时间：" + (endTime-startTime)/1000);
        }
        process.waitFor();
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    /**
     * 往数据库导入sql文件
     * @param database
     * @param filepath
     * @return
     */
    public static List<String> importSql(String ip, String root, String password, String database, String filepath){
        System.out.println("开始往数据库导入sql文件...");
        List<String> cmd = new ArrayList<>();
        cmd.add("cmd");
        cmd.add("/k");
        cmd.add("mysql");
        cmd.add("-h"+ip);
        cmd.add("-u"+root);
        cmd.add("-p"+password);
        cmd.add(database);
        cmd.add("<");
        cmd.add(filepath);
        return cmd;
    }

    /**
     * 从数据库导出ql文件
     * @param database
     * @param filepath
     * @return
     */
    public static List<String> exportSql(String ip, String root, String password, String database, String filepath){
        System.out.println("开始从数据库导出ql文件...");
        List<String> cmd = new ArrayList<>();
        cmd.add("cmd");
        cmd.add("/k");
        cmd.add("mysqldump");
        cmd.add("-h"+ip);
        cmd.add("-u"+root);
        cmd.add("-p"+password);
        cmd.add(database);
        cmd.add(">");
        cmd.add(filepath);
        return cmd;
    }
}
