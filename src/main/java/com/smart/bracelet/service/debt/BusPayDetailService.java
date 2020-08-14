package com.smart.bracelet.service.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusPayDetail;
import com.smart.bracelet.model.vo.debt.BusPayDetailInfo;
import com.smart.bracelet.model.vo.debt.BusPayDetailVo;

import java.util.List;

public interface BusPayDetailService {

    int deleteByPrimaryKey(Long payId) throws CustomerException;

    int insertSelective(BusPayDetail record) throws CustomerException;

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
    List<BusPayDetailInfo> selectPayInfoList(String debtNo);
}
