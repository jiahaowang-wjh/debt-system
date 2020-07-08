package com.smart.bracelet.dao;

import com.smart.bracelet.model.po.PubArea;
import org.springframework.stereotype.Repository;

@Repository
public interface PubAreaDao {
    int deleteByPrimaryKey(Long areaId);

    int insert(PubArea record);

    int insertSelective(PubArea record);

    PubArea selectByPrimaryKey(Long areaId);

    int updateByPrimaryKeySelective(PubArea record);

    int updateByPrimaryKey(PubArea record);
}