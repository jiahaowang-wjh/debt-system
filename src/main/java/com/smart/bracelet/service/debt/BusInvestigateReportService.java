package com.smart.bracelet.service.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusInvestigateReport;
import com.smart.bracelet.model.vo.debt.BusInvestigateReportVo;

public interface BusInvestigateReportService {

    int deleteByPrimaryKey(Long reportId) throws CustomerException;

    Long insertSelective(BusInvestigateReport record) throws CustomerException;

    BusInvestigateReport selectByPrimaryKey(Long reportId);

    int updateByPrimaryKeySelective(BusInvestigateReportVo record) throws CustomerException;

}
