package com.basictest.xiancheng.how2j.method.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author huxingxin
 * @createTime 2021年07月23日 23:16:31
 * @Description
 * 1. 生成一个长度是3的随机字符串，把这个字符串当作 密码
 *
 * 2. 创建一个破解线程，使用穷举法，匹配这个密码
 *
 * 3. 创建一个日志线程，打印都用过哪些字符串去匹配，这个日志线程设计为守护线程
 *
 * 提示： 破解线程把穷举法生成的可能密码放在一个容器中，日志线程不断的从这个容器中拿出可能密码，并打印出来。
 * 如果发现容器是空的，就休息1秒，如果发现不是空的，就不停的取出，并打印。
 */
public class Test4 {
    static List<String> passwordList = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        char[] chars = new char[4];
        String oldPassword = getPool();

        //破解线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                checkPassword(oldPassword,chars,0);
            }
        }).start();

        //日志线程
        Thread logThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    for (int i=passwordList.size(); i > 0; i--){
                        String password = passwordList.remove(i-1);
                        writeToFile(Thread.currentThread().getName() + "---" + password);
//                        System.out.println(Thread.currentThread().getName() + "---" + password);
                    }
                }
            }
        });

        logThread.setDaemon(true);
        logThread.start();
    }

    /**
     * 生成密码
     * @return
     */
    public static String getPool(){
        String pool="";//字符池 随机密码的创建 是从字符池随机挑选的
        for(short i = '0'; i <= '9'; i++){
            pool+=(char)i;
        }
        for(short j = 'a'; j <= 'z'; j++){
            pool+=(char)j;
        }
        for(short k = 'A'; k <= 'Z'; k++){
            pool+=(char)k;
        }

        char[] oldCharPassword = new char[4];
        for (int i = 0; i < 4; i++){
            //Math.random()0-1之间的随机数 和 pool.length()的积 始终是在 0-pool.length()之间
            int index = (int) (Math.random() * pool.length());
            //从字符池随机挑选四个字符 组成密码
            oldCharPassword[i]=pool.charAt(index);
        }
        System.out.println("密码是：" + new String(oldCharPassword));
        return new String(oldCharPassword);
    }

    /**
     * 破解密码 穷举法找出密码-递归
     */
    public static void checkPassword(String oldPassword,char[] chars, int index){
        for (short i = '0'; i <= 'z'; i++) {
            char c = (char) i;
            if(!Character.isLetterOrDigit(c)){
                continue;
            }
            //密码为四位数 由数字和字母进行组合
            if (index < 4) {
                chars[index] = c;
                String str = new String(chars);
                //System.out.println(str);
                //把匹配过的密码放置到容器里面
                passwordList.add(str);
//                System.out.println(passwordList);
                ////判断是否匹配
                if(str.equals(oldPassword)){
                    System.out.println("找到了，密码是" + str);
                    writeToFile("找到了，密码是" + str);
                    return;
                }
                //不匹配 进行递归 继续查找
                checkPassword(oldPassword, chars, index+1);
            }else {
                return;
            }
        }
    }

    /**
     * 把递归生成的数据写入文件保存下来
     * @param password
     */
    public static void writeToFile(String password){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\tmp\\txt\\password.txt",true))){
            bw.write(password);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
