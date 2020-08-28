package com.smart.bracelet.dao.assets;

import com.smart.bracelet.model.po.assets.BusAgentSalesContract;
import com.smart.bracelet.model.vo.assets.BusAgentSalesContractShow;
import com.smart.bracelet.model.vo.assets.BusAgentSalesContractVo;
import org.springframework.stereotype.Repository;

@Repository
public interface BusAgentSalesContractDao {

    int deleteByPrimaryKey(Long salesContractId);

    int insertSelective(BusAgentSalesContract record);

    BusAgentSalesContract selectByPrimaryKey(Long salesContractId);

    int updateByPrimaryKeySelective(BusAgentSalesContractVo record);

    String selectNo();

    /**
     * 委托代理销售合同初始化
     * @param reportId
     * @return
     */
    BusAgentSalesContractShow initialize(Long reportId);
}