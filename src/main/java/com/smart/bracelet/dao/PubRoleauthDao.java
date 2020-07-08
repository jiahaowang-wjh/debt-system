package com.smart.bracelet.dao;

import com.smart.bracelet.model.po.PubRoleauth;
import org.springframework.stereotype.Repository;

@Repository
public interface PubRoleauthDao {
    int deleteByPrimaryKey(Long roleauthId);

    int insert(PubRoleauth record);

    int insertSelective(PubRoleauth record);

    PubRoleauth selectByPrimaryKey(Long roleauthId);

    int updateByPrimaryKeySelective(PubRoleauth record);

    int updateByPrimaryKey(PubRoleauth record);
}