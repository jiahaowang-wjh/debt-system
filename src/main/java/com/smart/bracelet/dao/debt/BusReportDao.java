package com.smart.bracelet.dao.debt;

import com.smart.bracelet.model.po.debt.BusReport;
import org.springframework.stereotype.Repository;

@Repository
public interface BusReportDao {
    int deleteByPrimaryKey(Long reportId);

    int insert(BusReport record);

    int insertSelective(BusReport record);

    BusReport selectByPrimaryKey(Long reportId);

    int updateByPrimaryKeySelective(BusReport record);

    int updateByPrimaryKey(BusReport record);



}