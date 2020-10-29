package com.smart.bracelet.dao.user;

import com.smart.bracelet.model.po.user.*;
import com.smart.bracelet.model.vo.user.PersonOnUserOnComVo;
import com.smart.bracelet.model.vo.user.PubUserVo;
import com.smart.bracelet.model.vo.user.UserMenu;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PubUserDao {

    /**
     * 通过Id删除用户信息
     * @param userId
     * @return
     */
    int deleteByPrimaryKey(Long userId);

    /**
     * 新增用户信息
     * @param record
     * @return
     */
    int insertSelective(PubUser record);

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
    int updateByPrimaryKeySelective(PubUserVo record);


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

    /**
     * 通过用户ID查询菜单信息
     * @return
     */
    List<PubMenu> selectMenuByUserId(Long userId);

    /**
     * 通过角色ID查询权限信息
     * @return
     */
    List<PubAuth> selectAuthByRoleId(Long roleId,Long menuId);

    /**
     * 修改密码
     * @param passWord
     * @param personId
     * @return
     */
    int updateUserPwd(String passWord,Long personId);

    /**
     * 批量删除用户
     * @param userIds
     * @return
     */
    int delUserList(Long[] userIds);

    /**
     * 人员公司用户联查
     * @return
     */
    List<PersonOnUserOnCom> queryList();

    /**
     * 查询用户公司Id
     * @param userId
     * @return
     */
    Long selectUserComId(Long userId);

    /**
     * 批量删除人员
     * @param ids
     * @return
     */
    int delListPerson(Long[] ids);

    /**
     * 更新人员信息
     */
    int updatePerson(PersonOnUserOnComVo personOnUserOnComVo);


}
