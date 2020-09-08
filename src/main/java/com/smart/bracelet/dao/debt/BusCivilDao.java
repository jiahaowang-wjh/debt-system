package com.smart.bracelet.dao.debt;

import com.smart.bracelet.model.po.debt.BusCivil;
import com.smart.bracelet.model.po.debt.BusGuarantee;
import com.smart.bracelet.model.po.debt.BusMediatePerson;
import com.smart.bracelet.model.po.debt.DateAndDays;
import com.smart.bracelet.model.vo.debt.*;
import org.omg.PortableInterceptor.LOCATION_FORWARD;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusCivilDao {
    int deleteByPrimaryKey(Long civilId);

    int insertSelective(BusCivil record);

    BusCivil selectByPrimaryKey(Long civilId);

    int updateByPrimaryKeySelective(BusCivilVo record);

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
    int updateStatus(String status,Long civilId,String checkReason);

    /**
     * 查询最后一条数据编号
     * @return
     */
    String selectRepNo();

    /**
     * 页面展示民事调解信息
     */
    List<BusCivilInfo> selectBusList(DebtInfoQuery debtInfoQuery);

    /**
     * 民事调解信息填写页面更新信息
     */
    List<CiviIAndRepShow> selectCiviIAndRepShow();


    /**
     * 通过相对人ID查询债事人相对人身份信息
     */
    DebtAndPerson selectDebtAndPer(Long relativePerId);

    /**
     * 通过身份信息获取相对人作为债事人的报备ID
     * @return
     */
    Long selectReportId(String personIdcard);

    /**
     * 通过相对人作为债事人的报备ID查询相对人
     */
    List<String> selectPersonIdCardByPrId(Long reportId);

    /**
     * 尽调协议初始化
     */
    AgreementInfoShow initialize(Long reportId);

    /**
     * 策划方案服务协议初始化
     */
    PlanServiceInfo initializePlan(Long reportId);

    /**
     * 通过报备ID查询民事调解协议
     * @param reportId
     * @return
     */
    List<BusCivil> selectByReportId(Long reportId);

    /**
     * 批量新增调解参与人信息表
     */
    int inertList(List<BusMediatePerson> busMediatePerson);
}