package com.smart.bracelet.dao.assets;

import com.smart.bracelet.model.po.assets.BusAgentSalesContractModity;
import com.smart.bracelet.model.vo.assets.BusAgentSalesContractModityVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusAgentSalesContractModityDao {

    int deleteByPrimaryKey(Long salesContractModityId);


    int deleteByContractId(Long salesContractId);

    int insertSelectives(List<BusAgentSalesContractModity> record);

    BusAgentSalesContractModity selectByPrimaryKey(Long salesContractModityId);

    int updateByPrimaryKeySelective(BusAgentSalesContractModityVo record);

    /**
     * 通过资产委托代理销售合同id查询
     * @param salesContractId
     * @return
     */
    List<BusAgentSalesContractModity> selectBySalesContractId(Long salesContractId);

    /**
     * 通过资产委线上托代理销售合同id查询
     * @param protocolId
     * @return
     */
    List<BusAgentSalesContractModity> selectBySalesProtocolId(Long protocolId);

    /**
     * 获取最后一位编号
     * @return
     */
    String selectNo();

    /**
     * 查询商品内容
     * @return
     */
    List<String> queryComm();

}