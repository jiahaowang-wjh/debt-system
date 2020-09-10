package com.smart.bracelet.service.assets;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusAgentSalesContractModity;
import com.smart.bracelet.model.vo.assets.BusAgentSalesContractModityVo;

public interface BusAgentSalesContractModityService {


    int deleteByPrimaryKey(Long salesContractModityId) throws CustomerException;

    Long insertSelective(BusAgentSalesContractModity record) throws CustomerException;

    BusAgentSalesContractModity selectByPrimaryKey(Long salesContractModityId);

    int updateByPrimaryKeySelective(BusAgentSalesContractModityVo record) throws CustomerException;

}
