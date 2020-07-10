package com.smart.bracelet.dao.user;

import com.smart.bracelet.model.po.user.BusRealAuth;
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