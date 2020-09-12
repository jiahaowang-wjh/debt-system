package com.smart.bracelet.controller.common;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.smart.bracelet.constant.CacheConstants;
import com.smart.bracelet.enums.FailResultCode;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.utils.HttpUtils;
import com.smart.bracelet.utils.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *短信发送Controller
 */
@RestController
@RequestMapping("/api/smsSend/")
@Validated
public class ComSmssendController {


    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping("/sendCheckNO")
    public Result deleteByPrimaryKey(@NotBlank(message = "电话号码") String tel) throws CustomerException,Exception {
        String code = RandomUtils.randomNumberString(4);
        redisTemplate.opsForValue().set(CacheConstants.TEL_CODE_KEY + tel, code);
        //验证码
        SendSmsResponse sendSmsResponse =  HttpUtils.sendSms(tel,"SMS_199590258","{\"code\":\""+code+"\"}");
        return Result.success(sendSmsResponse.getCode()+sendSmsResponse.getMessage());
    }

    @RequestMapping("/checkNO")
    public Result insertSelective(@NotBlank(message = "验证码") String checkNo,@NotBlank(message = "电话号码") String tel) throws CustomerException {
        //通过输入的验证码获取redis中的码值
        String code = (String) redisTemplate.opsForValue().get(CacheConstants.TEL_CODE_KEY +tel);
        Result result = new Result();
        if(code.equals(checkNo)){
            result=Result.success("");
        }else{
            result=Result.fail(FailResultCode.VALIDATE_CODE_ERR);
        }
        return result;
    }
}
