package com.smart.bracelet.dao.debt;

import com.smart.bracelet.model.po.debt.BusPledgeContract;
import com.smart.bracelet.model.vo.debt.BusPledgeContractVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusPledgeContractDao {
    int deleteByPrimaryKey(Long pledgeContractId);

    int insertSelective(BusPledgeContract record);

    BusPledgeContract selectByPrimaryKey(Long pledgeContractId);

    int updateByPrimaryKeySelective(BusPledgeContractVo record);

    List<BusPledgeContract> queryList();

}