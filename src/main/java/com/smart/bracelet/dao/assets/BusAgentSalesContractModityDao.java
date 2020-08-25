package com.smart.bracelet.dao.assets;

import com.smart.bracelet.model.po.assets.BusAgentSalesContractModity;
import com.smart.bracelet.model.vo.assets.BusAgentSalesContractModityVo;
import org.springframework.stereotype.Repository;

@Repository
public interface BusAgentSalesContractModityDao {

    int deleteByPrimaryKey(Long salesContractModityId);

    int insertSelective(BusAgentSalesContractModity record);

    BusAgentSalesContractModity selectByPrimaryKey(Long salesContractModityId);

    int updateByPrimaryKeySelective(BusAgentSalesContractModityVo record);

}