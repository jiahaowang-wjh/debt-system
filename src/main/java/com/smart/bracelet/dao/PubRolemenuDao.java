package com.smart.bracelet.dao;

import com.smart.bracelet.model.po.PubRolemenu;
import org.springframework.stereotype.Repository;

@Repository
public interface PubRolemenuDao {
    int deleteByPrimaryKey(Long rolemenuId);

    int insert(PubRolemenu record);

    int insertSelective(PubRolemenu record);

    PubRolemenu selectByPrimaryKey(Long rolemenuId);

    int updateByPrimaryKeySelective(PubRolemenu record);

    int updateByPrimaryKey(PubRolemenu record);
}