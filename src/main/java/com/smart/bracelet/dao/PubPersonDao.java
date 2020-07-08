package com.smart.bracelet.dao;

import com.smart.bracelet.model.po.PubPerson;
import org.springframework.stereotype.Repository;

@Repository
public interface PubPersonDao {
    int deleteByPrimaryKey(Long personId);

    int insert(PubPerson record);

    int insertSelective(PubPerson record);

    PubPerson selectByPrimaryKey(Long personId);

    int updateByPrimaryKeySelective(PubPerson record);

    int updateByPrimaryKey(PubPerson record);
}