package com.smart.bracelet.dao.assets;

import com.smart.bracelet.model.po.debt.BusPropert;
import com.smart.bracelet.model.vo.assets.AssetsDebtBank;
import com.smart.bracelet.model.vo.debt.BusPropertVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusPropertDao {
    int deleteByPrimaryKey(Long propertId);

    int insertSelective(BusPropert record);

    BusPropert selectByPrimaryKey(Long propertId);

    int updateByPrimaryKeySelective(BusPropertVo record);

    List<BusPropert> queryList();

    /**
     * 更新资产状态
     * @param status
     * @param propertId
     * @return
     */
    int updateStatus(String status,String checkReason,Long propertId);

    /**
     * 资产系统，我的债行
     * @return
     */
    List<AssetsDebtBank> querys();

}