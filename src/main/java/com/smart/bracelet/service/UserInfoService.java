package com.smart.bracelet.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.UserInfo;

import java.util.List;

/**
 * 用户信息表(UserInfo)表服务接口
 *
 * @author junyunxiao
 * @since 2020-06-30 17:08:11
 */
public interface UserInfoService extends IService<UserInfo> {


    /**
     * 通过用户账号查询用户信息
     *
     * @param userAccount
     * @return
     */
    UserInfo selectUserInfoAccount(String userAccount);



    /**
     * 新增用户信息
     */
    int addUserInfo(UserInfo userInfo) throws CustomerException;

    /**
     * 通过用户账号查询权限
     * @param userAccount
     * @return
     */
    List<String> queryAuthoritys(String userAccount);

}


