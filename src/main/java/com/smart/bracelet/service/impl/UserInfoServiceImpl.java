package com.smart.bracelet.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.bracelet.dao.UserInfoDao;
import com.smart.bracelet.model.UserInfo;
import com.smart.bracelet.service.UserInfoService;
import com.smart.bracelet.utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户信息表(UserInfo)表服务实现类
 *
 * @author junyunxiao
 * @since 2020-06-30 17:08:12
 */
@Service("userInfoService")
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfo> implements UserInfoService {

//    @Resource
//    public PasswordEncoder passwordEncoder;

    @Resource
    public UserInfoDao userInfoDao;

    @Override
    public UserInfo selectUserInfoAccount(String userAccount) {
        return this.baseMapper.selectUserInfoAccount(userAccount);
    }

    @Override
    public int addUserInfo(UserInfo userInfo) throws Exception {
        userInfo.setUserInfoId(IdUtils.nextId());
        userInfo.setUserPwd(new BCryptPasswordEncoder().encode(userInfo.getUserPwd()));
        //用户状态 0锁定，1正常
        userInfo.setUserStatus("1");
        try {
            return userInfoDao.addUserInfo(userInfo);
        } catch (Exception e) {
            throw new Exception("新增用户信息失败");
        }
    }
}
