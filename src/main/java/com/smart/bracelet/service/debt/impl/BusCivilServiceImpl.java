package com.smart.bracelet.service.debt.impl;

import com.smart.bracelet.dao.debt.BusCivilDao;
import com.smart.bracelet.dao.debt.BusGuaranteeDao;
import com.smart.bracelet.dao.debt.BusRelativePersonDao;
import com.smart.bracelet.dao.debt.BusReportDao;
import com.smart.bracelet.dao.user.PubCompanyDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.*;
import com.smart.bracelet.model.po.user.PubCompany;
import com.smart.bracelet.model.vo.debt.*;
import com.smart.bracelet.service.debt.BusCivilService;
import com.smart.bracelet.utils.IdUtils;
import com.smart.bracelet.utils.RepNoUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

    @Autowired
    private PubCompanyDao pubCompanyDao;

    @Autowired
    private BusReportDao busReportDao;

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
                if (longs != null && longs.length != 0) {
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
        BusCivil busCivil = busCivilDao.selectByPrimaryKey(civilId);
        BusGuarantee[] busGuarantees = busGuaranteeDao.selectByPrimaryKey1(civilId);
        CiviliVo[] civiliVos = busCivilDao.selectUser(civilId);
        if (civiliVos != null) {
            busCivil.setCiviliVos(civiliVos);
        }
        if (busGuarantees != null) {
            busCivil.setBusGuarantee(busGuarantees);
        }
        return busCivil;
    }

    @Override
    public int updateByPrimaryKeySelective(BusCivilVo record) throws CustomerException {
        try {
            if (record.getCivilId() != null) {
                int i = busGuaranteeDao.deleteByCiviId(record.getCivilId());
                int i1 = busCivilDao.delUser(record.getCivilId());
                log.info("删除担保人成功:{}", i);
                log.info("删除调解员成功:{}", i1);
            }
            int updateByPrimaryKeySelective = busCivilDao.updateByPrimaryKeySelective(record);
            BusGuarantee[] busGuarantee = record.getBusGuarantee();
            if (busGuarantee != null) {
                for (BusGuarantee item : busGuarantee) {
                    if (!StringUtils.isBlank(item.getAuthname()) && !StringUtils.isBlank(item.getCard())) {
                        item.setCivilId(record.getCivilId());
                        item.setGuaranteeId(IdUtils.nextId());
                    }
                    record.setBusGuarantee(busGuarantee);
                }
                //批量新增担保人
                int i = busGuaranteeDao.insertList(record.getBusGuarantee());
                log.info("新增担保人成功受影响行数：{}", i);
            }
            Long[] longs = record.getLongs();
            if (longs != null && longs.length != 0) {
                //新增调解员
                List<BusMediatePerson> list = new ArrayList<>();
                for (Long item : longs) {
                    BusMediatePerson busMediatePerson = new BusMediatePerson();
                    busMediatePerson.setMediatePersonId(IdUtils.nextId());
                    busMediatePerson.setCivilId(record.getCivilId());
                    busMediatePerson.setUserId(item);
                    list.add(busMediatePerson);
                }
                int i1 = busCivilDao.inertList(list);
                log.info("批量新增调解员成功，受影响行数：{}", i1);
                log.info("更新民事调解信息成功,受影响行数:{}", updateByPrimaryKeySelective);
            }
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
    public List<DateAndDays> selectDaysCount(String type, Long comId) {
        if (type.equals("1")) {
            type = null;
            comId = null;
        }
        return busCivilDao.selectDaysCount(type, comId);
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
        List<Long> aLong = new ArrayList<>();
        Boolean ok = false;
        //1.通过相对人ID获取债事人相对人身份信息
        DebtAndPerson debtAndPerson = busCivilDao.selectDebtAndPer(relativePerId);
        if(debtAndPerson.getStatus().equals("1")){
            return ok;
        }
        if (debtAndPerson.getPriReportPropert().equals("1")) {
            //2.通过相对人信息去债事人表中验证,若有此人则获取当前报备ID
            aLong = busCivilDao.selectReportIdPri(debtAndPerson.getPriPhone());
        } else {
            aLong = busCivilDao.selectReportIdCor(debtAndPerson.getCorPhone());
        }
        //3.查询相对人是否债事报备
        if (org.springframework.util.StringUtils.isEmpty(aLong)) {
            return false;
        }
        //4.遍历债事表中，该属于该相对人的报备ID
        for (Long item : aLong) {
            //5.通过报备id查询相对人
            List<BusRelativePerson> busRelativePeople = busRelativePersonDao.selectByreportId(item);
            //6.遍历相对人集合
            for (BusRelativePerson item1 : busRelativePeople) {
                //7.判断此债事人中是否存在
                String phoneA;
                String phoneB;
                if (item1.getReportPropert().equals("1")) {
                    phoneA = item1.getData3();
                } else {
                    phoneA = item1.getData5();
                }
                if (debtAndPerson.getReportPropert().equals("1")) {
                    phoneB = debtAndPerson.getPerPhonePri();
                } else {
                    phoneB = debtAndPerson.getPerPhoneCor();
                }
                if (phoneA.equals(phoneB)) {
                    ok = true;
                }
            }
        }
        return ok;
    }

    /**
     * 生成编号
     *
     * @return
     */
    String agreementNo(Long comId) {
        Calendar ca = Calendar.getInstance();
        int year = ca.get(Calendar.YEAR);//获取年份
        List<String> s = busReportDao.selectANO();
        PubCompany pubCompany = pubCompanyDao.selectByPrimaryKey(comId);
        if (s == null) {
            return "TZ" + year + pubCompany.getCompanyNameMax() + "000001";
        }
        String i;
        //记录保存最大的序号
        int j = 0;
        for (String item : s) {
            if (item != null) {
                i = item.substring(item.length() - 6);
                if (Integer.parseInt(i) > j) {
                    j = Integer.parseInt(i);
                }
            }
        }
        String j1 = j + "";
        int j3 = Integer.parseInt(j1);
        j3 = j3 + 1;
        String j2 = j3 + "";
        Boolean ok = true;
        while (ok) {
            if (j2.length() < 6) {
                j2 = 0 + j2;
            } else {
                ok = false;
            }
        }
        return "TZ" + year + pubCompany.getCompanyNameMax() + j2;
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public AgreementInfoShow initialize(Long reportId, Long comId) throws ParseException {
        AgreementInfoShow initialize = busCivilDao.initialize(reportId);
        if (StringUtils.isEmpty(initialize.getAgreementNo())) {
            initialize.setAgreementNo(agreementNo(comId));
            initialize.setAgreementDate(new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
        }
        if (initialize.getReportPropert().equals("1")) {
            initialize.setCorBankPhone(null);
        } else {
            initialize.setPriPhone(null);
        }
        return initialize;
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
