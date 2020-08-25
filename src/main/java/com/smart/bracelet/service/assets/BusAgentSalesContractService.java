package com.smart.bracelet.service.assets;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusAgentSalesContract;
import com.smart.bracelet.model.vo.assets.BusAgentSalesContractVo;

public interface BusAgentSalesContractService {

    int deleteByPrimaryKey(Long salesContractId) throws CustomerException;

    int insertSelective(BusAgentSalesContract record) throws CustomerException;

    BusAgentSalesContract selectByPrimaryKey(Long salesContractId);

    int updateByPrimaryKeySelective(BusAgentSalesContractVo record) throws CustomerException;
}
