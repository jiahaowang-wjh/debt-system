package com.smart.bracelet.dao.assets;

import com.smart.bracelet.model.po.assets.CumoutProtocol;
import com.smart.bracelet.model.vo.assets.CommissionOnLine;
import com.smart.bracelet.model.vo.assets.CumoutProtocolVo;
import org.springframework.stereotype.Repository;

@Repository
public interface CumoutProtocolDao {
    int deleteByPrimaryKey(Long protocolId);

    int insert(CumoutProtocol record);

    int insertSelective(CumoutProtocol record);

    CumoutProtocol selectByPrimaryKey(Long protocolId);

    int updateByPrimaryKeySelective(CumoutProtocolVo record);

    int updateByPrimaryKey(CumoutProtocol record);

    /**
     * 初始化线上委托销售哦合同
     * @param propertId
     * @return
     */
    CommissionOnLine initialize(Long propertId);

    /**
     * 查询最后一条编号
     * @return
     */
    String selectNo();
}