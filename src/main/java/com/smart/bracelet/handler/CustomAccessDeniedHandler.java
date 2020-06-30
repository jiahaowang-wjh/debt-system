package com.smart.bracelet.handler;

import cn.hutool.json.JSONUtil;
import com.smart.bracelet.enums.Contentype;
import com.smart.bracelet.enums.FailResultCode;
import com.smart.bracelet.message.Result;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author junyunxiao
 * @version 1.0
 * @date 2019/2/25 10:57
 * @date 2020/4/9 11:28
 */
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        response.setContentType(Contentype.JSON.getType());
        response.getWriter().write(JSONUtil.toJsonStr(Result.fail(FailResultCode.ACCESS_DENIED)));
    }
}
