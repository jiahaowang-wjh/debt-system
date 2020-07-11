package com.smart.bracelet.service.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.PubDebt;
import com.smart.bracelet.model.vo.debt.PubDebtVo;

public interface PubDebtService {

    int deleteByPrimaryKey(Long debtId) throws CustomerException;

    int insertSelective(PubDebt record) throws CustomerException;

    PubDebt selectByPrimaryKey(Long debtId);

    int updateByPrimaryKeySelective(PubDebtVo record) throws CustomerException;

}
