package com.smart.bracelet.dao;

import com.smart.bracelet.model.po.PubMenu;
import org.springframework.stereotype.Repository;

@Repository
public interface PubMenuDao {
    int deleteByPrimaryKey(Long menuId);

    int insert(PubMenu record);

    int insertSelective(PubMenu record);

    PubMenu selectByPrimaryKey(Long menuId);

    int updateByPrimaryKeySelective(PubMenu record);

    int updateByPrimaryKey(PubMenu record);
}