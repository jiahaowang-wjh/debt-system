package com.smart.bracelet.dao.debt;

import com.smart.bracelet.model.po.debt.BusReport;
import com.smart.bracelet.model.vo.debt.BusReportVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusReportDao {

    int deleteByPrimaryKey(Long reportId);

    int insertSelective(BusReport record);

    BusReport selectByPrimaryKey(Long reportId);

    int updateByPrimaryKeySelective(BusReportVo record);

    List<BusReport> queryBusReport();

}