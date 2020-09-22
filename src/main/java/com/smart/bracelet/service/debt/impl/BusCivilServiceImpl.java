package com.smart.bracelet.service.debt.impl;

import com.smart.bracelet.dao.debt.BusCivilDao;
import com.smart.bracelet.dao.debt.BusGuaranteeDao;
import com.smart.bracelet.dao.debt.BusRelativePersonDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.*;
import com.smart.bracelet.model.vo.debt.*;
import com.smart.bracelet.service.debt.BusCivilService;
import com.smart.bracelet.utils.BigDecimalUtil;
import com.smart.bracelet.utils.ConvertUpMoney;
import com.smart.bracelet.utils.IdUtils;
import com.smart.bracelet.utils.RepNoUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BusCivilServiceImpl implements BusCivilService {

    @Autowired
    private BusCivilDao busCivilDao;

    @Autowired
    private BusGuaranteeDao busGuaranteeDao;

    @Autowired
    private BusRelativePersonDao busRelativePersonDao;


    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int deleteByPrimaryKey(Long civilId) throws CustomerException {
        try {
            int deleteByPrimaryKey = busCivilDao.deleteByPrimaryKey(civilId);
            log.info("删除民事调解信息成功,受影响行数:{}", deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("删除民事调解信息失败,异常信息:{}", e.getMessage());
            throw new CustomerException("删除民事调解信息失");
        }
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public Long insertSelective(BusCivil record) throws CustomerException {
        try {
            //民事调解ID
            Long CiID = IdUtils.nextId();
            String selectRepNo = busCivilDao.selectRepNo();
            String repNo = RepNoUtils.createRepNo("TZ", "MSTJ", selectRepNo);
            record.setCivilId(CiID);
            record.setCivilno(repNo);
            BusGuarantee[] busGuarantee = record.getBusGuarantee();
            if (StringUtils.isEmpty(record.getLongs().toString())) {
                throw new CustomerException("调解员id不能为空");
            }
            Long[] longs = record.getLongs();
            int insertSelective = busCivilDao.insertSelective(record);
            log.info("新增民事调解信息成功,受影响行数:{}", insertSelective);
            if (insertSelective != 0) {
                if (busGuarantee != null) {
                    for (BusGuarantee item : busGuarantee) {
                        if (!StringUtils.isBlank(item.getAuthname())) {
                            item.setCivilId(CiID);
                            item.setGuaranteeId(IdUtils.nextId());
                        }
                    }
                    record.setBusGuarantee(busGuarantee);
                    //批量新增担保人
                    int i = busGuaranteeDao.insertList(record.getBusGuarantee());
                    log.info("新增担保人成功受影响行数：{}", i);
                }
                //新增调解员
                List<BusMediatePerson> list = new ArrayList<>();
                for (Long item : longs) {
                    BusMediatePerson busMediatePerson = new BusMediatePerson();
                    busMediatePerson.setMediatePersonId(IdUtils.nextId());
                    busMediatePerson.setCivilId(CiID);
                    busMediatePerson.setUserId(item);
                    list.add(busMediatePerson);
                }
                int i1 = busCivilDao.inertList(list);
                log.info("批量新增调解员成功，受影响行数：{}", i1);
            }
            return CiID;
        } catch (Exception e) {
            log.error("新增民事调解信息失败,异常信息:{}", e.getMessage());
            throw new CustomerException("新增民事调解信息失败" + e.getMessage());
        }
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public BusCivil selectByPrimaryKey(Long civilId) {
        return busCivilDao.selectByPrimaryKey(civilId);
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(BusCivilVo record) throws CustomerException {
        try {
            int updateByPrimaryKeySelective = busCivilDao.updateByPrimaryKeySelective(record);
            log.info("更新民事调解信息成功,受影响行数:{}", updateByPrimaryKeySelective);
            return updateByPrimaryKeySelective;
        } catch (Exception e) {
            log.error("更新民事调解信息失败,异常信息:{}", e.getMessage());
            throw new CustomerException("更新民事调解信息失败");
        }
    }

    /**
     * 查询民事调节信息并按照日期分组
     *
     * @return
     */
    @Override
    @Transactional(noRollbackFor = Exception.class)
    public List<DateAndDays> selectDaysCount(String type,Long comId) {
        if(type.equals("1")){
            type = null;
            comId = null;
        }
        return busCivilDao.selectDaysCount(type,comId);
    }

    /**
     * 查询所有民事调解信息
     *
     * @return
     */
    @Override
    public List<BusCivil> queryList() {
        return busCivilDao.queryList();
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int updateStatus(String status, Long civilId, String checkReason) throws CustomerException {
        try {
            int i = busCivilDao.updateStatus(status, civilId, checkReason);
            log.info("更新民事调解状态成功,受影响行数:{}", i);
            return i;
        } catch (Exception e) {
            log.error("更新民事调解状态失败,异常信息:{}", e.getMessage());
            throw new CustomerException("更新民事调解状态失败");
        }
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public List<BusCivilInfo> selectBusList(DebtInfoQuery debtInfoQuery) {
        if (debtInfoQuery.getCompanyType().equals("1")) {
            debtInfoQuery.setCompanyType(null);
            debtInfoQuery.setComId(null);
        }
        return busCivilDao.selectBusList(debtInfoQuery);
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public List<CiviIAndRepShow> selectCiviIAndRepShow() {
        return busCivilDao.selectCiviIAndRepShow();
    }


    /**
     * 民事调解身份信息验证
     *
     * @param relativePerId
     * @return
     * @throws CustomerException
     */
    @Override
    @Transactional(noRollbackFor = Exception.class)
    public Boolean verification(Long relativePerId) {
        Boolean ok = false;
        //1.通过相对人ID获取债事人相对人身份信息
        DebtAndPerson debtAndPerson = busCivilDao.selectDebtAndPer(relativePerId);
        //2.通过相对人信息去债事人表中验证,若有此人则获取当前报备ID
        List<Long> aLong = busCivilDao.selectReportId(debtAndPerson.getPersonIdcard());
        //查询相对人是否债事报备
        if (org.springframework.util.StringUtils.isEmpty(aLong)) {
            return false;
        }
        for (Long item: aLong) {
            List<BusRelativePerson> busRelativePeople = busRelativePersonDao.selectByreportId(item);
            for (BusRelativePerson item1: busRelativePeople) {
                if(item1.getData2().equals(debtAndPerson.getDebtIdcard())){
                    ok=true;
                }
            }
        }
        return ok;
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public AgreementInfoShow initialize(Long reportId) {
        AgreementInfoShow initialize = busCivilDao.initialize(reportId);
        if (initialize.getReportPropert().equals("1")) {
            initialize.setCorBankPhone(null);
        } else {
            initialize.setPriPhone(null);
        }
        return initialize;
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public PlanServiceInfo initializePlan(Long reportId) throws CustomerException {
        try {
            PlanServiceInfo initialize = busCivilDao.initializePlan(reportId);
//            if (initialize.getDebtId() == null) {
//                throw new CustomerException("该债事人未进行置换处理");
//            }
            //String mul = BigDecimalUtil.mul(initialize.getAmountThis().toString(), "0.1", 2);
            //initialize.setPlanMoney(mul);
           // initialize.setPlanMoneyMax(ConvertUpMoney.toChinese(mul));
            //initialize.setAmountThisMax(ConvertUpMoney.toChinese(initialize.getAmountThis().toString()));
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
            throw new CustomerException("查询异常"+e.getMessage());
        }
    }

    @Override
    public List<CivilShow> selectByReportId(Long reportId) {
        return busCivilDao.selectByReportId(reportId);
    }

    @Override
    public List<CivilAndPseronInfo> selectCivi(Long reportId) {
        return busCivilDao.selectCivi(reportId);
    }
}
