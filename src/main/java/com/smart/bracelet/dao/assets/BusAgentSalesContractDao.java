package com.smart.bracelet.dao.assets;

import com.smart.bracelet.model.po.assets.BusAgentSalesContract;
import com.smart.bracelet.model.vo.assets.BusAgentSalesContractVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusAgentSalesContractDao {
    int deleteByPrimaryKey(Long salesContractId);

    int insertSelective(BusAgentSalesContract record);

    BusAgentSalesContract selectByPrimaryKey(Long salesContractId);

    int updateByPrimaryKeySelective(BusAgentSalesContractVo record);

    List<BusAgentSalesContract> queryList();

}