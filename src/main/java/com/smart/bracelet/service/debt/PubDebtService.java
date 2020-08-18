package com.smart.bracelet.service.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.DateAndDays;
import com.smart.bracelet.model.po.debt.PubDebt;
import com.smart.bracelet.model.vo.debt.DebtAndRepAndCiviI;
import com.smart.bracelet.model.vo.debt.PubDebtInfo;
import com.smart.bracelet.model.vo.debt.PubDebtVo;

import java.util.List;

public interface PubDebtService {

    int deleteByPrimaryKey(Long debtId) throws CustomerException;

    int insertSelective(PubDebt record) throws CustomerException;

    PubDebt selectByPrimaryKey(Long debtId);

    int updateByPrimaryKeySelective(PubDebtVo record) throws CustomerException;

    /**
     * 按照日期查询每日解债数量
     * @return
     */
    List<DateAndDays> selectDaysCount();
    /**
     * 查询所有借债信息
     * @return
     */
    List<PubDebt> queryList();


    /**
     * 更新审核状态
     * @param status
     * @param debtId
     * @return
     */
    int updateStatus(String status,Long debtId) throws CustomerException;


    /**
     * 页面解债信息展示
     */
    List<PubDebtInfo> selectDebtListShow(String debtNo,Long debtId);


    /**
     * 解债信息填写更新展示
     */
    List<DebtAndRepAndCiviI> selectDebtAndRepAndCiviI();
}
