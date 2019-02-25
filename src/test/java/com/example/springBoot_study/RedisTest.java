package com.example.springBoot_study;

import com.SpringBootStudyApplication;
import com.sky.pojo.Users;
import org.apache.catalina.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Spring Data Redis 测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootStudyApplication.class)
public class RedisTest {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    /**
     * 添加一个字符串
     */
    @Test
    public void  testSet() {
        this.redisTemplate.opsForValue().set("key", "lsh");
        System.out.println("this = " + this.redisTemplate.opsForValue().get("key"));
    }
    /**
     * 获取一个字符串
     */
    @Test
    public  void testGet(){
        String value =(String) this.redisTemplate.opsForValue().get("key");
        System.out.println("value = " + value);
    }

    /**
     * 添加一个user对象
     */
    @Test
    public  void  setUser(){
        Users users = new Users();
        users.setName("张三丰");
        users.setAge(100);
        users.setId(1);
        //配置是string，这里重设序列化器
        this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        this.redisTemplate.opsForValue().set("users",users);
    }

    /**
     * 获取user对象
     */
    @Test
    public void  getUser(){
        //重新设置序列化器
        this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());

        Users users = (Users)this.redisTemplate.opsForValue().get("users");

        System.out.println("users = " + users);


    }

    /**
     * json格式存取对象
     */
    @Test
    public void  setUserOfJson(){
        Users users = new Users();
        users.setName("张三丰");
        users.setAge(100);
        users.setId(1);
        //设置序列化方式
        this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
        this.redisTemplate.opsForValue().set("users_json",users);
    }
    /**
     * 取json格式对象
     */
    @Test
    public void  getUserOfJson(){
        String value = (String) this.redisTemplate.opsForValue().get("users_json");
        System.out.println("value = " + value);

        this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
        Users users = (Users) this.redisTemplate.opsForValue().get("users_json");
        System.out.println("users = " + users);
    }


}
