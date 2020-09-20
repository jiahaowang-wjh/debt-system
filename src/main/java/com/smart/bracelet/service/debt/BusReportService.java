package com.smart.bracelet.service.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusRelativePerson;
import com.smart.bracelet.model.po.debt.BusReport;
import com.smart.bracelet.model.po.debt.DateAndDays;
import com.smart.bracelet.model.vo.debt.*;
import com.smart.bracelet.utils.RepNoUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.List;

public interface BusReportService {

    int deleteByPrimaryKey(Long reportId) throws CustomerException;

    BusReportListVo selectByPrimaryKey(Long reportId) throws CustomerException;


    List<BusReportListVo> queryBusReport() throws CustomerException;

    /**
     * 按照日期查询每日报备数量
     * @return
     */
    List<DateAndDays> selectDaysCount(String type);

    /**
     * 新增私人报备信息
     * @param busPrivateReport
     * @return
     */
    Long insertPrivateSelective(BusPrivateReport busPrivateReport) throws CustomerException;

    /**
     * 更新私人报备信息
     * @param busPrivateReport
     * @return
     */
    int updatePrivateSelective(BusPrivateReportVo busPrivateReport) throws CustomerException;

    /**
     * 新增企业报备信息
     * @param busEterpriseReport
     * @return
     */
    Long insertEterpriseSelective(BusEterpriseReport busEterpriseReport) throws CustomerException;

    /**
     * 更新企业报备信息
     * @param busEterpriseReport
     * @return
     */
    int updateEterpriseSelective(BusEterpriseReportVo busEterpriseReport) throws CustomerException;

    /**
     * 新增银行报备信息
     * @param busBankReport
     * @return
     */
    Long insertBankSelective(BusBankReport busBankReport) throws CustomerException;

    /**
     * 更新银行报备信息
     * @param busBankReport
     * @return
     */
    int updateBankSelective(BusBankReportVo busBankReport) throws CustomerException;


    /**
     *查询债事人债事链
     * @return
     */
   DebtChain queryListChain(String personIdCad);


    /**
     * 更新审核状态
     * @param status
     * @param reportId
     * @return
     */
    int updateStatus(String status,Long reportId,String checkReason) throws CustomerException;

    /**
     * 页面报备信息展示
     */
    List<DebtInfo> selectDebtInfos(DebtInfoQuery debtInfoQuery);



    /**
     * 更新报备调解阶段
     * @return
     */
    int updateDebtStage(String stage,Long repId) throws CustomerException;


    /**
     * 提交暨尽调协议生成编号
     */
    int addAgreementNo(String partyA, String partyB, Long reportId, Long comId, Date agreementDate) throws CustomerException;

    /**
     * 暨尽协议下载
     * @param reportId
     * @return
     */
    CumOutInfo selectJiJin(Long reportId);


}
