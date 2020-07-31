package com.smart.bracelet.dao.debt;

import com.smart.bracelet.model.po.debt.BusPledgeProperty;
import com.smart.bracelet.model.vo.debt.BusPledgePropertyVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusPledgePropertyDao {
    int deleteByPrimaryKey(Long pledgePropertyId);

    int insertSelective(BusPledgeProperty record);

    BusPledgeProperty selectByPrimaryKey(Long pledgePropertyId);

    int updateByPrimaryKeySelective(BusPledgePropertyVo record);

    List<BusPledgeProperty> queryList();

}