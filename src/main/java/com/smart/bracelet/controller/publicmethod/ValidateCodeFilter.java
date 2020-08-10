package com.smart.bracelet.controller.publicmethod;

import com.smart.bracelet.constant.CacheConstants;
import com.smart.bracelet.constant.SecurityConstants;
import com.smart.bracelet.exception.ValidateCodeException;
import com.smart.bracelet.handler.CustomAuthenticationFailureHandler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@AllArgsConstructor
@Slf4j
public class ValidateCodeFilter extends OncePerRequestFilter {

    private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    private final RedisTemplate redisTemplate;

    private static String METHOD = "POST";

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        if (StringUtils.equals(SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_FORM, httpServletRequest.getRequestURI()) && StringUtils.endsWithIgnoreCase(httpServletRequest.getMethod(), METHOD)) {
            try {
                redisTemplate.setKeySerializer(new StringRedisSerializer());
                //获取前端输入的验证码
                String key =  httpServletRequest.getParameter("randomStr");
                //通过输入的验证码获取redis中的码值
                String code = (String) redisTemplate.opsForValue().get(CacheConstants.DEFAULT_CODE_KEY +key);
                //String parameterCode = httpServletRequest.getParameter("verificationCode");
                if (StringUtils.isBlank(key)) {
                    throw new ValidateCodeException("验证码不能为空");
                }
                if (StringUtils.isBlank(code)) {
                    throw new ValidateCodeException("验证码输入错误");
                }
                filterChain.doFilter(httpServletRequest, httpServletResponse);
            } catch (ValidateCodeException e) {
                customAuthenticationFailureHandler.onAuthenticationFailure(httpServletRequest, httpServletResponse, e);
            }
        } else {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }
    }
}
