package com.smart.bracelet.service.assets.impl;

import com.smart.bracelet.controller.publicmethod.Formula;
import com.smart.bracelet.dao.assets.BusPropertDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusPropert;
import com.smart.bracelet.model.po.debt.PubDebt;
import com.smart.bracelet.model.po.user.PubUser;
import com.smart.bracelet.model.vo.assets.AssetsDebtBank;
import com.smart.bracelet.model.vo.assets.AssetsMyDebt;
import com.smart.bracelet.model.vo.assets.FormulaVo;
import com.smart.bracelet.model.vo.debt.BusPropertVo;
import com.smart.bracelet.model.vo.debt.DebtInfoQuery;
import com.smart.bracelet.service.assets.BusPropertService;
import com.smart.bracelet.service.debt.BusReportService;
import com.smart.bracelet.service.debt.PubDebtService;
import com.smart.bracelet.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class BusPropertServiceImpl implements BusPropertService {

    @Autowired
    private BusPropertDao busPropertDao;

    @Autowired
    private PubDebtService pubDebtService;

    @Autowired
    private BusReportService busReportService;

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int deleteByPrimaryKey(Long propertId) throws CustomerException {
        try {
            int deleteByPrimaryKey = busPropertDao.deleteByPrimaryKey(propertId);
            log.info("删除资产信息成功,受影响行数:{}", deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("删除资产信息失败,异常信息:{}", e.getMessage());
            throw new CustomerException("删除资产信息失败");
        }
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public Long insertSelective(BusPropert record) throws CustomerException {
        try {
            PubDebt pubDebt = pubDebtService.selectByPrimaryKey(record.getDebtId());
            Long l = IdUtils.nextId();
            record.setPropertId(l);
            if (pubDebt.getDebtType().equals("4")) {
                busReportService.updateDebtStage("5", record.getReportId());
                return null;
            }
            int insertSelective = busPropertDao.insertSelective(record);
            log.info("新增资产信息成功,受影响行数:{}", insertSelective);
            return l;
        } catch (Exception e) {
            log.error("新增资产信息失败,异常信息:{}", e.getMessage());
            throw new CustomerException("新增资产信息失败");
        }
    }

    @Override
    public BusPropert selectByPrimaryKey(Long propertId) {
        return busPropertDao.selectByPrimaryKey(propertId);
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(BusPropertVo record) throws CustomerException {
        try {
            int updateByPrimaryKeySelective = busPropertDao.updateByPrimaryKeySelective(record);
            log.info("更新资产信息成功,受影响行数:{}", updateByPrimaryKeySelective);
            return updateByPrimaryKeySelective;
        } catch (Exception e) {
            log.error("更新资产信息失败,异常信息:{}", e.getMessage());
            throw new CustomerException("更新资产信息失败");
        }
    }

    @Override
    public List<BusPropert> queryList() {
        return busPropertDao.queryList();
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int updateStatus(String status, String checkReason, Long propertId) throws CustomerException {
        try {
            int i = busPropertDao.updateStatus(status, checkReason, propertId);
            log.info("更新状态成功,受影响行数:{}", i);
            return i;
        } catch (Exception e) {
            log.error("更新状态失败,异常信息:{}", e.getMessage());
            throw new CustomerException("更新状态失败");
        }
    }

    @Override
    public List<AssetsDebtBank> querys(DebtInfoQuery assetsMyDebt) {
        if (assetsMyDebt.getCompanyType().equals("1")) {
            assetsMyDebt.setCompanyType(null);
            assetsMyDebt.setComId(null);
        }
        List<AssetsDebtBank> querys = busPropertDao.querys(assetsMyDebt);
        for (AssetsDebtBank item : querys) {
            if(item.getReportType().equals("1")){
                item.setDebtName(item.getPersonData1());
                item.setPersonName(item.getDebtData1());
            }
            if(item.getReportType().equals("2")){
                item.setDebtName(item.getDebtData1());
                item.setPersonName(item.getPersonData1());
            }
            Formula formula = new Formula();
            if (item.getDebtType().equals("2")) {
                item.setDebtType("1");
            }
            if (item.getDebtType().equals("3")) {
                item.setDebtType("2");
            }
            FormulaVo calculation = formula.Calculation(item.getDebtType(), Integer.parseInt(item.getDebtYaer()), item.getAmountThis());
            item.setHuoKuanMoney(calculation.getLoan());
        }
        return querys;
    }

    @Override
    public int updateStage(String stage, Long propertId) throws CustomerException {
        try {
            int i = 0;
            i = busPropertDao.updateStage(stage, propertId);
            log.info("更新资产阶段成功，受影响行数：{}", i);
            return i;
        } catch (Exception e) {
            log.error("更新资产评估失败,异常信息:{}", e.getMessage());
            throw new CustomerException("更新资产阶段失败");
        }

    }
}
