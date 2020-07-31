package com.smart.bracelet.service.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusPledgeProperty;
import com.smart.bracelet.model.vo.debt.BusPledgePropertyVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusPledgePropertyService {
    int deleteByPrimaryKey(Long pledgePropertyId) throws CustomerException;

    int insertSelective(BusPledgeProperty record) throws CustomerException;

    BusPledgeProperty selectByPrimaryKey(Long pledgePropertyId);

    int updateByPrimaryKeySelective(BusPledgePropertyVo record) throws CustomerException;

    List<BusPledgeProperty> queryList();

}