package com.smart.bracelet.service.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.DateAndDays;
import com.smart.bracelet.model.po.debt.PubDebt;
import com.smart.bracelet.model.vo.debt.*;

import java.util.List;

public interface PubDebtService {

    int deleteByPrimaryKey(Long debtId) throws CustomerException;

    Long insertSelective(PubDebt record) throws CustomerException;

    PubDebt selectByPrimaryKey(Long debtId);

    int updateByPrimaryKeySelective(PubDebtVo record) throws CustomerException;

    /**
     * 按照日期查询每日解债数量
     * @return
     */
    List<DateAndDays> selectDaysCount(String type);
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
    int updateStatus(String status,Long debtId,String checkReason) throws CustomerException;


    /**
     * 页面解债信息展示
     */
    List<PubDebtInfo> selectDebtListShow(QueryDebtVo queryDebtVo);


    /**
     * 解债信息填写更新展示
     */
    List<DebtAndRepAndCiviI> selectDebtAndRepAndCiviI();

    /**
     * 通过报备Id查询解债信息
     */
    List<PubDebt> selectByreportId(Long reportId);

    /**
     *查询金额
     * @param relativePerId
     * @return
     */
    DebtMoney selectMoney(Long relativePerId);

    /**
     * 解债页面展示
     */
    List<PubDebtInfo> selectByReportIds(Long reportId);
}
