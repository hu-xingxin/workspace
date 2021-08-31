package com.basictest.xiancheng.how2j.method.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author huxingxin
 * @createTime 2021年07月22日 16:31:49
 * @Description 练习-破解密码
 * 1. 生成一个长度是3的随机字符串，把这个字符串当作 密码
 *
 * 2. 使用穷举法，匹配这个密码-递归
 */
public class Test3 {

    public static void main(String[] args) {
        char[] chars = new char[4];
        String oldPassword = getPool();
        checkPassword(oldPassword,chars,0);
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
                String str = new String(chars);

//                System.out.println(str);
                chars[index] = c;

//                writeToFile(str);
                ////判断是否匹配
                if(str.equals(oldPassword)){
                    System.out.println("找到了，密码是" + str);
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
