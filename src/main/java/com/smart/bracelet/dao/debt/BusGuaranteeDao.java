package com.smart.bracelet.dao.debt;

import com.smart.bracelet.model.po.debt.BusGuarantee;
import com.smart.bracelet.model.vo.debt.BusGuaranteeVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusGuaranteeDao {
    int deleteByPrimaryKey(Long guaranteeId);

    int insertSelective(BusGuarantee record);

    List<BusGuarantee> selectByPrimaryKey(Long civilId);

    BusGuarantee[] selectByPrimaryKey1(Long civilId);

    int updateByPrimaryKeySelective(BusGuaranteeVo record);

    int deleteByCiviId(Long civilId);

    /**
     * 批量新增
     * @param list
     * @return
     */
    int insertList(BusGuarantee[] list);

}