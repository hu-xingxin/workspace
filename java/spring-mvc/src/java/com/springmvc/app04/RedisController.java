package com.springmvc.app04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author huxingxin
 * @createTime 2021年08月20日 15:26:32
 * @Description
 */
@Controller
@RequestMapping("redis")
public class RedisController {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @PostMapping("add")
    @ResponseBody
    public String add(){
        /**
         * 解决键值对出现 \xAC\xED\x00\x05t\x00\x07
         * 虽然不影响程序读取数据 但是看起来很不爽
         * 出现原因: 在RedisTemplate源码里面可以知道默认序列化是使用的JdkSerializationRedisSerializer就是jdk自己的序列化方式
         * 解决办法 设置序列化方式为StringRedisSerializer
         * 或者直接使用  StringRedisTemplate
         */
        StringRedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);

        redisTemplate.opsForList().rightPush("language","Chinese");
        redisTemplate.opsForList().rightPush("language","English");
        redisTemplate.opsForList().rightPush("language","Japanese");
        return "addOk";
    }

    @PostMapping("get")
    @ResponseBody
    public List<Object> get(){
        List<Object> language = redisTemplate.opsForList().range("language", 0, -1);
        return language;
    }
}
