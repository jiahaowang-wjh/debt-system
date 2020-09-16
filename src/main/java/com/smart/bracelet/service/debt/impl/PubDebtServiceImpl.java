package com.smart.bracelet.service.debt.impl;

import com.smart.bracelet.dao.debt.BusGuaranteeDao;
import com.smart.bracelet.dao.debt.PubDebtDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.DateAndDays;
import com.smart.bracelet.model.po.debt.PubDebt;
import com.smart.bracelet.model.vo.debt.*;
import com.smart.bracelet.service.debt.PubDebtService;
import com.smart.bracelet.utils.IdUtils;
import com.smart.bracelet.utils.RepNoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;

@Service
@Slf4j
public class PubDebtServiceImpl implements PubDebtService {

    @Autowired
    private PubDebtDao pubDebtDao;

    @Autowired
    private BusGuaranteeDao busGuaranteeDao;

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
            String selectNo = pubDebtDao.selectNo();
            //累计金额等于本次加累计
            record.setAmountCumulative(record.getAmountCumulative() + record.getAmountThis());
            String repNo = RepNoUtils.createRepNo("TZ", "ZLGS", selectNo);
            record.setDebtId(l);
            record.setDebtNo(createRepNo());
            record.setServiceNo(repNo);
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
        return pubDebtDao.selectByPrimaryKey(debtId);
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
    public List<DateAndDays> selectDaysCount() {
        return pubDebtDao.selectDaysCount();
    }

    /**
     * 查询所有解债信息
     *
     * @return
     */
    @Override
    public List<PubDebt> queryList() {
        List<PubDebt> pubDebts = pubDebtDao.queryList();
        return pubDebts;
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
    public List<PubDebtInfo> selectDebtListShow(QueryDebtVo queryDebtVo) {
        if (queryDebtVo.getCompanyType().equals("1")) {
            queryDebtVo.setCompanyType(null);
        }
        return pubDebtDao.selectDebtListShow(queryDebtVo);
    }

    @Override
    public List<DebtAndRepAndCiviI> selectDebtAndRepAndCiviI() {
        return pubDebtDao.selectDebtAndRepAndCiviI();
    }

    @Override
    public List<PubDebt> selectByreportId(Long reportId) {
        return pubDebtDao.selectByreportId(reportId);
    }

    @Override
    public DebtMoney selectMoney(Long relativePerId) {
        return pubDebtDao.selectMoney(relativePerId);
    }

    @Override
    public List<PubDebtInfo> selectByReportIds(Long reportId) {
        return pubDebtDao.selectByReportIds(reportId);
    }


    /**
     * 编号生成方法
     *
     * @return
     */
    public String createRepNo() {
        String repNo;
        int intXuhao;
        String stringXuhao;
        boolean ok = true;
        Calendar ca = Calendar.getInstance();
        int year = ca.get(Calendar.YEAR);//获取年份
        String xuHao = null;
        String aLong = pubDebtDao.selectRepNo();
        if (aLong != null) {
            xuHao = aLong.substring(aLong.toString().indexOf("F") + 1);
            intXuhao = Integer.parseInt(xuHao);
            intXuhao = intXuhao + 1;
            stringXuhao = intXuhao + "";
            while (ok) {
                if (stringXuhao.length() < 6) {
                    stringXuhao = 0 + stringXuhao;
                } else {
                    ok = false;
                }
            }
            repNo = "TZ" + year + "JJF" + stringXuhao;
            return repNo;
        } else {
            repNo = "TZ" + year + "JJF" + "000001";
            return repNo;
        }
    }

}
