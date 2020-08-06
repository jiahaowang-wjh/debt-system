package com.smart.bracelet.service.user;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.user.PubRole;
import com.smart.bracelet.model.po.user.PubRoleauth;
import com.smart.bracelet.model.po.user.PubRolemenu;
import com.smart.bracelet.model.vo.user.PubRoleVo;

import java.util.List;

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

    /**
     * 给角色添加菜单
     * @param pubRolemenu
     * @return
     */
    int addRoleMenu(PubRolemenu pubRolemenu) throws CustomerException;

    /**
     * 批量删除角色
     * @param roleIds
     * @return
     */
    int delRoleList(Long[] roleIds) throws CustomerException;

    /**
     * 批量新增角色权限
     * @param pubRoleauths
     * @return
     */
    int addRoleAuthList(String roleIds,Long authId) throws CustomerException;
}
