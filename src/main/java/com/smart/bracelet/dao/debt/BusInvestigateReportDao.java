package com.smart.bracelet.dao.debt;

import com.smart.bracelet.model.po.debt.BusInvestigateReport;
import com.smart.bracelet.model.vo.debt.BusInvestigateReportVo;
import org.springframework.stereotype.Repository;

@Repository
public interface BusInvestigateReportDao {
    int deleteByPrimaryKey(Long reportId);

    int insertSelective(BusInvestigateReport record);

    BusInvestigateReport selectByPrimaryKey(Long reportId);

    int updateByPrimaryKeySelective(BusInvestigateReportVo record);

}