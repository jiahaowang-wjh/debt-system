package com.smart.bracelet.point;

import cn.hutool.json.JSONUtil;
import com.smart.bracelet.enums.Contentype;
import com.smart.bracelet.enums.FailResultCode;
import com.smart.bracelet.message.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author junyunxiao
 * @version 1.0
 * @date 2019/2/25 10:47
 * @date 2020/4/9 11:28
 */
public class AuthExceptionEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse response, AuthenticationException e)
            throws IOException, ServletException {
        response.setContentType(Contentype.JSON.getType());
        response.getWriter().write(JSONUtil.toJsonStr(Result.fail(FailResultCode.INVALID_TOKEN)));
    }
}
