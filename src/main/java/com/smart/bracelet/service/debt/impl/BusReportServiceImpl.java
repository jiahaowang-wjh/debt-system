package com.smart.bracelet.service.debt.impl;

import com.smart.bracelet.dao.debt.BusReportDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusReport;
import com.smart.bracelet.model.po.debt.DateAndDays;
import com.smart.bracelet.model.vo.debt.BusReportVo;
import com.smart.bracelet.service.debt.BusReportService;
import com.smart.bracelet.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class BusReportServiceImpl implements BusReportService {

    @Autowired
    private BusReportDao busReportDao;


    @Override
    public int deleteByPrimaryKey(Long reportId) throws CustomerException {
        try {
            int deleteByPrimaryKey = busReportDao.deleteByPrimaryKey(reportId);
            log.info("报备信息删除成功,受影响行数:{}", deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("报备信息删除失败,异常信息:{}", e.getMessage());
            throw new CustomerException("报备信息删除失败");
        }
    }

    @Override
    public int insertSelective(BusReport record) throws CustomerException {
        try {
            record.setReportId(IdUtils.nextId());
            int insertSelective = busReportDao.insertSelective(record);
            log.info("新增报备信息成功,受影响行数:{}",insertSelective);
            return insertSelective;
        } catch (Exception e) {
            log.error("新增报备信息失败,异常信息:{}",e.getMessage());
            throw new CustomerException("新增报备信息失败");
        }

    }

    @Override
    public BusReport selectByPrimaryKey(Long reportId) {
        return busReportDao.selectByPrimaryKey(reportId);
    }

    @Override
    public int updateByPrimaryKeySelective(BusReportVo record) throws CustomerException {
        try {
            int updateByPrimaryKeySelective = busReportDao.updateByPrimaryKeySelective(record);
            log.info("更新报备信息成功,受影响行数:{}",updateByPrimaryKeySelective);
            return updateByPrimaryKeySelective;
        } catch (Exception e) {
            log.error("更新报备信息失败,异常信息:{}",e.getMessage());
            throw new CustomerException("更新报备信息失败");
        }
    }

    @Override
    public List<BusReport> queryBusReport() {
        return busReportDao.queryBusReport();
    }

    @Override
    public List<DateAndDays> selectDaysCount() {
        return busReportDao.selectDaysCount();
    }
}
