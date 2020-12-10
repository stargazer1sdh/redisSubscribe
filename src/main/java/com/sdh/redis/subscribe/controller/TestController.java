package com.sdh.redis.subscribe.controller;

import com.sdh.redis.subscribe.RedisPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    RedisPublisher redisPublisher;

    @GetMapping("/redis/{key}")
    public String pubishEvent(@PathVariable String key){
        redisPublisher.publish(key);
        return "OK";
    }
}
