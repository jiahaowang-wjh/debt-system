package com.smart.bracelet.service.assets.impl;

import com.smart.bracelet.dao.assets.BusAssignmentAgreementDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusAssignmentAgreement;
import com.smart.bracelet.model.vo.assets.BusAssignmentAgreementShow;
import com.smart.bracelet.model.vo.assets.BusAssignmentAgreementVo;
import com.smart.bracelet.service.assets.BusAssignmentAgreementService;
import com.smart.bracelet.utils.IdUtils;
import com.smart.bracelet.utils.RepNoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class BusAssignmentAgreementServiceImpl implements BusAssignmentAgreementService {
    @Autowired
    private BusAssignmentAgreementDao busAssignmentAgreementDao;

    @Override
    public int deleteByPrimaryKey(Long assignmentAgreementId) throws CustomerException {
        try {
            int deleteByPrimaryKey = busAssignmentAgreementDao.deleteByPrimaryKey(assignmentAgreementId);
            log.info("删除资产债权转让协议成功,受影响行数:{}", deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("删除资产债权转让协议失败,异常信息:{}", e.getMessage());
            throw new CustomerException("删除资产债权转让协议失败");
        }
    }

    @Override
    public int insertSelective(BusAssignmentAgreement record) throws CustomerException {
        try {
            String selectNo = busAssignmentAgreementDao.selectNo();
            String repNo = RepNoUtils.createRepNo("ZCGS", "ZQZR", selectNo);
            record.setAssignmentAgreementId(IdUtils.nextId());
            record.setAssignmentAgreementNo(repNo);
            int insertSelective = busAssignmentAgreementDao.insertSelective(record);
            log.info("新增资产债权转让协议成功,受影响行数:{}", insertSelective);
            return insertSelective;
        } catch (Exception e) {
            log.error("新增资产债权转让协议失败,异常信息:{}", e.getMessage());
            throw new CustomerException("新增资产债权转让协议失败");
        }
    }

    @Override
    public BusAssignmentAgreement selectByPrimaryKey(Long assignmentAgreementId) {
        return busAssignmentAgreementDao.selectByPrimaryKey(assignmentAgreementId);
    }

    @Override
    public int updateByPrimaryKeySelective(BusAssignmentAgreementVo record) throws CustomerException {
        try {
            int updateByPrimaryKeySelective = busAssignmentAgreementDao.updateByPrimaryKeySelective(record);
            log.info("更新资产债权转让协议成功,受影响行数:{}", updateByPrimaryKeySelective);
            return updateByPrimaryKeySelective;
        } catch (Exception e) {
            log.error("更新资产债权转让协议失败,异常信息:{}", e.getMessage());
            throw new CustomerException("更新资产债权转让协议失败");
        }
    }

    @Override
    public List<BusAssignmentAgreement> queryList() {
        return busAssignmentAgreementDao.queryList();
    }

    /**
     * 页面初始化
     * @param reportId      报备ID
     * @return
     */
    @Override
    public BusAssignmentAgreementShow initialize(Long reportId) throws CustomerException {
        try {
            BusAssignmentAgreementShow agreementShow = busAssignmentAgreementDao.initialize(reportId);
            int debtYaer = Integer.parseInt(agreementShow.getDebtYaer());
            switch (debtYaer) {
                case 1:
                    agreementShow.setMoney(agreementShow.getAmountThis() * 0.2f);
                    break;
                case 2:
                    agreementShow.setMoney(agreementShow.getAmountThis() * 0.3f);
                    break;
                case 3:
                    agreementShow.setMoney(agreementShow.getAmountThis() * 0.5f);
                    break;
            }
            if(agreementShow.getReportPropert().equals("1")){
                agreementShow.setCorBankAdd(null);
                agreementShow.setCorBankPhone(null);
            }else{
                agreementShow.setPriAdd(null);
                agreementShow.setPriPhone(null);
            }
            agreementShow.setThisTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            return agreementShow;
        } catch (Exception e) {
            log.error("异常信息:{}",e.getMessage());
            throw new CustomerException("查询失败,请检查参数");
        }

    }
}
