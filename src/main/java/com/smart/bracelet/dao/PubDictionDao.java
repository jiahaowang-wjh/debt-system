package com.smart.bracelet.dao;

import com.smart.bracelet.model.po.PubDiction;
import org.springframework.stereotype.Repository;

@Repository
public interface PubDictionDao {
    int deleteByPrimaryKey(Long dictionId);

    int insert(PubDiction record);

    int insertSelective(PubDiction record);

    PubDiction selectByPrimaryKey(Long dictionId);

    int updateByPrimaryKeySelective(PubDiction record);

    int updateByPrimaryKey(PubDiction record);
}