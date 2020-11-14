package com.smart.bracelet.service.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusPayDetail;
import com.smart.bracelet.model.vo.debt.BusPayDetailInfo;
import com.smart.bracelet.model.vo.debt.BusPayDetailVo;
import com.smart.bracelet.model.vo.debt.ReportFee;

import java.text.ParseException;
import java.util.List;

public interface BusPayDetailService {

    int deleteByPrimaryKey(Long payId) throws CustomerException;

    Long insertSelective(BusPayDetail record) throws CustomerException;

    BusPayDetail selectByPrimaryKey(Long payId);

    int updateByPrimaryKeySelective(BusPayDetailVo record) throws CustomerException;
    /**
     * 通过报备Id查询支付信息
     * @param reportId
     * @return
     */
    List<BusPayDetail> selectByReportId(Long reportId);

    /**
     * 页面支付信息展示
     */
    List<BusPayDetailInfo> selectPayInfoList(String debtNo,String companyType,String status);


    /**
     * 页面支付信息展示资产
     * @return reportNo
     */
    List<BusPayDetailInfo> selectPayInfoListZc(String reportNo,String companyType,String status);

    /**
     *更新状态
     * @param status
     * @param payId
     * @return
     */
    int updateStatus(String status,Long payId,String checkReason) throws CustomerException;

    /**
     *通过报备Id和解债id查询支付信息
     * @param reportId
     * @return
     */
    List<BusPayDetail> selectByReportIdAndDebtId(Long reportId,Long debtId);

    /**
     *通过资产id查询支付信息
     * @param propertId
     * @return
     */
    BusPayDetail selectByPropertId(Long propertId);


    /**
     * 发票生成信息
     * @param reportId
     * @return
     */
     ReportFee selectByRepId(Long reportId, String flag,Long debtId,Long propertId) throws ParseException;

}
