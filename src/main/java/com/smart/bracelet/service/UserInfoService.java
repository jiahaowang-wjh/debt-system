package com.smart.bracelet.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.bracelet.model.UserInfo;

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
}
