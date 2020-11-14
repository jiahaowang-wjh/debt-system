package com.smart.bracelet.dao.debt;

import com.smart.bracelet.model.po.debt.BusPayDetail;
import com.smart.bracelet.model.vo.debt.BusPayDetailInfo;
import com.smart.bracelet.model.vo.debt.BusPayDetailVo;
import com.smart.bracelet.model.vo.debt.ReportFee;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Repository
public interface BusPayDetailDao {
    int deleteByPrimaryKey(Long payId);

    int insertSelective(BusPayDetail record);

    BusPayDetail selectByPrimaryKey(Long payId);

    int updateByPrimaryKeySelective(BusPayDetailVo record);

    /**
     * 通过报备Id查询支付信息
     * @param reportId
     * @return
     */
    List<BusPayDetail> selectByReportId(Long reportId);

    /**
     *更新状态
     * @param status
     * @param payId
     * @return
     */
    int updateStatus(String status,Long payId,String checkReason);

    /**
     * 查询最后一条编号
     * @return
     */
    String selectRepNo();

    /**
     * 页面支付信息展示天泽
     * @return reportNo
     */
    List<BusPayDetailInfo> selectPayInfoList(String reportNo,String companyType,String status);

    /**
     * 页面支付信息展示资产
     * @return reportNo
     */
    List<BusPayDetailInfo> selectPayInfoListZc(String reportNo,String companyType,String status);
    /**
     *通过报备Id和解债id查询支付信息
     * @param reportId
     * @return
     */
    List<BusPayDetail> selectByReportIdAndDebtId(Long reportId,Long debtId);

    /**
     *通过报备Id和资产id查询支付信息
     * @param propertId
     * @return
     */
    BusPayDetail selectByReportIdAndPropertId(Long propertId);

    /**
     * 发票生成信息
     * @param reportId
     * @return
     */
    ReportFee selectByRepId(Long reportId,String flag,Long debtId,Long propertId);

    /**
     * 更新发票生成日期
     * @param generateTime
     * @return
     */
    int updateGenerateTime(Date generateTime,Long payId);
}