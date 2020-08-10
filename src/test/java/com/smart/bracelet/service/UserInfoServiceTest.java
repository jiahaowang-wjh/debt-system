package com.smart.bracelet.service;

import com.smart.bracelet.model.utilesBean.VerifyCode;
import com.smart.bracelet.service.utilsService.IVerifyCodeGen;
import com.smart.bracelet.service.utilsService.impl.SimpleCharVerifyCodeGenImpl;
import com.smart.bracelet.utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.UUID;
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

    @Test
    public void testA() throws IOException {
        IVerifyCodeGen iVerifyCodeGen = new SimpleCharVerifyCodeGenImpl();
        VerifyCode generate = iVerifyCodeGen.generate(80, 20);
        String code = generate.getCode();
        System.out.println(code);
    }
}