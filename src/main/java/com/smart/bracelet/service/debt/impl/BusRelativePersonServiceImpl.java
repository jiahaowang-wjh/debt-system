package com.smart.bracelet.service.debt.impl;

import com.smart.bracelet.dao.debt.BusRelativePersonDao;
import com.smart.bracelet.dao.debt.BusReportDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusRelativePerson;
import com.smart.bracelet.model.po.debt.BusReport;
import com.smart.bracelet.model.vo.debt.*;
import com.smart.bracelet.service.debt.BusCivilService;
import com.smart.bracelet.service.debt.BusRelativePersonService;
import com.smart.bracelet.utils.IdUtils;
import com.smart.bracelet.utils.RepNoUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
@Slf4j
public class BusRelativePersonServiceImpl implements BusRelativePersonService {

    @Autowired
    private BusRelativePersonDao busRelativePersonDao;

    @Autowired
    private BusReportDao busReportDao;

    @Autowired
    private BusCivilService busCivilService;

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int deleteByPrimaryKey(Long relativePerId) throws CustomerException {
        try {
            int deleteByPrimaryKey = busRelativePersonDao.deleteByPrimaryKey(relativePerId);
            log.info("删除相对信息成功,受影响行数:{}", deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("删除相对信息失败,异常信息:{}", e.getMessage());
            throw new CustomerException("删除相对信息失败");
        }
    }

    /**
     * 通过ID查询相对人信息
     *
     * @param relativePerId
     * @return
     */
    @Override
    public BusRelativePersonListVo selectByPrimaryKey(Long relativePerId) {
        BusRelativePersonListVo busRelativePersonListVo = new BusRelativePersonListVo();
        BusRelativePerson busRelativePerson = busRelativePersonDao.selectByPrimaryKey(relativePerId);
        //封装工共属性
        busRelativePersonListVo.setRelativePerId(busRelativePerson.getRelativePerId());
        busRelativePersonListVo.setReportId(busRelativePerson.getReportId());
        busRelativePersonListVo.setIscoordinate(busRelativePerson.getIscoordinate());
        busRelativePersonListVo.setReportType(busRelativePerson.getReportType());
        busRelativePersonListVo.setReportPropert(busRelativePerson.getReportPropert());
        busRelativePersonListVo.setCardJust(busRelativePerson.getCardJust());
        busRelativePersonListVo.setCardBack(busRelativePerson.getCardBack());
        busRelativePersonListVo.setObligatRight(busRelativePerson.getObligatRight());
        busRelativePersonListVo.setObligatRightNo(busRelativePerson.getObligatRightNo());
        busRelativePersonListVo.setObligatTime(busRelativePerson.getObligatTime());
        busRelativePersonListVo.setCapital(busRelativePerson.getCapital());
        busRelativePersonListVo.setInterest(busRelativePerson.getInterest());
        busRelativePersonListVo.setInterestRate(busRelativePerson.getInterestRate());
        busRelativePersonListVo.setDebt(busRelativePerson.getDebt());
        busRelativePersonListVo.setDebtNo(busRelativePerson.getDebtNo());
        busRelativePersonListVo.setDebtTime(busRelativePerson.getDebtTime());
        busRelativePersonListVo.setDebtCertificate(busRelativePerson.getDebtCertificate());
        busRelativePersonListVo.setUploadDebtCertificate(busRelativePerson.getUploadDebtCertificate());
        busRelativePersonListVo.setEconomics(busRelativePerson.getEconomics());
        busRelativePersonListVo.setUsage(busRelativePerson.getUsage());
        busRelativePersonListVo.setPrjectManager(busRelativePerson.getPrjectManager());
        busRelativePersonListVo.setCreateUserId(busRelativePerson.getCreateUserId());
        busRelativePersonListVo.setCreateTime(busRelativePerson.getCreateTime());
        busRelativePersonListVo.setUpdateTime(busRelativePerson.getUpdateTime());
        //判断性质在封装
        if (busRelativePerson.getReportPropert().equals("1")) {
            //私人性质
            busRelativePersonListVo.setPersonalName(busRelativePerson.getData1());
            busRelativePersonListVo.setPhone(busRelativePerson.getData3());
            busRelativePersonListVo.setIdCard(busRelativePerson.getData2());
            busRelativePersonListVo.setSex(busRelativePerson.getData4());
            busRelativePersonListVo.setArea(busRelativePerson.getData5());
            busRelativePersonListVo.setEmail(busRelativePerson.getData6());
            busRelativePersonListVo.setAssets(busRelativePerson.getData7());
            busRelativePersonListVo.setAssetsNumber(busRelativePerson.getData8());
            busRelativePersonListVo.setCirculationAssets(busRelativePerson.getData9());
            busRelativePersonListVo.setIfWork(busRelativePerson.getData10());
        }
        if (busRelativePerson.getReportPropert().equals("2") || busRelativePerson.getReportPropert().equals("3")) {
            busRelativePersonListVo.setCompanyName(busRelativePerson.getData1());
            busRelativePersonListVo.setCreditCode(busRelativePerson.getData2());
            busRelativePersonListVo.setIndustryAttributes(busRelativePerson.getData3());
            busRelativePersonListVo.setLegalName(busRelativePerson.getData4());
            busRelativePersonListVo.setLegalPhone(busRelativePerson.getData5());
            busRelativePersonListVo.setLegalIdCard(busRelativePerson.getData6());
            busRelativePersonListVo.setAddress(busRelativePerson.getData7());
            busRelativePersonListVo.setContactPerson(busRelativePerson.getData8());
            busRelativePersonListVo.setContactPhone(busRelativePerson.getData9());
        }

        return busRelativePersonListVo;
    }

    @Override
    public List<BusRelativePersonListVo> queryListVo() {
        List<BusRelativePerson> busRelativePeople = busRelativePersonDao.queryList();
        List<BusRelativePersonListVo> listVos = new ArrayList<>();
        for (BusRelativePerson item : busRelativePeople) {
            BusRelativePersonListVo busRelativePersonListVo = selectByPrimaryKey(item.getRelativePerId());
            listVos.add(busRelativePersonListVo);
        }
        return listVos;
    }


    /**
     * 私人相对人
     *
     * @param busRelativePersonPrivateVo
     * @return
     */
    @Override
    @Transactional(noRollbackFor = Exception.class)
    public Long insertPrivate(BusRelativePersonPrivateVo busRelativePersonPrivateVo) throws CustomerException {
        try {
            Long nextId = IdUtils.nextId();
            BusRelativePerson busRelativePerson = new BusRelativePerson();
            busRelativePerson.setRelativePerId(nextId);
            busRelativePerson.setReportId(busRelativePersonPrivateVo.getReportId());
            busRelativePerson.setIscoordinate(busRelativePersonPrivateVo.getIscoordinate());
            busRelativePerson.setReportType(busRelativePersonPrivateVo.getReportType());
            busRelativePerson.setReportPropert("1");
            busRelativePerson.setData1(busRelativePersonPrivateVo.getPersonalName());
            busRelativePerson.setData2(busRelativePersonPrivateVo.getIdCard());
            busRelativePerson.setData3(busRelativePersonPrivateVo.getPhone());
            busRelativePerson.setData4(busRelativePersonPrivateVo.getSex());
            busRelativePerson.setData5(busRelativePersonPrivateVo.getArea());
            busRelativePerson.setData6(busRelativePersonPrivateVo.getEmail());
            busRelativePerson.setData7(busRelativePersonPrivateVo.getAssets());
            busRelativePerson.setData8(busRelativePersonPrivateVo.getAssetsNumber());
            busRelativePerson.setData9(busRelativePersonPrivateVo.getCirculationAssets());
            busRelativePerson.setData10(busRelativePersonPrivateVo.getIfWork());
            busRelativePerson.setCardJust(busRelativePersonPrivateVo.getCardJust());
            busRelativePerson.setCardBack(busRelativePersonPrivateVo.getCardBack());
            busRelativePerson.setObligatRight(busRelativePersonPrivateVo.getObligatRight());
            busRelativePerson.setObligatRightNo(busRelativePersonPrivateVo.getObligatRightNo());
            busRelativePerson.setObligatTime(busRelativePersonPrivateVo.getObligatTime());
            busRelativePerson.setCapital(busRelativePersonPrivateVo.getCapital());
            busRelativePerson.setInterest(busRelativePersonPrivateVo.getInterest());
            busRelativePerson.setInterestRate(busRelativePersonPrivateVo.getInterestRate());
            busRelativePerson.setDebt(busRelativePersonPrivateVo.getDebt());
            busRelativePerson.setDebtNo(busRelativePersonPrivateVo.getDebtNo());
            busRelativePerson.setDebtTime(busRelativePersonPrivateVo.getDebtTime());
            busRelativePerson.setDebtCertificate(busRelativePersonPrivateVo.getDebtCertificate());
            busRelativePerson.setUploadDebtCertificate(busRelativePersonPrivateVo.getUploadDebtCertificate());
            busRelativePerson.setEconomics(busRelativePersonPrivateVo.getEconomics());
            busRelativePerson.setUsage(busRelativePersonPrivateVo.getUsage());
            busRelativePerson.setPrjectManager(busRelativePersonPrivateVo.getPrjectManager());
            busRelativePerson.setCreateTime(busRelativePersonPrivateVo.getCreateTime());
            busRelativePerson.setUpdateTime(busRelativePersonPrivateVo.getUpdateTime());
            int insertSelective = busRelativePersonDao.insertSelective(busRelativePerson);
            log.info("新增私人相对人成功,受影响行数:{}", insertSelective);
            return nextId;
        } catch (Exception e) {
            log.error("新增私人相对人失败,异常信息:{}", e.getMessage());
            throw new CustomerException("新增私人相对人失败");
        }
    }

    /**
     * 更新私人相对人
     *
     * @param busRelativePersonPrivateVo
     * @return
     * @throws CustomerException
     */
    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int updatePrivate(BusRelativePersonPrivateUpdateVo busRelativePersonPrivateVo) throws CustomerException {
        try {
            BusRelativePersonVo busRelativePerson = new BusRelativePersonVo();
            busRelativePerson.setReportId(busRelativePersonPrivateVo.getReportId());
            busRelativePerson.setIscoordinate(busRelativePersonPrivateVo.getIscoordinate());
            busRelativePerson.setReportType(busRelativePersonPrivateVo.getReportType());
            busRelativePerson.setReportPropert("1");
            busRelativePerson.setData1(busRelativePersonPrivateVo.getPersonalName());
            busRelativePerson.setData2(busRelativePersonPrivateVo.getIdCard());
            busRelativePerson.setData3(busRelativePersonPrivateVo.getPhone());
            busRelativePerson.setData4(busRelativePersonPrivateVo.getSex());
            busRelativePerson.setData5(busRelativePersonPrivateVo.getArea());
            busRelativePerson.setData6(busRelativePersonPrivateVo.getEmail());
            busRelativePerson.setData7(busRelativePersonPrivateVo.getAssets());
            busRelativePerson.setData8(busRelativePersonPrivateVo.getAssetsNumber());
            busRelativePerson.setData9(busRelativePersonPrivateVo.getCirculationAssets());
            busRelativePerson.setData10(busRelativePersonPrivateVo.getIfWork());
            busRelativePerson.setCardJust(busRelativePersonPrivateVo.getCardJust());
            busRelativePerson.setCardBack(busRelativePersonPrivateVo.getCardBack());
            busRelativePerson.setObligatRight(busRelativePersonPrivateVo.getObligatRight());
            busRelativePerson.setObligatRightNo(busRelativePersonPrivateVo.getObligatRightNo());
            busRelativePerson.setObligatTime(busRelativePersonPrivateVo.getObligatTime());
            busRelativePerson.setCapital(busRelativePersonPrivateVo.getCapital());
            busRelativePerson.setInterest(busRelativePersonPrivateVo.getInterest());
            busRelativePerson.setInterestRate(busRelativePersonPrivateVo.getInterestRate());
            busRelativePerson.setDebt(busRelativePersonPrivateVo.getDebt());
            busRelativePerson.setDebtNo(busRelativePersonPrivateVo.getDebtNo());
            busRelativePerson.setDebtTime(busRelativePersonPrivateVo.getDebtTime());
            busRelativePerson.setDebtCertificate(busRelativePersonPrivateVo.getDebtCertificate());
            busRelativePerson.setUploadDebtCertificate(busRelativePersonPrivateVo.getUploadDebtCertificate());
            busRelativePerson.setEconomics(busRelativePersonPrivateVo.getEconomics());
            busRelativePerson.setUsage(busRelativePersonPrivateVo.getUsage());
            busRelativePerson.setPrjectManager(busRelativePersonPrivateVo.getPrjectManager());
            int updateByPrimaryKeySelective = busRelativePersonDao.updateByPrimaryKeySelective(busRelativePerson);
            log.info("更新私人相对人成功,受影响行数:{}", updateByPrimaryKeySelective);
            return updateByPrimaryKeySelective;
        } catch (Exception e) {
            log.error("更新私人相对人失败,异常信息:{}", e.getMessage());
            throw new CustomerException("更新私人相对人失败");
        }
    }

    /**
     * 企业相对人
     *
     * @param busRelativePersonEnterpriseVo
     * @return
     */
    @Override
    @Transactional(noRollbackFor = Exception.class)
    public Long insertEnterprise(BusRelativePersonEnterpriseVo busRelativePersonEnterpriseVo) throws CustomerException {
        try {
            Long l = IdUtils.nextId();
            BusRelativePerson busRelativePerson = new BusRelativePerson();
            busRelativePerson.setRelativePerId(l);
            busRelativePerson.setReportId(busRelativePersonEnterpriseVo.getReportId());
            busRelativePerson.setIscoordinate(busRelativePersonEnterpriseVo.getIscoordinate());
            busRelativePerson.setReportType(busRelativePersonEnterpriseVo.getReportType());
            busRelativePerson.setReportPropert("2");
            busRelativePerson.setData1(busRelativePersonEnterpriseVo.getCompanyName());
            busRelativePerson.setData2(busRelativePersonEnterpriseVo.getCreditCode());
            busRelativePerson.setData3(busRelativePersonEnterpriseVo.getIndustryAttributes());
            busRelativePerson.setData4(busRelativePersonEnterpriseVo.getLegalName());
            busRelativePerson.setData5(busRelativePersonEnterpriseVo.getLegalPhone());
            busRelativePerson.setData6(busRelativePersonEnterpriseVo.getLegalIdCard());
            busRelativePerson.setData7(busRelativePersonEnterpriseVo.getAddress());
            busRelativePerson.setData8(busRelativePersonEnterpriseVo.getContactPerson());
            busRelativePerson.setData9(busRelativePersonEnterpriseVo.getContactPhone());
            busRelativePerson.setCardJust(busRelativePersonEnterpriseVo.getCardJust());
            busRelativePerson.setCardBack(busRelativePersonEnterpriseVo.getCardBack());
            busRelativePerson.setObligatRight(busRelativePersonEnterpriseVo.getObligatRight());
            busRelativePerson.setObligatRightNo(busRelativePersonEnterpriseVo.getObligatRightNo());
            busRelativePerson.setObligatTime(busRelativePersonEnterpriseVo.getObligatTime());
            busRelativePerson.setCapital(busRelativePersonEnterpriseVo.getCapital());
            busRelativePerson.setInterest(busRelativePersonEnterpriseVo.getInterest());
            busRelativePerson.setInterestRate(busRelativePersonEnterpriseVo.getInterestRate());
            busRelativePerson.setDebt(busRelativePersonEnterpriseVo.getDebt());
            busRelativePerson.setDebtNo(busRelativePersonEnterpriseVo.getDebtNo());
            busRelativePerson.setDebtTime(busRelativePersonEnterpriseVo.getDebtTime());
            busRelativePerson.setDebtCertificate(busRelativePersonEnterpriseVo.getDebtCertificate());
            busRelativePerson.setUploadDebtCertificate(busRelativePersonEnterpriseVo.getUploadDebtCertificate());
            busRelativePerson.setEconomics(busRelativePersonEnterpriseVo.getEconomics());
            busRelativePerson.setUsage(busRelativePersonEnterpriseVo.getUsage());
            busRelativePerson.setPrjectManager(busRelativePersonEnterpriseVo.getPrjectManager());
            busRelativePerson.setCreateTime(busRelativePersonEnterpriseVo.getCreateTime());
            busRelativePerson.setUpdateTime(busRelativePersonEnterpriseVo.getUpdateTime());
            int insertSelective = busRelativePersonDao.insertSelective(busRelativePerson);
            log.info("新增企业相对人成功,受影响行数:{}", insertSelective);
            return l;
        } catch (Exception e) {
            log.error("新增企业相对人失败,异常信息:{}", e.getMessage());
            throw new CustomerException("新增企业相对人失败");
        }
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int updateEnterprise(BusRelativePersonEnterpriseUpdateVo busRelativePersonEnterpriseVo) throws CustomerException {
        try {
            BusRelativePersonVo busRelativePerson = new BusRelativePersonVo();
            busRelativePerson.setRelativePerId(busRelativePersonEnterpriseVo.getRelativePerId());
            busRelativePerson.setReportId(busRelativePersonEnterpriseVo.getReportId());
            busRelativePerson.setIscoordinate(busRelativePersonEnterpriseVo.getIscoordinate());
            busRelativePerson.setReportType(busRelativePersonEnterpriseVo.getReportType());
            busRelativePerson.setReportPropert("2");
            busRelativePerson.setData1(busRelativePersonEnterpriseVo.getCompanyName());
            busRelativePerson.setData2(busRelativePersonEnterpriseVo.getCreditCode());
            busRelativePerson.setData3(busRelativePersonEnterpriseVo.getIndustryAttributes());
            busRelativePerson.setData4(busRelativePersonEnterpriseVo.getLegalName());
            busRelativePerson.setData5(busRelativePersonEnterpriseVo.getLegalPhone());
            busRelativePerson.setData6(busRelativePersonEnterpriseVo.getLegalIdCard());
            busRelativePerson.setData7(busRelativePersonEnterpriseVo.getAddress());
            busRelativePerson.setData8(busRelativePersonEnterpriseVo.getContactPerson());
            busRelativePerson.setData9(busRelativePersonEnterpriseVo.getContactPhone());
            busRelativePerson.setCardJust(busRelativePersonEnterpriseVo.getCardJust());
            busRelativePerson.setCardBack(busRelativePersonEnterpriseVo.getCardBack());
            busRelativePerson.setObligatRight(busRelativePersonEnterpriseVo.getObligatRight());
            busRelativePerson.setObligatRightNo(busRelativePersonEnterpriseVo.getObligatRightNo());
            busRelativePerson.setObligatTime(busRelativePersonEnterpriseVo.getObligatTime());
            busRelativePerson.setCapital(busRelativePersonEnterpriseVo.getCapital());
            busRelativePerson.setInterest(busRelativePersonEnterpriseVo.getInterest());
            busRelativePerson.setInterestRate(busRelativePersonEnterpriseVo.getInterestRate());
            busRelativePerson.setDebt(busRelativePersonEnterpriseVo.getDebt());
            busRelativePerson.setDebtNo(busRelativePersonEnterpriseVo.getDebtNo());
            busRelativePerson.setDebtTime(busRelativePersonEnterpriseVo.getDebtTime());
            busRelativePerson.setDebtCertificate(busRelativePersonEnterpriseVo.getDebtCertificate());
            busRelativePerson.setUploadDebtCertificate(busRelativePersonEnterpriseVo.getUploadDebtCertificate());
            busRelativePerson.setEconomics(busRelativePersonEnterpriseVo.getEconomics());
            busRelativePerson.setUsage(busRelativePersonEnterpriseVo.getUsage());
            busRelativePerson.setPrjectManager(busRelativePersonEnterpriseVo.getPrjectManager());
            int updateByPrimaryKeySelective = busRelativePersonDao.updateByPrimaryKeySelective(busRelativePerson);
            log.info("更新企业相对人成功,受影响行数:{}", updateByPrimaryKeySelective);
            return updateByPrimaryKeySelective;
        } catch (Exception e) {
            log.error("更新企业相对人失败,异常信息:{}", e.getMessage());
            throw new CustomerException("更新企业相对人失败");
        }
    }

    /**
     * 银行相对人
     *
     * @param busRelativePersonBankVo
     * @return
     */
    @Override
    @Transactional(noRollbackFor = Exception.class)
    public Long insertBank(BusRelativePersonBankVo busRelativePersonBankVo) throws CustomerException {
        try {
            Long l = IdUtils.nextId();
            BusRelativePerson busRelativePerson = new BusRelativePerson();
            busRelativePerson.setRelativePerId(l);
            busRelativePerson.setReportId(busRelativePersonBankVo.getReportId());
            busRelativePerson.setIscoordinate(busRelativePersonBankVo.getIscoordinate());
            busRelativePerson.setReportType(busRelativePersonBankVo.getReportType());
            busRelativePerson.setReportPropert("3");
            busRelativePerson.setData1(busRelativePersonBankVo.getCompanyName());
            busRelativePerson.setData2(busRelativePersonBankVo.getCreditCode());
            busRelativePerson.setData3(busRelativePersonBankVo.getIndustryAttributes());
            busRelativePerson.setData4(busRelativePersonBankVo.getLegalName());
            busRelativePerson.setData5(busRelativePersonBankVo.getLegalPhone());
            busRelativePerson.setData6(busRelativePersonBankVo.getLegalIdCard());
            busRelativePerson.setData7(busRelativePersonBankVo.getAddress());
            busRelativePerson.setData8(busRelativePersonBankVo.getContactPerson());
            busRelativePerson.setData9(busRelativePersonBankVo.getContactPhone());
            busRelativePerson.setObligatRight(busRelativePersonBankVo.getObligatRight());
            busRelativePerson.setObligatRightNo(busRelativePersonBankVo.getObligatRightNo());
            busRelativePerson.setObligatTime(busRelativePersonBankVo.getObligatTime());
            busRelativePerson.setCapital(busRelativePersonBankVo.getCapital());
            busRelativePerson.setInterest(busRelativePersonBankVo.getInterest());
            busRelativePerson.setInterestRate(busRelativePersonBankVo.getInterestRate());
            busRelativePerson.setDebt(busRelativePersonBankVo.getDebt());
            busRelativePerson.setDebtNo(busRelativePersonBankVo.getDebtNo());
            busRelativePerson.setDebtTime(busRelativePersonBankVo.getDebtTime());
            busRelativePerson.setDebtCertificate(busRelativePersonBankVo.getDebtCertificate());
            busRelativePerson.setUploadDebtCertificate(busRelativePersonBankVo.getUploadDebtCertificate());
            busRelativePerson.setEconomics(busRelativePersonBankVo.getEconomics());
            busRelativePerson.setUsage(busRelativePersonBankVo.getUsage());
            busRelativePerson.setPrjectManager(busRelativePersonBankVo.getPrjectManager());
            busRelativePerson.setCreateTime(busRelativePersonBankVo.getCreateTime());
            busRelativePerson.setUpdateTime(busRelativePersonBankVo.getUpdateTime());
            int insertSelective = busRelativePersonDao.insertSelective(busRelativePerson);
            log.info("新增银行相对人成功,受影响行数:{}", insertSelective);
            return l;
        } catch (Exception e) {
            log.error("新增银行相对人失败,异常信息:{}", e.getMessage());
            throw new CustomerException("新增银行相对人失败");
        }
    }

    /**
     * 银行相对人更新
     *
     * @param busRelativePersonBankVo
     * @return
     * @throws CustomerException
     */
    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int updateBank(BusRelativePersonBankUpdateVo busRelativePersonBankVo) throws CustomerException {
        try {
            BusRelativePersonVo busRelativePerson = new BusRelativePersonVo();
            busRelativePerson.setRelativePerId(busRelativePersonBankVo.getRelativePerId());
            busRelativePerson.setReportId(busRelativePersonBankVo.getReportId());
            busRelativePerson.setIscoordinate(busRelativePersonBankVo.getIscoordinate());
            busRelativePerson.setReportType(busRelativePersonBankVo.getReportType());
            busRelativePerson.setReportPropert("3");
            busRelativePerson.setData1(busRelativePersonBankVo.getCompanyName());
            busRelativePerson.setData2(busRelativePersonBankVo.getCreditCode());
            busRelativePerson.setData3(busRelativePersonBankVo.getIndustryAttributes());
            busRelativePerson.setData4(busRelativePersonBankVo.getLegalName());
            busRelativePerson.setData5(busRelativePersonBankVo.getLegalPhone());
            busRelativePerson.setData6(busRelativePersonBankVo.getLegalIdCard());
            busRelativePerson.setData7(busRelativePersonBankVo.getAddress());
            busRelativePerson.setData8(busRelativePersonBankVo.getContactPerson());
            busRelativePerson.setData9(busRelativePersonBankVo.getContactPhone());
            busRelativePerson.setObligatRight(busRelativePersonBankVo.getObligatRight());
            busRelativePerson.setObligatRightNo(busRelativePersonBankVo.getObligatRightNo());
            busRelativePerson.setObligatTime(busRelativePersonBankVo.getObligatTime());
            busRelativePerson.setCapital(busRelativePersonBankVo.getCapital());
            busRelativePerson.setInterest(busRelativePersonBankVo.getInterest());
            busRelativePerson.setInterestRate(busRelativePersonBankVo.getInterestRate());
            busRelativePerson.setDebt(busRelativePersonBankVo.getDebt());
            busRelativePerson.setDebtNo(busRelativePersonBankVo.getDebtNo());
            busRelativePerson.setDebtTime(busRelativePersonBankVo.getDebtTime());
            busRelativePerson.setDebtCertificate(busRelativePersonBankVo.getDebtCertificate());
            busRelativePerson.setUploadDebtCertificate(busRelativePersonBankVo.getUploadDebtCertificate());
            busRelativePerson.setEconomics(busRelativePersonBankVo.getEconomics());
            busRelativePerson.setUsage(busRelativePersonBankVo.getUsage());
            busRelativePerson.setPrjectManager(busRelativePersonBankVo.getPrjectManager());
            int updateByPrimaryKeySelective = busRelativePersonDao.updateByPrimaryKeySelective(busRelativePerson);
            log.info("更新银行相对人成功,受影响行数:{}", updateByPrimaryKeySelective);
            return updateByPrimaryKeySelective;
        } catch (Exception e) {
            log.error("更新银行相对人失败,异常信息:{}", e.getMessage());
            throw new CustomerException("更新银行相对人失败");
        }
    }


    /**
     * 通过报备Id查询相对人信息(并判断是否达成民事调解关系)
     *
     * @param reportId
     * @return
     */
    @Override
    public List<BusRelativePersonListVo> selectByreportId(Long reportId) throws CustomerException {
        try {
            BusReport busReport = busReportDao.selectByPrimaryKey(reportId);
            if (busReport.getReportType().equals("2")) {
                return null;
            }
            List<BusRelativePerson> busRelativePeople = busRelativePersonDao.selectByreportId(reportId);
            List<BusRelativePersonListVo> listVos = new ArrayList<>();
            for (BusRelativePerson item : busRelativePeople) {
                //判断是否符合民事调解关系
                Boolean verification = busCivilService.verification(item.getRelativePerId());
                if (verification) {
                    BusRelativePersonListVo busRelativePersonListVo = selectByPrimaryKey(item.getRelativePerId());
                    listVos.add(busRelativePersonListVo);
                }
            }
            return listVos;
        } catch (Exception e) {
            log.error("异常信息：{}", e.getMessage());
            throw new CustomerException("查询失败");
        }
    }

    @Override
    public List<BusRelativePersonListVo> selectByRepId(Long reportId) throws CustomerException {
        List<BusRelativePerson> busRelativePeople = busRelativePersonDao.selectByreportId(reportId);
        List<BusRelativePersonListVo> listVos = new ArrayList<>();
        for (BusRelativePerson item : busRelativePeople) {
            BusRelativePersonListVo busRelativePersonListVo = selectByPrimaryKey(item.getRelativePerId());
            listVos.add(busRelativePersonListVo);
        }
        return listVos;
    }


    @Override
    public ReportAndRelativePersonShow selectByRelativePerId(Long relativePerId) throws CustomerException {
        try {
            ReportAndRelativePerson reportAndRelativePerson = busRelativePersonDao.selectByRelativePerId(relativePerId);
            ReportAndRelativePersonShow show = new ReportAndRelativePersonShow();
            show.setReportId(reportAndRelativePerson.getReportId());
            show.setRelativeperId(reportAndRelativePerson.getRelativeperId());
            if (reportAndRelativePerson.getReportPropert().equals("1")) {
                show.setDebtName(reportAndRelativePerson.getData1());
                show.setDebtLegalName(reportAndRelativePerson.getData1());
                show.setDebtIdCardCode(reportAndRelativePerson.getData2());
                show.setDebtAdd(reportAndRelativePerson.getData5());
                show.setDebtPhone(reportAndRelativePerson.getData3());
            } else {
                show.setDebtName(reportAndRelativePerson.getData1());
                show.setDebtLegalName(reportAndRelativePerson.getData4());
                show.setDebtIdCardCode(reportAndRelativePerson.getData2());
                show.setDebtAdd(reportAndRelativePerson.getData7());
                show.setDebtPhone(reportAndRelativePerson.getData9());
            }
            if (reportAndRelativePerson.getBrpReport().equals("1")) {
                show.setPersonalName(reportAndRelativePerson.getBrpData1());
                show.setPersonalLegalName(reportAndRelativePerson.getBrpData1());
                show.setPersonalIdCardCode(reportAndRelativePerson.getBrpData2());
                show.setPersonalAdd(reportAndRelativePerson.getBrpData5());
                show.setPersonalPhone(reportAndRelativePerson.getBrpData3());
            } else {
                show.setPersonalName(reportAndRelativePerson.getBrpData1());
                show.setPersonalLegalName(reportAndRelativePerson.getBrpData4());
                show.setPersonalIdCardCode(reportAndRelativePerson.getBrpData2());
                show.setPersonalAdd(reportAndRelativePerson.getBrpData7());
                show.setPersonalPhone(reportAndRelativePerson.getBrpData9());
            }
            return show;
        } catch (Exception e) {
            log.error("异常信息:{}", e.getMessage());
            throw new CustomerException("查询失败");
        }

    }

    @Override
    public List<AuxiliaryDownload> selectDow(String debtName, String time) throws ParseException {
        List<AuxiliaryDownload> auxiliaryDownloads = busRelativePersonDao.selectDow(debtName, time);
        return auxiliaryDownloads;
    }

    @Override
    public List<BusRelativePersonListVo> selectByreportIdAndDebt(Long reportId) throws CustomerException {
        try {
            List<BusRelativePersonListVo> listVos = new ArrayList<>();
            List<Long> longs = busRelativePersonDao.selectByreportIdAndDebt(reportId);
            for (Long item : longs) {
                BusRelativePersonListVo busRelativePersonListVo = selectByPrimaryKey(item);
                listVos.add(busRelativePersonListVo);
            }
            return listVos;
        } catch (Exception e) {
            log.error("异常信息：{}", e.getMessage());
            throw new CustomerException("查询失败");
        }
    }

    @Override
    public List<DowLod> selectDebtDow(String debtName, String time) {
        List<DowLod> dowLods = busRelativePersonDao.selectDebtDow(debtName, time);
        for (DowLod item : dowLods) {
            if (item.getType().equals("1")) {
                item.setCroBankPhone(null);
            } else {
                item.setPriPhone(null);
            }
        }
        return dowLods;
    }


}
