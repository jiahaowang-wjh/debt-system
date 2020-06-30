package com.smart.bracelet.handler;

import cn.hutool.json.JSONUtil;
import com.smart.bracelet.enums.Contentype;
import com.smart.bracelet.enums.FailResultCode;
import com.smart.bracelet.message.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author junyunxiao
 * @version 1.0
 * @Description: 描述信息
 * @date 2019/6/10 16:13
 */
@Component
@Slf4j
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {


    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        log.info("认证失败，进行业务逻辑处理");
        httpServletResponse.setContentType(Contentype.JSON.getType());
        if (e instanceof UsernameNotFoundException) {
            httpServletResponse.getWriter().write(JSONUtil.toJsonStr(Result.fail(FailResultCode.USERNAME_NOTFOUND)));
        } else if (e instanceof BadCredentialsException) {
            httpServletResponse.getWriter().write(JSONUtil.toJsonStr(Result.fail(FailResultCode.PASSWORD_ERR)));
        } else if (e instanceof LockedException) {
            httpServletResponse.getWriter().write(JSONUtil.toJsonStr(Result.fail(FailResultCode.LOCKED)));
        } else {
            httpServletResponse.getWriter().write(JSONUtil.toJsonStr(Result.fail(FailResultCode.AUTHENTICATION_FAIL.getCode(),e.getMessage())));
        }

    }
}
