package com.smart.bracelet.handler;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.smart.bracelet.enums.AuthorizationType;
import com.smart.bracelet.enums.Contentype;
import com.smart.bracelet.enums.SuccessResultCode;
import com.smart.bracelet.message.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author junyunxiao
 * @version 1.0
 * @Description: 描述信息
 * @date 2019/6/10 16:07
 */
@Component
@Slf4j
public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    /*RedisTokenStore*/


    @Resource
    private ClientDetailsService clientDetailsService;

    @Resource
    @Lazy
    private AuthorizationServerTokenServices authorizationServerTokenServices;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        log.info("认证成功，进行业务逻辑处理");
        String header = request.getHeader("Authorization");
        if (StrUtil.isBlank(header)) {
            throw new UnapprovedClientAuthenticationException("请求头为空");
        }
        if (!header.startsWith(AuthorizationType.BASIC.getType())) {
            throw new UnapprovedClientAuthenticationException("请求头中无client相关信息,请检查");
        }
        String[] tokens = this.extractAndDecodeHeader(header);
        assert tokens.length == 2;
        String clientId = tokens[0];
        String clientSecret = tokens[1];
        try {
            ClientDetails details = clientDetailsService.loadClientByClientId(clientId);
            if (!details.getClientSecret().equals(clientSecret)) {
                throw new UnapprovedClientAuthenticationException("clientSecret不匹配:" + clientSecret);
            }
            TokenRequest tokenRequest = new TokenRequest(MapUtils.EMPTY_MAP, clientId, details.getScope(), "all");
            OAuth2Request auth2Request = tokenRequest.createOAuth2Request(details);
            OAuth2Authentication oAuth2Authentication = new OAuth2Authentication(auth2Request, authentication);
            OAuth2AccessToken oAuth2AccessToken = authorizationServerTokenServices.createAccessToken(oAuth2Authentication);
            response.setContentType(Contentype.JSON.getType());
            response.getWriter().write(JSONUtil.toJsonStr(Result.success(SuccessResultCode.AUTHENTICATION_SUCCESS.getCode(), SuccessResultCode.AUTHENTICATION_SUCCESS.getMessage(), oAuth2AccessToken)));
        } catch (NoSuchClientException e) {
            throw new UnapprovedClientAuthenticationException("clientId对应的配置信息不存在:" + clientId);
        }
    }

    private String[] extractAndDecodeHeader(String header) {
        byte[] base64Token = header.substring(6).getBytes(StandardCharsets.UTF_8);

        byte[] decoded;
        try {
            decoded = Base64.getDecoder().decode(base64Token);
        } catch (IllegalArgumentException var7) {
            throw new BadCredentialsException("Failed to decode basic authentication token");
        }
        String token = new String(decoded, StandardCharsets.UTF_8);
        int tokenValue = token.indexOf(':');
        if (tokenValue == -1) {
            throw new BadCredentialsException("Invalid basic authentication token");
        } else {
            return new String[]{token.substring(0, tokenValue), token.substring(tokenValue + 1)};
        }
    }
}
