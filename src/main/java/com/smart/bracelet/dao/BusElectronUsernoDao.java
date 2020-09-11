package com.smart.bracelet.dao;

import com.smart.bracelet.model.BusElectronUserno;
import org.springframework.stereotype.Repository;

@Repository
public interface BusElectronUsernoDao {
    int deleteByPrimaryKey(Integer userno);

    int insert(BusElectronUserno record);

    int insertSelective(BusElectronUserno record);
}