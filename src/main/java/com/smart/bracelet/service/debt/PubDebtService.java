package com.smart.bracelet.service.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.AssService;
import com.smart.bracelet.model.po.debt.DateAndDays;
import com.smart.bracelet.model.po.debt.PubDebt;
import com.smart.bracelet.model.vo.debt.*;

import java.util.Date;
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
    List<DateAndDays> selectDaysCount(String type,Long comId);


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
     * 解债页面列表（关系绑定）
     */
    List<PubDebtInfo> selectByReportIds(Long reportId);


    /**
     * 通过报备Id查询解债信息
     */
    List<PubDebt> selectByreportId(Long reportId);

    /**
     * 策划方案服务协议初始化
     */
    PlanServiceInfo initializePlan(Long reportId,Long comId) throws CustomerException;


    /**
     * 策划方案新增
     * @param matters
     * @param serviceNo
     * @param servicePrincipal
     * @param serviceInterest
     * @param contractDate
     * @return
     */
    int updatePlanInfo(String matters, String serviceNo, Float servicePrincipal, Float serviceInterest, Date contractDate, Long debtId) throws CustomerException;
}
