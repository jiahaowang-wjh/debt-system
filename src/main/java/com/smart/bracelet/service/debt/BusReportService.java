package com.smart.bracelet.service.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusReport;
import com.smart.bracelet.model.po.debt.DateAndDays;
import com.smart.bracelet.model.vo.debt.BusReportVo;

import java.util.List;

public interface BusReportService {

    int deleteByPrimaryKey(Long reportId) throws CustomerException;

    int insertSelective(BusReport record) throws CustomerException;

    BusReport selectByPrimaryKey(Long reportId);

    int updateByPrimaryKeySelective(BusReportVo record) throws CustomerException;

    List<BusReport> queryBusReport();

    /**
     * 按照日期查询每日报备数量
     * @return
     */
    List<DateAndDays> selectDaysCount();
}
