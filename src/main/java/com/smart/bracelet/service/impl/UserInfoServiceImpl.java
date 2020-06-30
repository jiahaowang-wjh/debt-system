package com.smart.bracelet.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.bracelet.dao.UserInfoDao;
import com.smart.bracelet.model.UserInfo;
import com.smart.bracelet.service.UserInfoService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 用户信息表(UserInfo)表服务实现类
 *
 * @author junyunxiao
 * @since 2020-06-30 17:08:12
 */
@Service("userInfoService")
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao,UserInfo> implements UserInfoService {

    /*@Resource
    public PasswordEncoder passwordEncoder;*/

    @Override
    public UserInfo selectUserInfoAccount(String userAccount) {
        /*passwordEncoder.encode("123456");*/
        return this.baseMapper.selectUserInfoAccount(userAccount);
    }

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }
}
