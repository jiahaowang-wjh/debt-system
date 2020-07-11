package com.smart.bracelet.dao.debt;

import com.smart.bracelet.model.po.debt.BusRealAuth;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRealAuthDao {
    int deleteByPrimaryKey(Long realId);

    int insert(BusRealAuth record);

    int insertSelective(BusRealAuth record);

    BusRealAuth selectByPrimaryKey(Long realId);

    int updateByPrimaryKeySelective(BusRealAuth record);

    int updateByPrimaryKey(BusRealAuth record);
}