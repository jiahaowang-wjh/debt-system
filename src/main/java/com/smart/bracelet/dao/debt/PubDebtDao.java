package com.smart.bracelet.dao.debt;

import com.smart.bracelet.model.po.debt.DateAndDays;
import com.smart.bracelet.model.po.debt.PubDebt;
import com.smart.bracelet.model.vo.debt.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PubDebtDao {

    int deleteByPrimaryKey(Long debtId);

    int insertSelective(PubDebt record);

    PubDebt selectByPrimaryKey(Long debtId);

    int updateByPrimaryKeySelective(PubDebtVo record);

    String selectNo();

    List<DateAndDays> selectDaysCount(String type,Long comId);

    List<PubDebtInfo> selectDebtListShow(DebtInfoQuery queryDebtVo);

    /**
     * 状态更新
     * @return
     */
    int updateStatus(String status, Long debtId, String checkReason);

    /**
     * 通过相对人ID查询解债信息
     * @param relativePerId
     * @return
     */
    PubDebt selectByRelativePerId(Long relativePerId);

    /**
     * 解债页面展示
     */
    List<PubDebtInfo> selectByReportIds(Long reportId);


    /**
     * 通过报备Id查询解债信息
     */
    List<PubDebt> selectByreportId(Long reportId);


    /**
     * 策划方案服务协议初始化
     */
    PlanServiceInfo initializePlan(Long debtId);

    /**
     * 策划方案新增
     * @param matters
     * @param serviceNo
     * @param servicePrincipal
     * @param serviceInterest
     * @param contractDate
     * @return
     */
    int updatePlanInfo(String matters, String serviceNo, Float servicePrincipal, Float serviceInterest, Date contractDate,Long debtId);


    /**
     * 查询策划方案服务协议最后一条编号
     * @return
     */
    String selectServiiceNo();


    /**
     * 获取累计解债金额
     */
    PubDebt selectAmountCumulative(Long relativePerId);

    /**
     * 查询累计解债信息
     * @param reportId
     * @return
     */
    PubDebt selectMoney(Long reportId);

    /**
     * 查询累计解债金额
     */
    String queryMoneyNum(Long repId);
}