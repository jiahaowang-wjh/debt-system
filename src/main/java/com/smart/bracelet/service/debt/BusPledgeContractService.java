package com.smart.bracelet.service.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusPledgeContract;
import com.smart.bracelet.model.vo.debt.BusPledgeContractVo;

import java.util.List;

public interface BusPledgeContractService {

    int deleteByPrimaryKey(Long pledgeContractId) throws CustomerException;

    int insertSelective(BusPledgeContract record) throws CustomerException;

    BusPledgeContract selectByPrimaryKey(Long pledgeContractId);

    int updateByPrimaryKeySelective(BusPledgeContractVo record) throws CustomerException;

    List<BusPledgeContract> queryList();
}
