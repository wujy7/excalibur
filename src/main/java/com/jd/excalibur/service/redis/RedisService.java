package com.jd.excalibur.service.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public String getVal(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }

    public void setVal(String key,String val){
        stringRedisTemplate.opsForValue().set(key,val);
    }

    public void delVal(String key){
        stringRedisTemplate.delete(key);
    }



}
