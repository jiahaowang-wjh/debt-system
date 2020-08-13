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
        additionalInfo.put("userNickname", customUserInfo.getUsername());
        additionalInfo.put("userAvatar", customUserInfo.getUserAvatar());
        additionalInfo.put("personId",customUserInfo.getPersonId());
        additionalInfo.put("companyId",customUserInfo.getComId());
        additionalInfo.put("roleId",customUserInfo.getRoleId());
        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(additionalInfo);
        return oAuth2AccessToken;
    }
}
