package com.smart.bracelet.service.debt.impl;

import com.smart.bracelet.dao.debt.BusPayDetailDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusPayDetail;
import com.smart.bracelet.model.vo.debt.BusPayDetailInfo;
import com.smart.bracelet.model.vo.debt.BusPayDetailVo;
import com.smart.bracelet.model.vo.debt.ReportFee;
import com.smart.bracelet.service.debt.BusPayDetailService;
import com.smart.bracelet.utils.IdUtils;
import com.smart.bracelet.utils.RepNoUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class BusPayDetailServiceImpl implements BusPayDetailService {

    @Autowired
    private BusPayDetailDao busPayDetailDao;

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int deleteByPrimaryKey(Long payId) throws CustomerException {
        try {
            int deleteByPrimaryKey = busPayDetailDao.deleteByPrimaryKey(payId);
            log.info("删除支付明细信息成功,受影响行数:{}", deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("删除支付明细信息失败,异常信息:{}", e.getMessage());
            throw new CustomerException("删除支付明细信息失败");
        }
    }

    /**
     * 组装编号
     *
     * @param name
     * @return
     */
    public String buildUpNo(String name) {
        String selectRepNo = busPayDetailDao.selectRepNo();
        String string3 = "";
        if (!StringUtils.isBlank(selectRepNo)) {
            String substring1 = selectRepNo.substring(0, 6);
            String substring2 = selectRepNo.substring(10);
            string3 = substring1 + name + substring2;
        }
        String repNo = RepNoUtils.createRepNo("TZ", name, string3);
        return repNo;
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public Long insertSelective(BusPayDetail record) throws CustomerException {
        long l = IdUtils.nextId();
        try {
            switch (record.getFlag()) {
                case "1":
                    record.setPayNo(buildUpNo("BBFW"));
                    break;
                case "2":
                    record.setPayNo(buildUpNo("TJFW"));
                    break;
                case "3":
                    record.setPayNo(buildUpNo("ZXFW"));
                    break;
                case "4":
                    record.setPayNo(buildUpNo("HKFW"));
                    break;
                case "5":
                    record.setPayNo(buildUpNo("YHFW"));
                    break;
            }
            record.setPayId(l);
            int insertSelective = busPayDetailDao.insertSelective(record);
            log.info("新增支付信息成功,受影响行数:{}", insertSelective);
            return l;
        } catch (Exception e) {
            log.error("新增支付信息失败,异常信息:{}", e.getMessage());
            throw new CustomerException("新增支付信息失败");
        }
    }

    @Override
    public BusPayDetail selectByPrimaryKey(Long payId) {
        return busPayDetailDao.selectByPrimaryKey(payId);
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(BusPayDetailVo record) throws CustomerException {
        try {
            int updateByPrimaryKeySelective = busPayDetailDao.updateByPrimaryKeySelective(record);
            log.info("更新支付信息成功,受影响行数:{}", updateByPrimaryKeySelective);
            return updateByPrimaryKeySelective;
        } catch (Exception e) {
            log.error("更新支付信息失败,异常信息:{}", e.getMessage());
            throw new CustomerException("更新支付信息失败");
        }
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public List<BusPayDetail> selectByReportId(Long reportId) {
        return busPayDetailDao.selectByReportId(reportId);
    }

    @Override
    public List<BusPayDetailInfo> selectPayInfoList(String debtNo, String companyType, String status) {
        if (companyType.equals("1")) {
            companyType = null;
        }
        return busPayDetailDao.selectPayInfoList(debtNo, companyType, status);
    }

    @Override
    public List<BusPayDetailInfo> selectPayInfoListZc(String debtNo, String companyType, String status) {
        if (companyType.equals("1")) {
            companyType = null;
        }
        return busPayDetailDao.selectPayInfoListZc(debtNo, companyType, status);
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int updateStatus(String status, Long payId, String checkReason) throws CustomerException {
        try {
            int i = busPayDetailDao.updateStatus(status, payId, checkReason);
            return i;
        } catch (Exception e) {
            log.error("更新支付信息失败,异常信息:{}", e.getMessage());
            throw new CustomerException("更新状态失败");
        }
    }

    @Override
    public List<BusPayDetail> selectByReportIdAndDebtId(Long reportId, Long debtId) {
        return busPayDetailDao.selectByReportIdAndDebtId(reportId, debtId);
    }

    @Override
    public BusPayDetail selectByPropertId(Long propertId) {
        return busPayDetailDao.selectByReportIdAndPropertId(propertId);
    }

    @Override
    public ReportFee selectByRepId(Long reportId, String flag, Long debtId, Long propertId) throws ParseException {
        ReportFee reportFees = busPayDetailDao.selectByRepId(reportId, flag, debtId, propertId);
        reportFees.setThisTime(new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
        return reportFees;
    }


}
