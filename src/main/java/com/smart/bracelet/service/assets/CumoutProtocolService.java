package com.smart.bracelet.service.assets;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusAgentSalesContractModity;
import com.smart.bracelet.model.po.assets.CumoutProtocol;
import com.smart.bracelet.model.vo.assets.CommissionOnLine;

import java.text.ParseException;

public interface CumoutProtocolService {

    int deleteByPrimaryKey(Long protocolId);

    Long insertSelective(CumoutProtocol record) throws CustomerException;

    CumoutProtocol selectByPrimaryKey(Long protocolId);

    int updateByPrimaryKeySelective(CumoutProtocol record);
    /**
     * 初始化线上委托销售哦合同
     * @param propertId
     * @return
     */
    CommissionOnLine initialize(Long propertId,Long comId) throws ParseException, CustomerException;

}
