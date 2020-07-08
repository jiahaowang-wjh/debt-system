package com.smart.bracelet.dao;

import com.smart.bracelet.model.po.PubExp;
import org.springframework.stereotype.Repository;

@Repository
public interface PubExpDao {
    int deleteByPrimaryKey(Long expId);

    int insert(PubExp record);

    int insertSelective(PubExp record);

    PubExp selectByPrimaryKey(Long expId);

    int updateByPrimaryKeySelective(PubExp record);

    int updateByPrimaryKey(PubExp record);
}