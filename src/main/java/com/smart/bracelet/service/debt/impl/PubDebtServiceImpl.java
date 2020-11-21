package com.smart.bracelet.service.debt.impl;


import com.smart.bracelet.dao.debt.PubDebtDao;
import com.smart.bracelet.dao.user.PubCompanyDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.DateAndDays;
import com.smart.bracelet.model.po.debt.PubDebt;
import com.smart.bracelet.model.vo.debt.*;
import com.smart.bracelet.service.debt.PubDebtService;
import com.smart.bracelet.utils.BigDecimalUtil;
import com.smart.bracelet.utils.ConvertUpMoney;
import com.smart.bracelet.utils.IdUtils;
import com.smart.bracelet.utils.RepNoUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class PubDebtServiceImpl implements PubDebtService {

    @Autowired
    private PubDebtDao pubDebtDao;

    @Autowired
    private PubCompanyDao pubCompanyDao;

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int deleteByPrimaryKey(Long debtId) throws CustomerException {
        try {
            int deleteByPrimaryKey = pubDebtDao.deleteByPrimaryKey(debtId);
            log.info("删除借债信息成功,受影响行数:{}", deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("删除解债信息失败,异常信息:{}", e.getMessage());
            throw new CustomerException("删除解债信息失败");
        }
    }


    @Override
    @Transactional(noRollbackFor = Exception.class)
    public Long insertSelective(PubDebt record) throws CustomerException {
        try {
            Long l = IdUtils.nextId();
            record.setDebtId(l);
            record.setDebtNo(RepNoUtils.createRepNo("TZ","ZQZR",pubDebtDao.selectNo()));
            int insertSelective = pubDebtDao.insertSelective(record);
            log.info("新增解债信息成功,受影响行数:{}", insertSelective);
            return l;
        } catch (Exception e) {
            log.error("新增解债信息失败,异常信息:{}", e.getMessage());
            throw new CustomerException("新增解债信息失败");
        }
    }

    @Override
    public PubDebt selectByPrimaryKey(Long debtId) {
        PubDebt pubDebt = pubDebtDao.selectByPrimaryKey(debtId);
        String sub = BigDecimalUtil.sub(pubDebt.getAmountCumulative().toString(), pubDebt.getAmountThis().toString(), 2);
        pubDebt.setAmountCumulative(Float.parseFloat(sub));
        return pubDebt;
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(PubDebtVo record) throws CustomerException {
        try {
            int updateByPrimaryKeySelective = pubDebtDao.updateByPrimaryKeySelective(record);
            log.info("更新解债信息成功,受影响行数:{}", updateByPrimaryKeySelective);
            return updateByPrimaryKeySelective;
        } catch (Exception e) {
            log.error("更新解债信息失败,异常信息:{}", e.getMessage());
            throw new CustomerException("更新解债信息失败");
        }
    }

    /**
     * 按照日期查询每日解债数量
     */
    @Override
    public List<DateAndDays> selectDaysCount(String type, Long comId) {
        if (type.equals("1")) {
            type = null;
            comId = null;
        }
        return pubDebtDao.selectDaysCount(type, comId);
    }


    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int updateStatus(String status, Long debtId, String checkReason) throws CustomerException {
        try {
            int i = pubDebtDao.updateStatus(status, debtId, checkReason);
            log.info("更新解债状态成功,受影响行数:{}", i);
            return i;
        } catch (Exception e) {
            log.error("更新解债状态失败,异常信息:{}", e.getMessage());
            throw new CustomerException("更新解债状态失败");
        }
    }

    @Override
    public List<PubDebtInfo> selectDebtListShow(DebtInfoQuery DebtInfoQuery) {
        if (DebtInfoQuery.getCompanyType().equals("1")) {
            DebtInfoQuery.setCompanyType(null);
            DebtInfoQuery.setComId(null);
        }
        return pubDebtDao.selectDebtListShow(DebtInfoQuery);
    }

    @Override
    public List<PubDebtInfo> selectByReportIds(Long reportId) {
        return pubDebtDao.selectByReportIds(reportId);
    }

    @Override
    public List<PubDebt> selectByreportId(Long reportId) {
        return pubDebtDao.selectByreportId(reportId);
    }


    @Override
    @Transactional(noRollbackFor = Exception.class)
    public PlanServiceInfo initializePlan(Long debtId, Long comId) throws CustomerException {
        try {
            PlanServiceInfo initialize = pubDebtDao.initializePlan(debtId);
            if (StringUtils.isEmpty(initialize.getServiceNo())) {
                initialize.setServiceNo(RepNoUtils.createRepNo("TZ", pubCompanyDao.selectByPrimaryKey(comId).getCompanyNameMax(), pubDebtDao.selectServiiceNo()));
                initialize.setContractDate(new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
            }
            initialize.setThisPlanMoneyMax(ConvertUpMoney.toChinese(initialize.getThisPlanMoney()));
            initialize.setAmountThisMax(ConvertUpMoney.toChinese(initialize.getAmountThis().toString()));
            if (initialize.getReportPropert().equals("1")) {
                initialize.setCorBankAdd(null);
                initialize.setCorBankPhone(null);
            } else {
                initialize.setPriAdd(null);
                initialize.setPriPhone(null);
            }
            return initialize;
        } catch (Exception e) {
            log.error("异常信息:{}", e.getMessage());
            throw new CustomerException("查询异常" + e.getMessage());
        }
    }

    @Override
    public int updatePlanInfo(String matters, String serviceNo, Float servicePrincipal, Float serviceInterest, Date contractDate, Long debtId) throws CustomerException {
        try {
            int i = pubDebtDao.updatePlanInfo(matters, serviceNo, servicePrincipal, serviceInterest, contractDate, debtId);
            log.info("新增策划方案成功，受影响行数：{}",i);
            return i;
        } catch (Exception e) {
            log.error("新增策划方案服务协议失败，异常信息：{}",e.getMessage());
            throw new CustomerException("新增策划方案协议失败");
        }
    }

    @Override
    public PubDebt selectMoney(Long reportId) {
        return pubDebtDao.selectMoney(reportId);
    }
}
