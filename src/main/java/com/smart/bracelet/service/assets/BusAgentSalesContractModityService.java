package com.smart.bracelet.service.assets;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusAgentSalesContractModity;
import com.smart.bracelet.model.vo.assets.BusAgentSalesContractModityVo;
import com.smart.bracelet.model.vo.assets.CommModiey;

import java.util.List;

public interface BusAgentSalesContractModityService {


    int deleteByPrimaryKey(Long salesContractModityId) throws CustomerException;

    Long insertSelective(BusAgentSalesContractModity record) throws CustomerException;

    BusAgentSalesContractModity selectByPrimaryKey(Long salesContractModityId);

    int updateByPrimaryKeySelective(BusAgentSalesContractModityVo record) throws CustomerException;
    /**
     * 通过资产委托代理销售合同id查询
     * @param salesContractId
     * @return
     */
    List<BusAgentSalesContractModity> selectBySalesContractId(Long salesContractId);

    /**
     * 查询商品内容
     * @return
     */
    List<CommModiey> queryComm();
}
