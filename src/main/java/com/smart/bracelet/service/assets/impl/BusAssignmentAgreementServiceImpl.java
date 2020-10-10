package com.smart.bracelet.service.assets.impl;

import com.smart.bracelet.dao.assets.BusAssignmentAgreementDao;
import com.smart.bracelet.dao.user.PubCompanyDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusAssignmentAgreement;
import com.smart.bracelet.model.po.user.PubCompany;
import com.smart.bracelet.model.vo.assets.BusAssignmentAgreementShow;
import com.smart.bracelet.model.vo.assets.BusAssignmentAgreementVo;
import com.smart.bracelet.service.assets.BusAssignmentAgreementService;
import com.smart.bracelet.utils.BigDecimalUtil;
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
public class BusAssignmentAgreementServiceImpl implements BusAssignmentAgreementService {
    @Autowired
    private BusAssignmentAgreementDao busAssignmentAgreementDao;

    @Autowired
    private PubCompanyDao pubCompanyDao;

    @Override
    @Transactional(noRollbackFor = Exception.class)
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
    @Transactional(noRollbackFor = Exception.class)
    public Long insertSelective(BusAssignmentAgreement record) throws CustomerException {
        try {
            long l = IdUtils.nextId();
            record.setAssignmentAgreementId(l);
            int insertSelective = busAssignmentAgreementDao.insertSelective(record);
            log.info("新增资产债权转让协议成功,受影响行数:{}", insertSelective);
            return l;
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
    @Transactional(noRollbackFor = Exception.class)
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
     *
     * @param propertId
     * @return
     */
    @Override
    public BusAssignmentAgreementShow initialize(Long propertId, Long comId) throws CustomerException {
        try {
            BusAssignmentAgreementShow agreementShow = busAssignmentAgreementDao.initialize(propertId);
            //编号为空为初始化
            if(StringUtils.isEmpty(agreementShow.getAssignmentAgreementNo())){
                PubCompany pubCompany = pubCompanyDao.selectByPrimaryKey(comId);
                String selectNo = busAssignmentAgreementDao.selectNo();
                String repNo = RepNoUtils.createRepNo("ZC", pubCompany.getCompanyNameMax(), selectNo);
                agreementShow.setAssignmentAgreementNo(repNo);
                agreementShow.setContractTime(new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
            }
            agreementShow.setThisTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            int debtYaer = Integer.parseInt(agreementShow.getDebtYaer());
            switch (debtYaer) {
                case 1:
                    agreementShow.setMoney(Float.parseFloat(BigDecimalUtil.mul(agreementShow.getAmountThis().toString(), "0.2", 2)));
                    break;
                case 2:
                    agreementShow.setMoney(Float.parseFloat(BigDecimalUtil.mul(agreementShow.getAmountThis().toString(), "0.3", 2)));
                    break;
                case 3:
                    agreementShow.setMoney(Float.parseFloat(BigDecimalUtil.mul(agreementShow.getAmountThis().toString(), "0.5", 2)));
                    break;
            }
            if (agreementShow.getReportPropert().equals("1")) {
                agreementShow.setCorBankAdd(null);
                agreementShow.setCorBankPhone(null);
            } else {
                agreementShow.setPriAdd(null);
                agreementShow.setPriPhone(null);
            }
            if(agreementShow.getReportPriPropert().equals("1")){
                agreementShow.setPersonCorBackPhone(null);
            }else{
                agreementShow.setPersonPriPhone(null);
            }

            return agreementShow;
        } catch (Exception e) {
            log.error("异常信息:{}", e.getMessage());
            throw new CustomerException("查询失败,请检查参数");
        }
    }

    @Override
    public BusAssignmentAgreement selectByProId(Long propertId) {
        return busAssignmentAgreementDao.selectByProId(propertId);
    }
}
