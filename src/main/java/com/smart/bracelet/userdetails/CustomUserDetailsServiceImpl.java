package com.smart.bracelet.userdetails;

import com.smart.bracelet.model.UserInfo;
import com.smart.bracelet.service.UserInfoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author junyunxiao
 * @version 1.0
 * @Description: 描述信息
 * @date 2020/4/13 14:23
 */

@Slf4j
@Component
@AllArgsConstructor
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    private UserInfoService userInfoService;


    @Override
    public UserDetails loadUserByUsername(String userAccount) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoService.selectUserInfoAccount(userAccount);
        if (StringUtils.isEmpty(userInfo)){
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
//        List<String> list = userInfoService.queryAuthoritys(userAccount);
//        //将查询到的权限集合存入到authorities
//        for (String item: list) {
//            authorities.add(new SimpleGrantedAuthority(item));
//        }
        //获取菜单的权限，所有用户登陆后都拥有
        authorities.add(new SimpleGrantedAuthority("menuInfo:query:userInfoId"));
        authorities.add(new SimpleGrantedAuthority("departmentInfo:queryCurrentUserDataScopeTree"));
        authorities.add(new SimpleGrantedAuthority("userInfo:selectOne"));
        return new CustomUserInfo(String.valueOf(userInfo.getUserInfoId()), userInfo.getUserAccount(), userInfo.getUserName(), userInfo.getUserPwd(), userInfo.getUserAvatar(), true, true, true, true, authorities);
    }
}
