package com.basictest.inet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author huxingxin
 * @date 2021/4/14 10:25
 * @Description:
 */
public class InetAddressTest {
    public static void main(String[] args) throws Exception {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

//        InetAddress localhost = InetAddress .getByAddress(new byte[]{127, 0, 0, 1});
//        System.out.println(localhost.isReachable(2000));
//        System.out.println(localhost.getCanonicalHostName());//此ip地址的全限定域名
//        System.out.println(localhost.getHostName());//此ip地址的主机名
//        System.out.println(localhost.getHostAddress());//此InetAddress实例对应的IP地址字符串


//        InetAddress ip = InetAddress.getByName("36.152.44.95");
//        System.out.println(ip.isReachable(2000));
//        System.out.println(ip.getCanonicalHostName());
//        System.out.println(ip.getHostName());
//        System.out.println(ip.getHostAddress());


    }
}
