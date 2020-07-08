package com.smart.bracelet.service;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.PubUser;
import com.smart.bracelet.model.vo.PubUserVo;

import java.util.List;

public interface PubUserService {
    /**
     * 通过Id删除用户信息
     * @param userId
     * @return
     */
    int deleteByPrimaryKey(Long userId) throws CustomerException;

    /**
     * 新增用户信息
     * @param record
     * @return
     */
    int insertSelective(PubUser record) throws CustomerException;

    /**
     * 通过Id查询用户信息
     * @param userId
     * @return
     */
    PubUser selectByPrimaryKey(Long userId);

    /**
     * 修改用户信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(PubUserVo record) throws CustomerException;


    /**
     * 通过用户账号查询用户信息
     *
     * @param pubUser
     * @return
     */
    PubUser selectUserInfoAccount(String pubUser);

    /**
     * 通过账号查询用户权限信息
     * @param logName
     * @return
     */
    List<String> selectUserAuth(String logName);

    /**
     * 查询所有用户
     * @return
     */
    List<PubUser> queryUserList();

}
