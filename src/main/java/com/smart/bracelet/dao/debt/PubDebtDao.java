package com.smart.bracelet.dao.debt;

import com.smart.bracelet.model.po.debt.PubDebt;
import com.smart.bracelet.model.vo.debt.PubDebtVo;
import org.springframework.stereotype.Repository;

@Repository
public interface PubDebtDao {

    int deleteByPrimaryKey(Long debtId);

    int insertSelective(PubDebt record);

    PubDebt selectByPrimaryKey(Long debtId);

    int updateByPrimaryKeySelective(PubDebtVo record);

}