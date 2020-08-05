package com.smart.bracelet.controller.publicmethod;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.utilesBean.VerifyCode;
import com.smart.bracelet.service.utilsService.IVerifyCodeGen;
import com.smart.bracelet.service.utilsService.impl.SimpleCharVerifyCodeGenImpl;
import com.wordnik.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import java.io.IOException;

@Slf4j
@RestController
@Validated
@RequestMapping("/api/verificationCode")
public class VerificationCode {


    String verifyCodeName;

    @ApiOperation(value = "验证码")
    @GetMapping("/verifyCode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) {
        IVerifyCodeGen iVerifyCodeGen = new SimpleCharVerifyCodeGenImpl();
        try {
            //设置长宽
            VerifyCode verifyCode = iVerifyCodeGen.generate(80, 28);
            String code = verifyCode.getCode();
            verifyCodeName = code;
            log.info(code);
            //将VerifyCode绑定session
            request.getSession().setAttribute("VerifyCode", code);
            //设置响应头
            response.setHeader("Pragma", "no-cache");
            //设置响应头
            response.setHeader("Cache-Control", "no-cache");
            //在代理服务器端防止缓冲
            response.setDateHeader("Expires", 0);
            //设置响应内容类型
            response.setContentType("image/jpeg");
            response.getOutputStream().write(verifyCode.getImgBytes());
            response.getOutputStream().flush();
        } catch (IOException e) {
            log.info("", e);
        }
    }

    @RequestMapping("/codeCompare")
    public Result codeCompare(@NotBlank(message = "验证码不能为空") String codeName) throws CustomerException {
        if(!codeName.equalsIgnoreCase(verifyCodeName)){
           throw new CustomerException("验证码输入错误");
        }
        return Result.success();
    }

}
