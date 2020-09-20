package com.smart.bracelet.dao.debt;

import com.smart.bracelet.model.po.debt.AssService;
import com.smart.bracelet.model.po.debt.DateAndDays;
import com.smart.bracelet.model.po.debt.PubDebt;
import com.smart.bracelet.model.vo.debt.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PubDebtDao {

    int deleteByPrimaryKey(Long debtId);

    int insertSelective(PubDebt record);

    PubDebt selectByPrimaryKey(Long debtId);

    int updateByPrimaryKeySelective(PubDebtVo record);

    /**
     * 获取最后一条编号
     */
    String selectNo();
    /**
     * 查询每日解债信息
     *
     * @return
     */
    List<DateAndDays> selectDaysCount(String type);

    /**
     * 通过相对人ID查询解债信息
     * @param debtId
     * @return
     */
    PubDebt selectByRelativePerId(Long relativePerId);


    /**
     * 查询所有借债信息
     *
     * @return
     */
    List<PubDebt> queryList();


    /**
     * 更新审核状态
     *
     * @param status
     * @param debtId
     * @return
     */
    int updateStatus(String status, Long debtId,String checkReason);

    /**
     * 查询最后一个解债编号
     *
     * @return
     */
    String selectRepNo();

    /**
     * 页面解债信息展示
     */
    List<PubDebtInfo> selectDebtListShow(QueryDebtVo queryDebtVo);

    /**
     * 解债页面展示
     */
    List<PubDebtInfo> selectByReportIds(Long relativePerId);

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
     * 新增咨询服务协议
     */
    int updateService(AssService assService);

    /**
     * 查询策划方案协议
     * @param debtId
     * @return
     */
    AssService selectAssService(Long debtId);


}