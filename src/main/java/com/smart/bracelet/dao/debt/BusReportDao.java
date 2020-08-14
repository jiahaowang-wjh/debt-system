package com.smart.bracelet.dao.debt;

import com.smart.bracelet.model.po.debt.BusReport;
import com.smart.bracelet.model.po.debt.DateAndDays;
import com.smart.bracelet.model.vo.debt.BusReportVo;
import com.smart.bracelet.model.vo.debt.DebtChain;
import com.smart.bracelet.model.vo.debt.DebtInfo;
import com.smart.bracelet.model.vo.debt.DebtInfoQuery;
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
    int updateStatus(String status,Long reportId);

    /**
     * 获取数据库中最后一条记录的编号
     * @return
     */
    String selectRepNo();

    /**
     * 页面报备信息展示
     */
    List<DebtInfo> selectDebtInofs(DebtInfoQuery debtInfoQuery);

}