package com.smart.bracelet.service.debt.impl;

import com.smart.bracelet.controller.common.ComSafrvController;
import com.smart.bracelet.dao.debt.BusPayDetailDao;
import com.smart.bracelet.dao.debt.BusRealAuthDao;
import com.smart.bracelet.dao.debt.BusReportDao;
import com.smart.bracelet.dao.user.PubCompanyDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.debt.*;
import com.smart.bracelet.model.po.user.PubCompany;
import com.smart.bracelet.model.vo.debt.*;
import com.smart.bracelet.service.debt.BusReportService;
import com.smart.bracelet.utils.IdUtils;
import com.smart.bracelet.utils.RepNoUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Slf4j
public class BusReportServiceImpl implements BusReportService {

    @Autowired
    private BusReportDao busReportDao;

    @Autowired
    private BusRealAuthDao busRealAuthDao;

    @Autowired
    private PubCompanyDao pubCompanyDao;

    private ComSafrvController comSafrvController = new ComSafrvController();

    @Override
    public int deleteByPrimaryKey(Long reportId) throws CustomerException {
        try {
            int deleteByPrimaryKey = busReportDao.deleteByPrimaryKey(reportId);
            log.info("报备信息删除成功,受影响行数:{}", deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("报备信息删除失败,异常信息:{}", e.getMessage());
            throw new CustomerException("报备信息删除失败");
        }
    }

    @Override
    public BusReportListVo selectByPrimaryKey(Long reportId) throws CustomerException {

        try {
            BusReport busReport = busReportDao.selectByPrimaryKey(reportId);
            BusReportListVo busReportListVo = new BusReportListVo();
            //将工共字段先赋值
            busReportListVo.setReportId(busReport.getReportId());
            busReportListVo.setCompanyId(busReport.getCompanyId());
            busReportListVo.setReportNo(busReport.getReportNo());
            busReportListVo.setUserId(busReport.getUserId());
            busReportListVo.setIscoordinate(busReport.getIscoordinate());
            busReportListVo.setReportType(busReport.getReportType());
            busReportListVo.setReportPropert(busReport.getReportPropert());
            busReportListVo.setCardBack(busReport.getCardBack());
            busReportListVo.setObligatRight(busReport.getObligatRight());
            busReportListVo.setObligatRightNo(busReport.getObligatRightNo());
            busReportListVo.setObligatTime(busReport.getObligatTime());
            busReportListVo.setCapital(busReport.getCapital());
            busReportListVo.setInterest(busReport.getInterest());
            busReportListVo.setInterestRate(busReport.getInterestRate());
            busReportListVo.setDebt(busReport.getDebt());
            busReportListVo.setDebtNo(busReport.getDebtNo());
            busReportListVo.setDebtTime(busReport.getDebtTime());
            busReportListVo.setDebtCertificate(busReport.getDebtCertificate());
            busReportListVo.setUploadDebtCertificate(busReport.getUploadDebtCertificate());
            busReportListVo.setIsResult(busReport.getIsResult());
            busReportListVo.setEconomics(busReport.getEconomics());
            busReportListVo.setPrjectManager(busReport.getPrjectManager());
            busReportListVo.setStatus(busReport.getStatus());
            busReportListVo.setStage(busReport.getStage());
            busReportListVo.setCreateUserId(busReport.getCreateUserId());
            busReportListVo.setCreateTime(busReport.getCreateTime());
            busReportListVo.setUpdateTime(busReport.getUpdateTime());
            busReportListVo.setCardJust(busReport.getCardJust());
            busReportListVo.setCardBack(busReport.getCardBack());

            //根据性质判断属于个人还是企业或银行
            if (busReport.getReportPropert().equals("1")) {
                busReportListVo.setPersonalName(busReport.getData1());
                busReportListVo.setPhone(busReport.getData3());
                busReportListVo.setIdCard(busReport.getData2());
                busReportListVo.setSex(busReport.getData4());
                busReportListVo.setArea(busReport.getData5());
                busReportListVo.setEmail(busReport.getData6());
                busReportListVo.setAssets(busReport.getData7());
                busReportListVo.setAssetsNumber(busReport.getData8());
                busReportListVo.setCirculationAssets(busReport.getData9());
                busReportListVo.setIfWork(busReport.getData10());
            } else {
                busReportListVo.setCompanyName(busReport.getData1());
                busReportListVo.setCreditCode(busReport.getData2());
                busReportListVo.setIndustryAttributes(busReport.getData3());
                busReportListVo.setLegalName(busReport.getData4());
                busReportListVo.setLegalPhone(busReport.getData5());
                busReportListVo.setLegalIdCard(busReport.getData6());
                busReportListVo.setAddress(busReport.getData7());
                busReportListVo.setContactPerson(busReport.getData8());
                busReportListVo.setContactPhone(busReport.getData9());
            }
            return busReportListVo;
        } catch (Exception e) {
            throw new CustomerException("查询失败,请检查报备Id是否正确");
        }
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<BusReportListVo> queryBusReport() throws CustomerException {
        List<BusReport> busReports = busReportDao.queryBusReport();
        List<BusReportListVo> listVos = new ArrayList<>();
        for (BusReport item : busReports) {
            BusReportListVo busReportListVo = selectByPrimaryKey(item.getReportId());
            listVos.add(busReportListVo);
        }
        return listVos;
    }

    @Override
    public List<DateAndDays> selectDaysCount(String type, Long comId) {
        if (type.equals("1")) {
            type = null;
            comId = null;
        }
        return busReportDao.selectDaysCount(type, comId);
    }

    /**
     * 私人
     *
     * @param busPrivateReport
     * @return
     */
    @Override
    public Long insertPrivateSelective(BusPrivateReport busPrivateReport) throws CustomerException {
        BusReport busReport = new BusReport();
        BusRealAuth busRealAuth = new BusRealAuth();
        Long l = IdUtils.nextId();
        try {
            busReport.setReportId(l);
            //设置报备编号
            busReport.setReportNo(createRepNo());
            busReport.setCompanyId(busPrivateReport.getCompanyId());
            busReport.setUserId(busPrivateReport.getUserId());
            busReport.setIscoordinate(busPrivateReport.getIscoordinate());
            busReport.setReportType(busPrivateReport.getReportType());
            busReport.setReportPropert("1");
            busReport.setCardJust(busPrivateReport.getCardJust());
            busReport.setCardBack(busPrivateReport.getCardBack());
            busReport.setObligatRight(busPrivateReport.getObligatRight());
            busReport.setObligatRightNo(busPrivateReport.getObligatRightNo());
            busReport.setObligatTime(busPrivateReport.getObligatTime());
            busReport.setCapital(busPrivateReport.getCapital());
            busReport.setInterest(busPrivateReport.getInterest());
            busReport.setInterestRate(busPrivateReport.getInterestRate());
            busReport.setDebt(busPrivateReport.getDebt());
            busReport.setDebtNo(busPrivateReport.getDebtNo());
            busReport.setDebtTime(busPrivateReport.getDebtTime());
            busReport.setDebtCertificate(busPrivateReport.getDebtCertificate());
            busReport.setUploadDebtCertificate(busPrivateReport.getUploadDebtCertificate());
            busReport.setIsResult(busPrivateReport.getIsResult());
            busReport.setEconomics(busPrivateReport.getEconomics());
            busReport.setPrjectManager(busPrivateReport.getPrjectManager());
            busReport.setStatus(busPrivateReport.getStatus());
            busReport.setStage(busPrivateReport.getStage());
            busReport.setCreateUserId(busPrivateReport.getCreateUserId());
            busReport.setCreateTime(busPrivateReport.getCreateTime());
            busReport.setUpdateTime(busPrivateReport.getUpdateTime());
            busReport.setData1(busPrivateReport.getPersonalName());
            busReport.setData2(busPrivateReport.getIdCard());
            busReport.setData3(busPrivateReport.getPhone());
            busReport.setData4(busPrivateReport.getSex());
            busReport.setData5(busPrivateReport.getArea());
            busReport.setData6(busPrivateReport.getEmail());
            busReport.setData7(busPrivateReport.getAssets());
            busReport.setData8(busPrivateReport.getAssetsNumber());
            busReport.setData9(busPrivateReport.getCirculationAssets());
            busReport.setData10(busPrivateReport.getIfWork());

            busRealAuth.setRealId(IdUtils.nextId());
            busRealAuth.setReportId(l);
            busRealAuth.setAuthname(busPrivateReport.getPersonalName());
            busRealAuth.setCard(busPrivateReport.getIdCard());
            busRealAuth.setBank(busPrivateReport.getBank());
            busRealAuth.setBankCard(busPrivateReport.getBankCard());
            busRealAuth.setBankTel(busPrivateReport.getBankTel());
            busRealAuth.setTelCheck(busPrivateReport.getTelCheck());

            int insertSelective = busReportDao.insertSelective(busReport);
            log.info("新增私人报备信息成功,受影响行数:{}", insertSelective);
            int insertSelective1 = busRealAuthDao.insertSelective(busRealAuth);
            log.info("新增实名认证成功，受影响行数：{}", insertSelective1);
            return l;
        } catch (Exception e) {
            log.error("私人性质录入信息失败,异常信息:{}", e.getMessage());
            throw new CustomerException("私人性质录入信息失败");
        }
    }

    /**
     * 更新个人报备
     *
     * @param busPrivateReport
     * @return
     * @throws CustomerException
     */
    @Override
    public int updatePrivateSelective(BusPrivateReportVo busPrivateReport) throws CustomerException {
        try {
            BusReportVo busReport = new BusReportVo();
            busReport.setReportNo(busPrivateReport.getReportNo());
            busReport.setReportId(busPrivateReport.getReportId());
            busReport.setCompanyId(busPrivateReport.getCompanyId());
            busReport.setUserId(busPrivateReport.getUserId());
            busReport.setIscoordinate(busPrivateReport.getIscoordinate());
            busReport.setReportType(busPrivateReport.getReportType());
            busReport.setReportPropert(busPrivateReport.getReportPropert());
            busReport.setCardJust(busPrivateReport.getCardJust());
            busReport.setCardBack(busPrivateReport.getCardBack());
            busReport.setObligatRight(busPrivateReport.getObligatRight());
            busReport.setObligatRightNo(busPrivateReport.getObligatRightNo());
            busReport.setObligatTime(busPrivateReport.getObligatTime());
            busReport.setCapital(busPrivateReport.getCapital());
            busReport.setInterest(busPrivateReport.getInterest());
            busReport.setInterestRate(busPrivateReport.getInterestRate());
            busReport.setDebt(busPrivateReport.getDebt());
            busReport.setDebtNo(busPrivateReport.getDebtNo());
            busReport.setDebtTime(busPrivateReport.getDebtTime());
            busReport.setUploadDebtCertificate(busPrivateReport.getUploadDebtCertificate());
            busReport.setIsResult(busPrivateReport.getIsResult());
            busReport.setEconomics(busPrivateReport.getEconomics());
            busReport.setPrjectManager(busPrivateReport.getPrjectManager());
            busReport.setStatus(busPrivateReport.getStatus());
            busReport.setStage(busPrivateReport.getStage());
            busReport.setCreateUserId(busPrivateReport.getCreateUserId());
            busReport.setCreateTime(busPrivateReport.getCreateTime());
            busReport.setUpdateTime(busPrivateReport.getUpdateTime());
            busReport.setData1(busPrivateReport.getPersonalName());
            busReport.setData2(busPrivateReport.getIdCard());
            busReport.setData3(busPrivateReport.getPhone());
            busReport.setData4(busPrivateReport.getSex());
            busReport.setData5(busPrivateReport.getArea());
            busReport.setData6(busPrivateReport.getEmail());
            busReport.setData7(busPrivateReport.getAssets());
            busReport.setData8(busPrivateReport.getAssetsNumber());
            busReport.setData9(busPrivateReport.getCirculationAssets());
            busReport.setData10(busPrivateReport.getIfWork());
            int updateByPrimaryKeySelective = busReportDao.updateByPrimaryKeySelective(busReport);
            log.info("更新个人报备信息成功,受影响行数:{}", updateByPrimaryKeySelective);
            return updateByPrimaryKeySelective;
        } catch (Exception e) {
            log.error("更新个人报备信息失败,异常信息:{}", e.getMessage());
            throw new CustomerException("更新个人报备信息失败");
        }
    }

    /**
     * 企业报备
     *
     * @param busEterpriseReport
     * @return
     */
    @Override
    public Long insertEterpriseSelective(BusEterpriseReport busEterpriseReport) throws CustomerException {
        BusReport busReport = new BusReport();
        BusRealAuth busRealAuth = new BusRealAuth();
        Long l = IdUtils.nextId();
        try {
            busReport.setReportId(l);
            busReport.setReportNo(createRepNo());
            busReport.setCompanyId(busEterpriseReport.getCompanyId());
            busReport.setUserId(busEterpriseReport.getUserId());
            busReport.setIscoordinate(busEterpriseReport.getIscoordinate());
            busReport.setReportType(busEterpriseReport.getReportType());
            busReport.setReportPropert("2");
            busReport.setCardJust(busEterpriseReport.getCardJust());
            busReport.setCardBack(busEterpriseReport.getCardBack());
            busReport.setObligatRight(busEterpriseReport.getObligatRight());
            busReport.setObligatRightNo(busEterpriseReport.getObligatRightNo());
            busReport.setObligatTime(busEterpriseReport.getObligatTime());
            busReport.setCapital(busEterpriseReport.getCapital());
            busReport.setInterest(busEterpriseReport.getInterest());
            busReport.setInterestRate(busEterpriseReport.getInterestRate());
            busReport.setDebt(busEterpriseReport.getDebt());
            busReport.setDebtNo(busEterpriseReport.getDebtNo());
            busReport.setDebtTime(busEterpriseReport.getDebtTime());
            busReport.setDebtCertificate(busEterpriseReport.getDebtCertificate());
            busReport.setUploadDebtCertificate(busEterpriseReport.getUploadDebtCertificate());
            busReport.setIsResult(busEterpriseReport.getIsResult());
            busReport.setEconomics(busEterpriseReport.getEconomics());
            busReport.setPrjectManager(busEterpriseReport.getPrjectManager());
            busReport.setStatus(busEterpriseReport.getStatus());
            busReport.setStage(busEterpriseReport.getStage());
            busReport.setCreateUserId(busEterpriseReport.getCreateUserId());
            busReport.setCreateTime(busEterpriseReport.getCreateTime());
            busReport.setUpdateTime(busEterpriseReport.getUpdateTime());
            busReport.setData1(busEterpriseReport.getCompanyName());
            busReport.setData2(busEterpriseReport.getCreditCode());
            busReport.setData3(busEterpriseReport.getIndustryAttributes());
            busReport.setData4(busEterpriseReport.getLegalName());
            busReport.setData5(busEterpriseReport.getLegalPhone());
            busReport.setData6(busEterpriseReport.getLegalIdCard());
            busReport.setData7(busEterpriseReport.getAddress());
            busReport.setData8(busEterpriseReport.getContactPerson());
            busReport.setData9(busEterpriseReport.getContactPhone());

            busRealAuth.setRealId(IdUtils.nextId());
            busRealAuth.setReportId(l);
            busRealAuth.setAuthname(busEterpriseReport.getLegalName());
            busRealAuth.setCard(busEterpriseReport.getLegalIdCard());
            busRealAuth.setBank(busEterpriseReport.getBank());
            busRealAuth.setBankCard(busEterpriseReport.getBankCard());
            busRealAuth.setBankTel(busEterpriseReport.getBankTel());
            busRealAuth.setTelCheck(busEterpriseReport.getTelCheck());
            int insertSelective = busReportDao.insertSelective(busReport);
            log.info("新增企业报备信息成功,受影响行数:{}", insertSelective);
            int insertSelective1 = busRealAuthDao.insertSelective(busRealAuth);
            log.info("新增企业实名认证成功，受影响行数：{}", insertSelective1);
            return l;
        } catch (Exception e) {
            log.error("新增企业报备信息失败,异常信息:{}", e.getMessage());
            throw new CustomerException("企业性质录入信息失败");
        }
    }

    /**
     * 更新企业报备
     *
     * @param busEterpriseReport
     * @return
     * @throws CustomerException
     */
    @Override
    public int updateEterpriseSelective(BusEterpriseReportVo busEterpriseReport) throws CustomerException {
        try {
            BusReportVo busReport = new BusReportVo();
            busReport.setReportNo(busEterpriseReport.getReportNo());
            busReport.setReportId(busEterpriseReport.getReportId());
            busReport.setCompanyId(busEterpriseReport.getCompanyId());
            busReport.setUserId(busEterpriseReport.getUserId());
            busReport.setIscoordinate(busEterpriseReport.getIscoordinate());
            busReport.setReportType(busEterpriseReport.getReportType());
            busReport.setReportPropert(busEterpriseReport.getReportPropert());
            busReport.setCardJust(busEterpriseReport.getCardJust());
            busReport.setCardBack(busEterpriseReport.getCardBack());
            busReport.setObligatRight(busEterpriseReport.getObligatRight());
            busReport.setObligatRightNo(busEterpriseReport.getObligatRightNo());
            busReport.setObligatTime(busEterpriseReport.getObligatTime());
            busReport.setCapital(busEterpriseReport.getCapital());
            busReport.setInterest(busEterpriseReport.getInterest());
            busReport.setInterestRate(busEterpriseReport.getInterestRate());
            busReport.setDebt(busEterpriseReport.getDebt());
            busReport.setDebtNo(busEterpriseReport.getDebtNo());
            busReport.setDebtTime(busEterpriseReport.getDebtTime());
            busReport.setUploadDebtCertificate(busEterpriseReport.getUploadDebtCertificate());
            busReport.setIsResult(busEterpriseReport.getIsResult());
            busReport.setEconomics(busEterpriseReport.getEconomics());
            busReport.setPrjectManager(busEterpriseReport.getPrjectManager());
            busReport.setStatus(busEterpriseReport.getStatus());
            busReport.setStage(busEterpriseReport.getStage());
            busReport.setCreateUserId(busEterpriseReport.getCreateUserId());
            busReport.setCreateTime(busEterpriseReport.getCreateTime());
            busReport.setUpdateTime(busEterpriseReport.getUpdateTime());
            busReport.setData1(busEterpriseReport.getCompanyName());
            busReport.setData2(busEterpriseReport.getCreditCode());
            busReport.setData3(busEterpriseReport.getIndustryAttributes());
            busReport.setData4(busEterpriseReport.getLegalName());
            busReport.setData5(busEterpriseReport.getLegalPhone());
            busReport.setData6(busEterpriseReport.getLegalIdCard());
            busReport.setData7(busEterpriseReport.getAddress());
            busReport.setData8(busEterpriseReport.getContactPerson());
            busReport.setData9(busEterpriseReport.getContactPhone());
            int updateByPrimaryKeySelective = busReportDao.updateByPrimaryKeySelective(busReport);
            log.info("更新企业报备信息成功,受影响行数:{}", updateByPrimaryKeySelective);
            return updateByPrimaryKeySelective;
        } catch (Exception e) {
            log.error("更新企业报备信息失败,异常信息:{}", e.getMessage());
            throw new CustomerException("更新企业报备信息失败");
        }
    }

    /**
     * 银行
     *
     * @param busBankReport
     * @return
     */
    @Override
    public Long insertBankSelective(BusBankReport busBankReport) throws CustomerException {
        BusReport busReport = new BusReport();
        Long l = IdUtils.nextId();
        try {
            busReport.setReportId(l);
            busReport.setReportNo(createRepNo());
            busReport.setCompanyId(busBankReport.getCompanyId());
            busReport.setUserId(busBankReport.getUserId());
            busReport.setIscoordinate(busBankReport.getIscoordinate());
            busReport.setReportType("1");
            busReport.setReportPropert("3");
            busReport.setObligatRight(busBankReport.getObligatRight());
            busReport.setObligatRightNo(busBankReport.getObligatRightNo());
            busReport.setObligatTime(busBankReport.getObligatTime());
            busReport.setCapital(busBankReport.getCapital());
            busReport.setInterest(busBankReport.getInterest());
            busReport.setInterestRate(busBankReport.getInterestRate());
            busReport.setDebt(busBankReport.getDebt());
            busReport.setDebtNo(busBankReport.getDebtNo());
            busReport.setDebtTime(busBankReport.getDebtTime());
            busReport.setUploadDebtCertificate(busBankReport.getUploadDebtCertificate());
            busReport.setDebtCertificate(busBankReport.getDebtCertificate());
            busReport.setIsResult(busBankReport.getIsResult());
            busReport.setEconomics(busBankReport.getEconomics());
            busReport.setPrjectManager(busBankReport.getPrjectManager());
            busReport.setStatus(busBankReport.getStatus());
            busReport.setStage(busBankReport.getStage());
            busReport.setCreateUserId(busBankReport.getCreateUserId());
            busReport.setCreateTime(busBankReport.getCreateTime());
            busReport.setUpdateTime(busBankReport.getUpdateTime());
            busReport.setData1(busBankReport.getCompanyName());
            busReport.setData2(busBankReport.getCreditCode());
            busReport.setData3(busBankReport.getIndustryAttributes());
            busReport.setData4(busBankReport.getLegalName());
            busReport.setData5(busBankReport.getLegalPhone());
            busReport.setData6(busBankReport.getLegalIdCard());
            busReport.setData7(busBankReport.getAddress());
            busReport.setData8(busBankReport.getContactPerson());
            busReport.setData9(busBankReport.getContactPhone());
            int insertSelective = busReportDao.insertSelective(busReport);
            log.info("新增银行报备信息成功,受影响行数:{}", insertSelective);
            return l;
        } catch (Exception e) {
            log.error("新增银行报备信息失败,异常信息:{}", e.getMessage());
            throw new CustomerException("银行性质录入信息失败");
        }
    }

    /**
     * 更新银行报备
     *
     * @param busBankReport
     * @return
     * @throws CustomerException
     */
    @Override
    public int updateBankSelective(BusBankReportVo busBankReport) throws CustomerException {
        try {
            BusReportVo busReport = new BusReportVo();
            busReport.setReportNo(busBankReport.getReportNo());
            busReport.setReportId(busBankReport.getReportId());
            busReport.setCompanyId(busBankReport.getCompanyId());
            busReport.setUserId(busBankReport.getUserId());
            busReport.setIscoordinate(busBankReport.getIscoordinate());
            busReport.setReportType(busBankReport.getReportType());
            busReport.setReportPropert(busBankReport.getReportPropert());
            busReport.setObligatRight(busBankReport.getObligatRight());
            busReport.setObligatRightNo(busBankReport.getObligatRightNo());
            busReport.setObligatTime(busBankReport.getObligatTime());
            busReport.setCapital(busBankReport.getCapital());
            busReport.setInterest(busBankReport.getInterest());
            busReport.setInterestRate(busBankReport.getInterestRate());
            busReport.setDebt(busBankReport.getDebt());
            busReport.setDebtNo(busBankReport.getDebtNo());
            busReport.setDebtTime(busBankReport.getDebtTime());
            busReport.setUploadDebtCertificate(busBankReport.getUploadDebtCertificate());
            busReport.setIsResult(busBankReport.getIsResult());
            busReport.setEconomics(busBankReport.getEconomics());
            busReport.setPrjectManager(busBankReport.getPrjectManager());
            busReport.setStatus(busBankReport.getStatus());
            busReport.setStage(busBankReport.getStage());
            busReport.setCreateUserId(busBankReport.getCreateUserId());
            busReport.setCreateTime(busBankReport.getCreateTime());
            busReport.setUpdateTime(busBankReport.getUpdateTime());
            busReport.setData1(busBankReport.getCompanyName());
            busReport.setData2(busBankReport.getCreditCode());
            busReport.setData3(busBankReport.getIndustryAttributes());
            busReport.setData4(busBankReport.getLegalName());
            busReport.setData5(busBankReport.getLegalPhone());
            busReport.setData6(busBankReport.getLegalIdCard());
            busReport.setData7(busBankReport.getAddress());
            busReport.setData8(busBankReport.getContactPerson());
            busReport.setData9(busBankReport.getContactPhone());
            int updateByPrimaryKeySelective = busReportDao.updateByPrimaryKeySelective(busReport);
            log.info("更新银行报备信息成功,受影响行数:{}", updateByPrimaryKeySelective);
            return updateByPrimaryKeySelective;
        } catch (Exception e) {
            log.error("更新银行报备信息失败,异常信息:{}", e.getMessage());
            throw new CustomerException("更新银行报备信息失败");
        }
    }

    /**
     * 查询债事人债事链
     *
     * @param personIdCad
     * @return
     */
    @Override
    public DebtChain queryListChain(String personIdCad, Long comId, String companyType) {

        //查询债事人
        List<DebtChain> debtChainList;
        DebtChain debtChain = new DebtChain();
        if (companyType.equals("1")) {
            debtChainList = busReportDao.queryLisyDebtor(personIdCad, null, null);
        } else {
            debtChainList = busReportDao.queryLisyDebtor(personIdCad, comId, companyType);
        }

        if (org.springframework.util.StringUtils.isEmpty(debtChainList) || debtChainList.size() == 0) {
            return null;
        }
        debtChain = debtChainList.get(0);
        //查询相对人
        List<DebtChain> list = new ArrayList<>();
        list = busReportDao.queryLisyRelativePerson(personIdCad);
        if (list != null && list.size() > 0) {
            debtChain.setDebtChain(list);
            debtChain = lisyChain(debtChain, 1);
        }
        return debtChain;
    }

    /**
     * 债事链递归
     *
     * @param debtChain
     */
    public DebtChain lisyChain(DebtChain debtChain, int no) {
        List<DebtChain> list = debtChain.getDebtChain();
        for (int i = 0; i < list.size(); i++) {
            List<DebtChain> lista = new ArrayList<>();
            DebtChain debtChain1 = list.get(i);
            List<DebtChain> debtChainList;
            if (debtChain1.equals("1")) {
                debtChainList = busReportDao.queryLisyDebtor(debtChain1.getReport(), null,null);
            } else {
                debtChainList = busReportDao.queryLisyDebtor(debtChain1.getReport(), debtChain1.getCompanyId(), debtChain1.getCompanyType());
            }
            if (debtChainList != null && no < 2 && "2".equals(debtChain1.getReportType())) {
                lista = busReportDao.queryLisyRelativePerson(debtChain1.getReport());
                if (lista != null && lista.size() > 0) {
                    debtChain.getDebtChain().get(i).setDebtChain(lista);
                    debtChain1.setDebtChain(lista);
                    lisyChain(debtChain1, no + 1);
                }
            }
        }
        return debtChain;
    }

    @Override
    public int updateStatus(String status, Long reportId, String checkReason) throws CustomerException {
        try {
            int i = busReportDao.updateStatus(status, reportId, checkReason);
            log.info("更新审核状态成功,受影响行数:{}", i);
            return i;
        } catch (Exception e) {
            log.error("更新审核状态失败,异常信息:{}", e.getMessage());
            throw new CustomerException("更新审核状态失败");
        }
    }

    /**
     * 页面报备信息展示
     *
     * @return
     */
    @Override
    public List<DebtInfo> selectDebtInfos(DebtInfoQuery debtInfoQuery) {
        if (debtInfoQuery.getCompanyType().equals("1")) {
            debtInfoQuery.setCompanyType(null);
            debtInfoQuery.setComId(null);
        }
        List<DebtInfo> debtInfos = busReportDao.selectDebtInofs(debtInfoQuery);
        return debtInfos;
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int updateDebtStage(String stage, Long repId) throws CustomerException {
        try {
            int i = busReportDao.updateDebtStage(stage, repId);
            return i;
        } catch (Exception e) {
            log.error("更新失败,异常信息:{}", e.getMessage());
            throw new CustomerException("更新失败");
        }
    }


    /**
     * 编号生成方法
     *
     * @return
     */

    public String createRepNo() {
        String aLong = busReportDao.selectRepNo();
        String repNo = RepNoUtils.createRepNo("TZ", "ZSBB", aLong);
        return repNo;
    }


    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int addAgreementNo(String partyA, String partyB, Long reportId, Date agreementDate, String agreementNo) throws CustomerException {
        try {
            return busReportDao.addANO(partyA, partyB, reportId, agreementDate, agreementNo);
        } catch (Exception e) {
            log.error("异常信息:{}", e.getMessage());
            throw new CustomerException("新增失败");
        }
    }

    /**
     * 暨尽协议下载
     *
     * @param reportId
     * @return
     */
    @Override
    public CumOutInfo selectJiJin(Long reportId) {
        return busReportDao.selectJiJin(reportId);
    }
}
