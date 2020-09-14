package com.smart.bracelet.service.user;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.user.PubMenu;
import com.smart.bracelet.model.po.user.PubUser;
import com.smart.bracelet.model.po.user.PersonOnUserOnCom;
import com.smart.bracelet.model.vo.user.PersonOnUserOnComVo;
import com.smart.bracelet.model.vo.user.PubUserVo;
import com.smart.bracelet.model.vo.user.UserMenu;

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

    /**
     * 通过用户ID查询菜单信息
     * @return
     */
    List<PubMenu> selectMenuByUserId(Long userId);

    /**
     * 修改密码
     * @param outPwd
     * @param newPwdA
     * @param newPwdB
     * @param personId
     * @return
     * @throws CustomerException
     */
    int updateUserPwd(String outPwd,String newPwdA,String newPwdB,Long personId) throws CustomerException;

    /**
     * 批量删除用户
     * @param userIds
     * @return
     */
    int delUserList(Long[] userIds) throws CustomerException;

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
    int delListPerson(Long[] ids) throws CustomerException;

    /**
     * 更新人员信息
     */
    int updatePerson(PersonOnUserOnComVo personOnUserOnComVo) throws CustomerException;

}
