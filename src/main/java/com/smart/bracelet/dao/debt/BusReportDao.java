package com.smart.bracelet.dao.debt;

import com.smart.bracelet.model.po.debt.BusRelativePerson;
import com.smart.bracelet.model.po.debt.BusReport;
import com.smart.bracelet.model.po.debt.DateAndDays;
import com.smart.bracelet.model.vo.debt.*;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface BusReportDao {

    int deleteByPrimaryKey(Long reportId);

    int insertSelective(BusReport record);

    BusReport selectByPrimaryKey(Long reportId);

    int updateByPrimaryKeySelective(BusReportVo record);

    List<BusReport> queryBusReport();

    /**
     * 按照日期查询每日报备数量
     * @return
     */
    List<DateAndDays> selectDaysCount();

    /**
     *查询债事人债事链
     * @return
     */
    DebtChain queryLisyChain(String personIdCad);

    /**
     *查询债事人
     * @return
     */
    DebtChain queryLisyDebtor(String personIdCad);

    /**
     *查询相对人
     * @return
     */
    List<DebtChain> queryLisyRelativePerson(BigInteger personId);

    /**
     * 更新审核状态
     * @param status
     * @param reportId
     * @return
     */
    int updateStatus(String status,Long reportId,String checkReason);

    /**
     * 获取数据库中最后一条记录的编号
     * @return
     */
    String selectRepNo();

    /**
     * 页面报备信息展示
     */
    List<DebtInfo> selectDebtInofs(DebtInfoQuery debtInfoQuery);

    /**
     * 更新报备调解阶段
     * @return
     */
    int updateDebtStage(String stage,Long reportId);

    /**
     * 查询最后一条暨尽编号
     */
    List<String> selectANO();

    /**
     * 新增暨尽编号
     */
    int addANO(String partyA, String partyB,String agreementNo,Long reportId);

    /**
     * 暨尽协议下载
     * @param reportId
     * @return
     */
    CumOutInfo selectJiJin(Long reportId);


}