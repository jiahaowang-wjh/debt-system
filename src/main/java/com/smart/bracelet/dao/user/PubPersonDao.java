package com.smart.bracelet.dao.user;

import com.smart.bracelet.model.po.user.PubPerson;
import com.smart.bracelet.model.po.user.PubUser;
import com.smart.bracelet.model.vo.user.PubPersonVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 人员信息
 */
@Repository
public interface PubPersonDao {

    int deleteByPrimaryKey(Long personId);

    int insertSelective(PubPerson record);

    PubPerson selectByPrimaryKey(Long personId);

    int updateByPrimaryKeySelective(PubPersonVo record);


    PubPerson selectByPrimaryName(String name);

    /**
     * 查询用户推荐人
     */
    List<PubPerson> selectByType(String personType);

    /**
     * 查询用户推荐人
     */
    List<PubPerson> queryPer();
}