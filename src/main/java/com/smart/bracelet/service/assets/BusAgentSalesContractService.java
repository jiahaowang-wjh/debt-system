package com.smart.bracelet.service.assets;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusAgentSalesContract;
import com.smart.bracelet.model.vo.assets.BusAgentSalesContractShow;
import com.smart.bracelet.model.vo.assets.BusAgentSalesContractVo;

public interface BusAgentSalesContractService {

    int deleteByPrimaryKey(Long salesContractId) throws CustomerException;

    Long insertSelective(BusAgentSalesContract record) throws CustomerException;

    BusAgentSalesContract selectByPrimaryKey(Long salesContractId);

    int updateByPrimaryKeySelective(BusAgentSalesContractVo record) throws CustomerException;

    /**
     * 委托代理销售合同初始化
     * @param relativePerId
     * @return
     */
    BusAgentSalesContractShow initialize(Long relativePerId) throws CustomerException;

    /**
     * 通过资产Id查询 委托代理销售合同
     *
     * @param propertId
     * @return
     */
    BusAgentSalesContract selectByPropertId(Long propertId);
}
