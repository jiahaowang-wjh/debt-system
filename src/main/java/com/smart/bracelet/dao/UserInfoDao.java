package com.smart.bracelet.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smart.bracelet.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author junyunxiao
 * @version 1.0
 * @date 2020/6/30 17:11
 * @description 描述信息
 */
@Mapper
public interface UserInfoDao extends BaseMapper<UserInfo> {

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
    int addUserInfo(UserInfo userInfo);

    /**
     * 通过用户账号查询权限
     * @param userAccount
     * @return
     */
    List<String> queryAuthoritys(String userAccount);

}
