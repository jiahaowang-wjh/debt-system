package com.smart.bracelet.dao;

import com.smart.bracelet.model.po.PubUser;
import com.smart.bracelet.model.vo.PubUserVo;
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


}
