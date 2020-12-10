package com.sdh.redis.subscribe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
public class RedisPublisher {
    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    public void publish(String key) {
        redisTemplate.opsForValue().set(key,new Random().nextInt(200),10, TimeUnit.SECONDS);
    }

    @Scheduled(cron = "15 * * * * ?")
    public void schedulePublish() {
        System.out.println("new str2 set");
        redisTemplate.opsForValue().set("str2",new Random().nextInt(200),10, TimeUnit.SECONDS);
    }
}
