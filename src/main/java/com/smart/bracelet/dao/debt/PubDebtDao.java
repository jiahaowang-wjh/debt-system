package com.smart.bracelet.dao.debt;

import com.smart.bracelet.model.po.debt.PubDebt;
import org.springframework.stereotype.Repository;

@Repository
public interface PubDebtDao {
    int deleteByPrimaryKey(Long debtId);

    int insert(PubDebt record);

    int insertSelective(PubDebt record);

    PubDebt selectByPrimaryKey(Long debtId);

    int updateByPrimaryKeySelective(PubDebt record);

    int updateByPrimaryKey(PubDebt record);
}