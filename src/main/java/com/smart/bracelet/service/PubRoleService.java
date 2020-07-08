package com.smart.bracelet.service;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.PubRole;
import com.smart.bracelet.model.po.PubRoleauth;
import com.smart.bracelet.model.vo.PubRoleVo;

public interface PubRoleService {

    /**
     * 通过ID删除角色信息
     * @param roleId
     * @return
     */
    int deleteByPrimaryKey(Long roleId) throws CustomerException;

    /**
     * 新增角色信息
     * @param record
     * @return
     */
    int insertSelective(PubRole record) throws CustomerException;

    /**
     * 通过Id查询角色信息
     * @param roleId
     * @return
     */
    PubRole selectByPrimaryKey(Long roleId);

    /**
     * 修改角色信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(PubRoleVo record) throws CustomerException;

    /**
     * 给角色分配权限
     * @parampubRoleauth
     * @return
     */
    int addRoleAuth(PubRoleauth pubRoleauth) throws CustomerException;
}
