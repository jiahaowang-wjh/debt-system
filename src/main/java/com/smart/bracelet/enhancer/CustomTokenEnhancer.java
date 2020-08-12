package com.smart.bracelet.enhancer;

import com.smart.bracelet.userdetails.CustomUserInfo;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author junyunxiao
 * @version 1.0
 * @Description: 描述信息
 * @date 2019/11/16 14:11
 */
public class CustomTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        final Map<String, Object> additionalInfo = new HashMap<>(8);
        CustomUserInfo customUserInfo = (CustomUserInfo) oAuth2Authentication.getPrincipal();
        additionalInfo.put("userInfoId", customUserInfo.getUserInfoId());
        additionalInfo.put("登录名", customUserInfo.getUsername());
        additionalInfo.put("登录图像", customUserInfo.getUserAvatar());
        additionalInfo.put("人员ID",customUserInfo.getPersonId());
        additionalInfo.put("公司ID",customUserInfo.getComId());
        additionalInfo.put("角色Id",customUserInfo.getRoleId());
        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(additionalInfo);
        return oAuth2AccessToken;
    }
}
