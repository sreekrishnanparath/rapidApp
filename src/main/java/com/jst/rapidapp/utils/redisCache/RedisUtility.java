package com.jst.rapidapp.utils.redisCache;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class RedisUtility {

    @Qualifier("redisTemplate")
    @Autowired
    private RedisTemplate<Long, List<?>> redisTemplate;

    public void setValue(final long key, List<?> value) {
        redisTemplate.opsForValue().set(key, value);
        redisTemplate.expire(key, 1, TimeUnit.MINUTES);
    }

    public List<?> getValue(final long key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void deleteValue(long key) {
        redisTemplate.delete(key);
    }

}