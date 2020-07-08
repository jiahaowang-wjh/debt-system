package com.smart.bracelet.dao;

import com.smart.bracelet.model.po.PubDoc;
import org.springframework.stereotype.Repository;

@Repository
public interface PubDocDao {
    int deleteByPrimaryKey(Long docId);

    int insert(PubDoc record);

    int insertSelective(PubDoc record);

    PubDoc selectByPrimaryKey(Long docId);

    int updateByPrimaryKeySelective(PubDoc record);

    int updateByPrimaryKey(PubDoc record);
}