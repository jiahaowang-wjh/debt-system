package com.smart.bracelet.userdetails;

import com.smart.bracelet.model.po.user.PubUser;
import com.smart.bracelet.service.user.PubUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private PubUserService pubUserService;


    @Override
    public UserDetails loadUserByUsername(String userAccount) throws UsernameNotFoundException {
        PubUser pubUser = pubUserService.selectUserInfoAccount(userAccount);
        if (StringUtils.isEmpty(pubUser)) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        Long comId = pubUserService.selectUserComId(pubUser.getUserId());
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<String> list = pubUserService.selectUserAuth(userAccount);
        for (String item : list) {
            System.out.println(item);
            authorities.add(new SimpleGrantedAuthority(item));
        }
        return new CustomUserInfo(pubUser.getUserId().toString(), pubUser.getLoginName(),userAccount, pubUser.getPasswordMd5(),pubUser.getPersonId().toString() ,comId.toString(),pubUser.getRoleId().toString(),null, true, true, true, true, authorities);
    }
}
