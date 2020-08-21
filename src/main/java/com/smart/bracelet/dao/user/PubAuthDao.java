package com.smart.bracelet.dao.user;

import com.smart.bracelet.model.po.user.PubAuth;
import com.smart.bracelet.model.vo.user.PubAuthVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PubAuthDao {

    /**
     * 删除权限信息
     * @param authId
     * @return
     */
    int deleteByPrimaryKey(Long authId);



    /**
     * 添加权限信息
     * @param record
     * @return
     */
    int insertSelective(PubAuth record);

    /**
     * 通过ID查询菜单信息
     * @param authId
     * @return
     */
    PubAuth selectByPrimaryKey(Long authId);

    /**
     * 修改菜单信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(PubAuthVo record);


    /**
     * 权限信息查询分页
     * @return
     */
    List<PubAuth> selectPageAuth();


}
