package com.smart.bracelet.dao.debt;

import com.smart.bracelet.model.po.debt.BusInvestigateReport;
import org.springframework.stereotype.Repository;

@Repository
public interface BusInvestigateReportDao {
    int deleteByPrimaryKey(Long reportId);

    int insert(BusInvestigateReport record);

    int insertSelective(BusInvestigateReport record);

    BusInvestigateReport selectByPrimaryKey(Long reportId);

    BusInvestigateReport selectByDebtId(Long debtId);

    int updateByPrimaryKeySelective(BusInvestigateReport record);

    int updateByPrimaryKey(BusInvestigateReport record);
}