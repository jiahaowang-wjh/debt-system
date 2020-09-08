package com.smart.bracelet.dao.debt;

import com.smart.bracelet.model.po.debt.BusGuarantee;
import com.smart.bracelet.model.vo.debt.BusGuaranteeVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusGuaranteeDao {
    int deleteByPrimaryKey(Long guaranteeId);

    int insertSelective(BusGuarantee record);

    BusGuarantee selectByPrimaryKey(Long guaranteeId);

    int updateByPrimaryKeySelective(BusGuaranteeVo record);

    /**
     * 批量新增
     * @param list
     * @return
     */
    int insertList(List<BusGuarantee> list);

}