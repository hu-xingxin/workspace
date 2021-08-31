package com.tools.hutool.encoder;

import cn.hutool.core.util.HashUtil;
import com.tools.hutool.utils.print.Comment;
import com.tools.hutool.utils.print.LogUtil;
import org.junit.Test;

/**
 * @author huxingxin
 * @createTime 2021年08月01日 00:27:33
 * @Description Hash工具
 */
public class HashTest {
    LogUtil logUtil = new LogUtil(HashTest.class);
    @Test
    @Comment("各种各样的hash算法")
    public void getHashCode() {
        String s = "how2j.cn- java教程";
        int number = 12;
        long hash1 = HashUtil.additiveHash(s, Integer.MAX_VALUE);
        long hash2 = HashUtil.rotatingHash(s, Integer.MAX_VALUE);
        long hash3 = HashUtil.oneByOneHash(s);
        long hash4 = HashUtil.bernstein(s);
//      long hash5 = HashUtil.universal(s); 怎么调用？站长不会调用。。。颜面~~~
//      long hash6 = HashUtil.zobrist(s);
        long hash7 = HashUtil.fnvHash(s);
        long hash8 = HashUtil.intHash(number);
        long hash9 = HashUtil.rsHash(s);
        long hash10 = HashUtil.jsHash(s);
        long hash11 = HashUtil.pjwHash(s);
        long hash12 = HashUtil.elfHash(s);
        long hash13 = HashUtil.bkdrHash(s);
        long hash14 = HashUtil.sdbmHash(s);
        long hash15 = HashUtil.djbHash(s);
        long hash16 = HashUtil.dekHash(s);
        long hash17 = HashUtil.apHash(s);
        long hash18 = HashUtil.tianlHash(s);
        long hash19 = HashUtil.javaDefaultHash(s);
        long hash20 = HashUtil.mixHash(s);
        logUtil.formatPrint("原数据",s, "加法算法对应的哈希值", hash1);
        logUtil.formatPrint("原数据",s, "旋转算法对应的哈希值", hash2);
        logUtil.formatPrint("原数据",s, "一次一个算法对应的哈希值", hash3);
        logUtil.formatPrint("原数据",s, "Bernstein's算法对应的哈希值", hash4);
//      logUtil.formatPrint("原数据",s, " Universal 算法对应的哈希值", hash5);
//      logUtil.formatPrint("原数据",s, " Zobrist 算法对应的哈希值", hash6);
        logUtil.formatPrint("原数据",s, " 改进的32位FNV 算法对应的哈希值", hash7);
        logUtil.formatPrint("原数据",s, "Thomas Wang的整数算法对应的哈希值", hash8);
        logUtil.formatPrint("原数据",s, "RS算法对应的哈希值", hash9);
        logUtil.formatPrint("原数据",s, "JS算法对应的哈希值", hash10);
        logUtil.formatPrint("原数据",s, "PJ算法对应的哈希值", hash11);
        logUtil.formatPrint("原数据",s, "ELF算法对应的哈希值", hash12);
        logUtil.formatPrint("原数据",s, "BKDR算法对应的哈希值", hash13);
        logUtil.formatPrint("原数据",s, "SDBM算法对应的哈希值", hash14);
        logUtil.formatPrint("原数据",s, "DJB算法对应的哈希值", hash15);
        logUtil.formatPrint("原数据",s, "DEK算法对应的哈希值", hash16);
        logUtil.formatPrint("原数据",s, "AP算法对应的哈希值", hash17);
        logUtil.formatPrint("原数据",s, "TianL算法对应的哈希值", hash18);
        logUtil.formatPrint("原数据",s, "JAVA自己带算法对应的哈希值", hash19);
        logUtil.formatPrint("原数据",s, "混合算法对应的哈希值", hash20);
    }
}
