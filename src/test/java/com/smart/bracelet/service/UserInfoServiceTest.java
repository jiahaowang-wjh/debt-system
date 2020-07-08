package com.smart.bracelet.service;

import com.smart.bracelet.utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserInfoServiceTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void cacheAdd() {
        redisTemplate.opsForValue().set("laboratory_reserve_time_out_remind_"+IdUtils.nextId(),IdUtils.nextId(),50,TimeUnit.SECONDS);
        //超时10分钟发送信息给管理员
       // redisTemplate.opsForSet().add(CacheConstants.CACHE_LABORATORY_RESERVE_TIME_OUT_REMIND_PREFIX+"_"+vo.getReserveInfoId(),vo.getUserInfoId(),timeOutToEpochSecond, TimeUnit.SECONDS);
    }
}