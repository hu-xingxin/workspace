package com.basictest.xiancheng.how2j.method.test;

/**
 * @author huxingxin
 * @createTime 2021年07月22日 16:31:49
 * @Description 练习-破解密码
 * 1. 生成一个长度是3的随机字符串，把这个字符串当作 密码
 *
 * 2. 使用穷举法，匹配这个密码-for循环
 */
public class Test2 {
    public static void main(String[] args) {
        checkPassword();
    }


    /**
     * 校验：只匹配字母和数字
     * @param i
     * @param j
     * @param k
     * @param l
     * @return
     */
    public static boolean isLetterOrDigit(short i, short j, short k, short l) {
//       java.lang.Character.isLetterOrDigit(int codePoint)
//       确定指定字符(Unicode代码点)是一个字母或数字
        return  Character.isLetterOrDigit(i) &&
                Character.isLetterOrDigit(j) &&
                Character.isLetterOrDigit(k) &&
                Character.isLetterOrDigit(l);
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

        return new String(oldCharPassword);
    }

    /**
     * 破解密码
     */
    public static void checkPassword(){
        String oldPassword = getPool();
        System.out.println("密码是：" + oldPassword);
        //穷举法找出密码-多层循环方式
        char[] newCharPassword = new char[4];//用字符数组记录密码
        outloop:
        for (short i = '0'; i <= 'z'; i++){
            for (short j = '0'; j <= 'z'; j++){
                for (short k = '0'; k <= 'z'; k++){
                    for (short l = '0'; l<= 'z'; l++){
                        //只匹配数字和字母
                        if(!isLetterOrDigit(i,j,k,l)){
                            continue ;
                        }

                        newCharPassword[0]=(char)i;
                        newCharPassword[1]=(char)j;
                        newCharPassword[2]=(char)k;
                        newCharPassword[3]=(char)l;
                        String newPassword = new String(newCharPassword);
                        //判断是否匹配
                        if (oldPassword.equals(newPassword)){
                            System.out.println("找到密码为：" + newPassword);
                            break outloop;
                        }
                    }
                }
            }
        }
    }


}
