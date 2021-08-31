package com.redis.demo1;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.SortingParams;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author huxingxin
 * @createTime 2021年08月20日 10:45:12
 * @Description
 */
public class RedisTest {
    //连接redis 获取jedis
    static Jedis jedis = new Jedis("localhost", 6379);

    /**
     * 操作字符串
     * curd
     */
    @Test
    public void strTest(){
        //添加字符串
        String isSet = jedis.set("name", "redis");//Ok
        //根据key获取字符串
        String name = jedis.get("name");//"name"
        //根据key 在原来基础上 追加数据
        Long length = jedis.append("name", "123");//返回字符串的现有长度
        //根据key 修改原来的数据
        jedis.set("name","zhangsan");
        //根据key 删除
        jedis.del("name");

        jedis.set("name","姓名");
        //修改key的名称
        jedis.rename("name","newName");
        jedis.del("newName");

        //批量添加数据
        jedis.mset("name","姓名","age","年龄","sex","性别");
        //判断是否存在sex这个建
        Boolean exists = jedis.exists("sex");
        //清空所有数据
        jedis.flushAll();
    }

    /**
     * 操作Map
     */
    @Test
    public void mapTest(){
        HashMap<String, String> user= new HashMap<>();
        user.put("name","姓名");
        user.put("age","年龄");
        user.put("sex","性别");
        //添加map
        jedis.hmset("user",user);

        HashMap<String, String> newUser= new HashMap<>();
        newUser.put("name","");
        //只会修改map里面的name的值
        jedis.hmset("user",newUser );

        //获取map里面 "user", "name", "age", "sex" 的值 返回一个list
        List<String> userStr = jedis.hmget("user", "name", "age", "sex");
        //删除map中的name
        jedis.hdel("user","name");

        //name 被删除了 返回null
        List<String> userStr1 = jedis.hmget("user", "name","age");//[null, 年龄]

        Long userLen = jedis.hlen("user");//返回map里面键的个数

        Boolean isExists = jedis.exists("user");//是否在user这个建

        Set<String> userKey = jedis.hkeys("user");//返回map对象中所有的jey

        List<String> userValue = jedis.hvals("user");//返回map对象中所有的value

//        jedis.flushAll();
    }

    /**
     * 操作List
     */
    @Test
    public void listTest(){
        jedis.lpush("language","Chinese","English","Japanese");
        jedis.lpush("language","French");

        //list 下标 从0开始
        List<String> language = jedis.lrange("language", 0, 1);//-1 表示所有

        jedis.flushAll();
    }

    /**
     * 操作Set
     */
    @Test
    public void setTest(){
        jedis.sadd("language","Chinese","English","Japanese");
        jedis.sadd("language","French");

        jedis.srem("language","Japanese");

        jedis.flushAll();
    }

    @Test
    public void otherTest(){
        //返回当前库中所有的key * 通配符
//        Set<String> keys = jedis.keys("*");
//        Set<String> language = jedis.keys("language*");
//
//        //秒为单位返回user这个键的有效时间  -1表示永远不过期 -2表示键不存在
//        Long ttl = jedis.ttl("user");
//
//        //设置user的有效期为 5秒
//        jedis.setex("user",5,"min");

        //排序 非数值排序
        SortingParams sortingParams = new SortingParams();
        sortingParams.alpha();//
        sortingParams.desc();//降序
        jedis.sort("language",sortingParams,"language");
        List<String> languageDesc = jedis.lrange("language", 0, -1);
        jedis.sort("language",sortingParams,"language");
        //这里重新设置排序规则 是无效的 不会覆盖前面的设置
        sortingParams.asc();
        List<String> languageAsc = jedis.lrange("language", 0, -1);
    }
}
