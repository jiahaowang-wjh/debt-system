package com.smart.bracelet.service.debt.impl;

import com.smart.bracelet.dao.debt.BusInvestigateReportDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusInvestigateReport;
import com.smart.bracelet.model.vo.debt.BusInvestigateReportVo;
import com.smart.bracelet.service.debt.BusInvestigateReportService;
import com.smart.bracelet.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BusInvestigateReportServiceImpl implements BusInvestigateReportService {

    @Autowired
    private BusInvestigateReportDao busInvestigateReportDao;

    @Override
    public int deleteByPrimaryKey(Long reportId) throws CustomerException {
        try {
            return  busInvestigateReportDao.deleteByPrimaryKey(reportId);
        } catch (Exception e) {
            log.error("异常信息:{}", e.getMessage());
            throw new CustomerException("删除失败");
        }
    }

    @Override
    public int insertSelective(BusInvestigateReport record) throws CustomerException {
        try {
            record.setReportId(IdUtils.nextId());
            return busInvestigateReportDao.insertSelective(record);
        } catch (Exception e) {
            log.error("异常信息:{}",e.getMessage());
            throw new CustomerException("新增失败");
        }
    }

    @Override
    public BusInvestigateReport selectByPrimaryKey(Long reportId) {
        return busInvestigateReportDao.selectByPrimaryKey(reportId);
    }

    @Override
    public int updateByPrimaryKeySelective(BusInvestigateReportVo record) throws CustomerException {
        try {
            return busInvestigateReportDao.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            log.error("异常信息:{}",e.getMessage());
            throw new CustomerException("更新失败");
        }
    }
}
