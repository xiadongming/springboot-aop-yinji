package com.example.demo.jobs;

import com.example.demo.common.RedisKeys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Iterator;
import java.util.Set;

/**
 * 获取redis中的数据,在系统启动的时候，就开始执行
 * **/
@Component
public class RedisJobs implements ApplicationRunner {
    final  Logger logger = LoggerFactory.getLogger(RedisJobs.class);
    /***
     * 如果redis中有数据，就打印出来，通过pop
     * **/
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {


        //专门new一条线程，来做这个任务
     new Thread(){
         @Override
         public void run() {
               while (true){
                   String rightPopValue = stringRedisTemplate.opsForList().rightPop(RedisKeys.CT_KEY);
              //     logger.info("从redis中获取的消息是："+rightPopValue);
                   if(!StringUtils.isEmpty(rightPopValue)){
                       System.out.println("redis中获取消息："+rightPopValue);
                   }
                   Set<String> keysSet = redisTemplate.keys("*");
                   Iterator<String> iterator = keysSet.iterator();
                   while (iterator.hasNext()){
                       System.out.println(" redis-cluster中的所有key是： "+redisTemplate.keys("*"));
                       try {
                           Thread.sleep(10000);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
                   try {
                       Thread.sleep(2000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
         }
     }.start();



    }
}
