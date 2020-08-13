package com.smart.bracelet.controller.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.smart.bracelet.enums.FailResultCode;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.utils.HttpUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * 身份认证Controller
 */
@RestController
@RequestMapping("/api/safrv/")
@Validated
public class ComSafrvController {

    @RequestMapping("/safrvCheck")
    public Result safrvCheck(@NotNull(message = "身份证号码") String identifyNum, @NotNull(message = "手机号码") String mobilePhone, @NotNull(message = "姓名") String userName, @NotNull(message = "银行卡号") String bankCard) throws CustomerException,Exception {
        String resultCon = HttpUtils.safrv3metaIdNamePhone(identifyNum,mobilePhone,userName,bankCard);
        JSONObject jsonObject = JSON.parseObject(resultCon);
        String code = jsonObject.getString("code");
        Result result = new Result();
        if("200".equals(code)){
            String value = jsonObject.getString("value");
            String bizCode = JSON.parseObject(value).getString("bizCode");
            if("0".equals(bizCode)){
                result = Result.success("");
            }else if("13053".equals(bizCode)){
                result=Result.fail(FailResultCode.CODE_13053_CODE_ERR);
            }else if("13054".equals(bizCode)){
                result=Result.fail(FailResultCode.CODE_13054_CODE_ERR);
            }else if("13055".equals(bizCode)){
                result=Result.fail(FailResultCode.CODE_13055_CODE_ERR);
            }else if("13056".equals(bizCode)){
                result=Result.fail(FailResultCode.CODE_13056_CODE_ERR);
            }else if("13057".equals(bizCode)){
                result=Result.fail(FailResultCode.CODE_13057_CODE_ERR);
            }else if("13066".equals(bizCode)){
                result=Result.fail(FailResultCode.CODE_13066_CODE_ERR);
            }
        }else{
            result=Result.fail(FailResultCode.SAFRV_CODE_ERR);
        }
        return result;
    }
}
