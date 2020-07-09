package com.smart.bracelet.service;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.PubAuth;
import com.smart.bracelet.model.vo.PubAuthVo;

public interface PubAuthService {
    /**
     * 删除权限信息
     * @param authId
     * @return
     */
    int deleteByPrimaryKey(Long authId) throws CustomerException;

    /**
     * 添加权限信息
     * @param record
     * @return
     */
    int insertSelective(PubAuth record) throws CustomerException;

    /**
     * 通过ID查询权限信息
     * @param authId
     * @return
     */
    PubAuth selectByPrimaryKey(Long authId);

    /**
     * 修改权限信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(PubAuthVo record) throws CustomerException;
}
