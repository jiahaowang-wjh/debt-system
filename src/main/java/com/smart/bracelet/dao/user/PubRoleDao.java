package com.smart.bracelet.dao.user;

import com.smart.bracelet.model.po.user.PubRole;
import com.smart.bracelet.model.po.user.PubRoleauth;
import com.smart.bracelet.model.po.user.PubRolemenu;
import com.smart.bracelet.model.vo.user.PubRoleVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PubRoleDao {

    /**
     * 通过ID删除角色信息
     * @param roleId
     * @return
     */
    int deleteByPrimaryKey(Long roleId);

    /**
     * 通过ID删除角色权限信息
     * @param roleId
     * @return
     */
    int deleteRoleauthByPrimaryKey(Long roleId);

    /**
     * 通过ID删除角色菜单信息
     * @param roleId
     * @return
     */
    int deleteRoleMenuByPrimaryKey(Long roleId);

    /**
     * 新增角色信息
     * @param record
     * @return
     */
    int insertSelective(PubRole record);

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
    int updateByPrimaryKeySelective(PubRoleVo record);

    /**
     * 给角色分配权限
     * @parampubRoleauth
     * @return
     */
    int addRoleAuth(PubRoleauth pubRoleauth);

    /**
     * 批量新增角色权限
     * @param pubRoleauths
     * @return
     */
    int addRoleAuthList(List<PubRoleauth> pubRoleauths);

    /**
     * 给角色添加菜单
     * @param pubRolemenu
     * @return
     */
    int addRoleMenu(List<PubRolemenu> pubRolemenu);

    /**
     * 批量删除角色
     * @param roleIds
     * @return
     */
    int delRoleList(Long[] roleIds);

    List<PubRole> queryRole();

}