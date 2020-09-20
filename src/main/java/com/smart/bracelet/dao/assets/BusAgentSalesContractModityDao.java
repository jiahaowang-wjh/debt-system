package com.smart.bracelet.dao.assets;

import com.smart.bracelet.model.po.assets.BusAgentSalesContractModity;
import com.smart.bracelet.model.vo.assets.BusAgentSalesContractModityVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusAgentSalesContractModityDao {

    int deleteByPrimaryKey(Long salesContractModityId);

    int insertSelectives(List<BusAgentSalesContractModity> record);

    BusAgentSalesContractModity selectByPrimaryKey(Long salesContractModityId);

    int updateByPrimaryKeySelective(BusAgentSalesContractModityVo record);

    /**
     * 通过资产委托代理销售合同id查询
     * @param salesContractId
     * @return
     */
    BusAgentSalesContractModity selectBySalesContractId(Long salesContractId);

    String selectNo();
}