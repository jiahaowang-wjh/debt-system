package com.smart.bracelet.service.debt.impl;

import com.smart.bracelet.dao.debt.BusInvestigateReportDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusInvestigateReport;
import com.smart.bracelet.service.debt.BusInvestigateReportService;
import com.smart.bracelet.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class BusInvestigateReportServiceImpl implements BusInvestigateReportService {

    @Autowired
    private BusInvestigateReportDao busInvestigateReportDao;

    @Override
    public int deleteByPrimaryKey(Long reportId) {
        return 0;
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public Long insert(BusInvestigateReport record) throws CustomerException {
        try {
            Long l = IdUtils.nextId();
            record.setReportId(l);
            int insert = busInvestigateReportDao.insert(record);
            log.info("新增调查报告成功，受影响行数：{}", insert);
            return l;
        } catch (Exception e) {
            log.error("新增调查报告失败,异常信息：{}", e.getMessage());
            throw new CustomerException("新增调查报告失败");
        }
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int insertSelective(BusInvestigateReport record) {
        return 0;
    }

    @Override
    public BusInvestigateReport selectByPrimaryKey(Long reportId) {
        return busInvestigateReportDao.selectByPrimaryKey(reportId);
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(BusInvestigateReport record) {
        return 0;
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int updateByPrimaryKey(BusInvestigateReport record) {
        return 0;
    }

    @Override
    public BusInvestigateReport selectByDebtId(Long debtId) {
        return busInvestigateReportDao.selectByDebtId(debtId);
    }
}
