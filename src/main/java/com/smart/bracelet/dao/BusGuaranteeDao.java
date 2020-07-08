package com.smart.bracelet.dao;

import com.smart.bracelet.model.po.BusGuarantee;
import org.springframework.stereotype.Repository;

@Repository
public interface BusGuaranteeDao {
    int deleteByPrimaryKey(Long guaranteeId);

    int insert(BusGuarantee record);

    int insertSelective(BusGuarantee record);

    BusGuarantee selectByPrimaryKey(Long guaranteeId);

    int updateByPrimaryKeySelective(BusGuarantee record);

    int updateByPrimaryKey(BusGuarantee record);
}