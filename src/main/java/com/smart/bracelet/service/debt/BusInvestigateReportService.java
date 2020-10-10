package com.smart.bracelet.service.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusInvestigateReport;

public interface BusInvestigateReportService {

    int deleteByPrimaryKey(Long reportId);

    Long insert(BusInvestigateReport record) throws CustomerException;

    int insertSelective(BusInvestigateReport record);

    BusInvestigateReport selectByPrimaryKey(Long reportId);

    int updateByPrimaryKeySelective(BusInvestigateReport record);

    int updateByPrimaryKey(BusInvestigateReport record);


    BusInvestigateReport selectByDebtId(Long debtId);
}
