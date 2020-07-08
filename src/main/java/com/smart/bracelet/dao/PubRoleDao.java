package com.smart.bracelet.dao;

import com.smart.bracelet.model.po.PubRole;
import org.springframework.stereotype.Repository;

@Repository
public interface PubRoleDao {
    int deleteByPrimaryKey(Long roleId);

    int insert(PubRole record);

    int insertSelective(PubRole record);

    PubRole selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(PubRole record);

    int updateByPrimaryKey(PubRole record);
}