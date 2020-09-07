package com.smart.bracelet.service.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusCivil;
import com.smart.bracelet.model.po.debt.BusRelativePerson;
import com.smart.bracelet.model.po.debt.DateAndDays;
import com.smart.bracelet.model.vo.debt.*;

import java.security.cert.CertStoreException;
import java.util.List;

public interface BusCivilService {
    int deleteByPrimaryKey(Long civilId) throws CustomerException;

    Long insertSelective(BusCivil record) throws CustomerException;

    BusCivil selectByPrimaryKey(Long civilId);

    int updateByPrimaryKeySelective(BusCivilVo record) throws CustomerException;

    /**
     * 按照日期查询每日报备数量
     * @return
     */
    List<DateAndDays> selectDaysCount();

    /**
     * 查询所有民事调解信息
     * @return
     */
    List<BusCivil> queryList();

    /**
     * 更新审核状态
     * @param status
     * @param civilId
     * @return
     */
    int updateStatus(String status,Long civilId,String checkReason) throws CustomerException;

    /**
     * 页面展示民事调解信息
     */
    List<BusCivilInfo> selectBusList(DebtInfoQuery debtInfoQuery);

    /**
     * 民事调解信息填写页面更新信息
     */
    List<CiviIAndRepShow> selectCiviIAndRepShow();

    /**
     * 民事调解身份验证
     * @param relativePerId
     * @return
     * @throws CustomerException
     */
    Boolean  verification(Long relativePerId) throws CustomerException;

    /**
     * 尽调协议初始化
     */
    AgreementInfoShow initialize(Long reportId);
    /**
     * 策划方案服务协议初始化
     */
    PlanServiceInfo initializePlan(Long reportId) throws CustomerException;

    /**
     * 通过报备ID查询民事调解协议
     * @param reportId
     * @return
     */
    List<BusCivil> selectByReportId(Long reportId);

}
