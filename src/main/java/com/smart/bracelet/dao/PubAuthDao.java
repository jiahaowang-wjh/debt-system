package com.smart.bracelet.dao;

import com.smart.bracelet.model.po.PubAuth;
import org.springframework.stereotype.Repository;

@Repository
public interface PubAuthDao {

    int deleteByPrimaryKey(Long authId);

    int insertSelective(PubAuth record);

    PubAuth selectByPrimaryKey(Long authId);

    int updateByPrimaryKeySelective(PubAuth record);

}