package com.smart.bracelet.dao.debt;

import com.smart.bracelet.model.po.debt.*;
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

    List<DateAndDays> selectDaysCount(String type,Long comId);

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
     * 通过身份信息获取相对人作为债事人的报备ID企业
     * @return
     */
    List<Long> selectReportIdCor(String phone);


    /**
     * 通过身份信息获取相对人作为债事人的报备ID私人
     * @return
     */
    List<Long> selectReportIdPri(String phone);


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
    List<CivilShow> selectByReportId(Long reportId);

    /**
     * 批量新增调解参与人信息表
     */
    int inertList(List<BusMediatePerson> busMediatePerson);

    /**
     * 民事调解书
     */
    List<CivilAndPseronInfo> selectCivi(Long reportId);


    /**
     * 获取调解员
     * @param civId
     * @return
     */
     CiviliVo[] selectUser(Long civId);

    /**
     * 删除调解员
     * @param civilId
     * @return
     */
    int delUser(Long civilId);

}