package com.smart.bracelet.service.debt.impl;

import com.smart.bracelet.dao.debt.BusRelativePersonDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusRelativePerson;
import com.smart.bracelet.model.vo.debt.*;
import com.smart.bracelet.service.debt.BusRelativePersonService;
import com.smart.bracelet.utils.IdUtils;
import io.micrometer.core.instrument.Meter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BusRelativePersonServiceImpl implements BusRelativePersonService {

    @Autowired
    private BusRelativePersonDao busRelativePersonDao;

    @Override
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


    @Override
    public BusRelativePerson selectByPrimaryKey(Long relativePerId) {
        return busRelativePersonDao.selectByPrimaryKey(relativePerId);
    }


    /**
     * 私人相对人
     *
     * @param busRelativePersonPrivateVo
     * @return
     */
    @Override
    public int insertPrivate(BusRelativePersonPrivateVo busRelativePersonPrivateVo) throws CustomerException {
        try {
            BusRelativePerson busRelativePerson = new BusRelativePerson();
            busRelativePerson.setRelativePerId(IdUtils.nextId());
            busRelativePerson.setReportId(busRelativePersonPrivateVo.getReportId());
            busRelativePerson.setIscoordinate(busRelativePersonPrivateVo.getIscoordinate());
            busRelativePerson.setReportType(busRelativePersonPrivateVo.getReportType());
            busRelativePerson.setReportPropert("1");
            busRelativePerson.setData1(busRelativePersonPrivateVo.getPersonalName());
            busRelativePerson.setData2(busRelativePersonPrivateVo.getPhone());
            busRelativePerson.setData3(busRelativePersonPrivateVo.getIdCard());
            busRelativePerson.setData4(busRelativePersonPrivateVo.getSex());
            busRelativePerson.setData5(busRelativePersonPrivateVo.getArea());
            busRelativePerson.setData6(busRelativePersonPrivateVo.getEmail());
            busRelativePerson.setData7(busRelativePersonPrivateVo.getAssets());
            busRelativePerson.setData8(busRelativePersonPrivateVo.getAssetsNumber());
            busRelativePerson.setData9(busRelativePersonPrivateVo.getCirculationAssets());
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
            busRelativePerson.setIsResult(busRelativePersonPrivateVo.getIsResult());
            busRelativePerson.setEconomics(busRelativePersonPrivateVo.getEconomics());
            busRelativePerson.setUsage(busRelativePersonPrivateVo.getUsage());
            busRelativePerson.setPrjectManager(busRelativePersonPrivateVo.getPrjectManager());
            busRelativePerson.setCreateUserId(busRelativePersonPrivateVo.getCreateUserId());
            busRelativePerson.setUpdateUserId(busRelativePersonPrivateVo.getUpdateUserId());
            busRelativePerson.setCreateTime(busRelativePersonPrivateVo.getCreateTime());
            busRelativePerson.setUpdateTime(busRelativePersonPrivateVo.getUpdateTime());
            int insertSelective = busRelativePersonDao.insertSelective(busRelativePerson);
            log.info("新增私人相对人成功,受影响行数:{}",insertSelective);
            return insertSelective;
        } catch (Exception e) {
            log.error("新增私人相对人失败,异常信息:{}",e.getMessage());
            throw new CustomerException("新增私人相对人失败");
        }
    }

    /**
     * 更新私人相对人
     * @param busRelativePersonPrivateVo
     * @return
     * @throws CustomerException
     */
    @Override
    public int updatePrivate(BusRelativePersonPrivateUpdateVo busRelativePersonPrivateVo) throws CustomerException {
        try {
            BusRelativePersonVo busRelativePerson = new BusRelativePersonVo();
            busRelativePerson.setRelativePerId(busRelativePersonPrivateVo.getRelativePerId());
            busRelativePerson.setReportId(busRelativePersonPrivateVo.getReportId());
            busRelativePerson.setIscoordinate(busRelativePersonPrivateVo.getIscoordinate());
            busRelativePerson.setReportType(busRelativePersonPrivateVo.getReportType());
            busRelativePerson.setReportPropert("1");
            busRelativePerson.setData1(busRelativePersonPrivateVo.getPersonalName());
            busRelativePerson.setData2(busRelativePersonPrivateVo.getPhone());
            busRelativePerson.setData3(busRelativePersonPrivateVo.getIdCard());
            busRelativePerson.setData4(busRelativePersonPrivateVo.getSex());
            busRelativePerson.setData5(busRelativePersonPrivateVo.getArea());
            busRelativePerson.setData6(busRelativePersonPrivateVo.getEmail());
            busRelativePerson.setData7(busRelativePersonPrivateVo.getAssets());
            busRelativePerson.setData8(busRelativePersonPrivateVo.getAssetsNumber());
            busRelativePerson.setData9(busRelativePersonPrivateVo.getCirculationAssets());
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
            busRelativePerson.setIsResult(busRelativePersonPrivateVo.getIsResult());
            busRelativePerson.setEconomics(busRelativePersonPrivateVo.getEconomics());
            busRelativePerson.setUsage(busRelativePersonPrivateVo.getUsage());
            busRelativePerson.setPrjectManager(busRelativePersonPrivateVo.getPrjectManager());
            busRelativePerson.setCreateUserId(busRelativePersonPrivateVo.getCreateUserId());
            busRelativePerson.setUpdateUserId(busRelativePersonPrivateVo.getUpdateUserId());
            int updateByPrimaryKeySelective = busRelativePersonDao.updateByPrimaryKeySelective(busRelativePerson);
            log.info("更新私人相对人成功,受影响行数:{}",updateByPrimaryKeySelective);
            return updateByPrimaryKeySelective;
        } catch (Exception e) {
            log.error("更新私人相对人失败,异常信息:{}",e.getMessage());
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
    public int insertEnterprise(BusRelativePersonEnterpriseVo busRelativePersonEnterpriseVo) throws CustomerException {
        try {
            BusRelativePerson busRelativePerson = new BusRelativePerson();
            busRelativePerson.setRelativePerId(IdUtils.nextId());
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
            busRelativePerson.setIsResult(busRelativePersonEnterpriseVo.getIsResult());
            busRelativePerson.setEconomics(busRelativePersonEnterpriseVo.getEconomics());
            busRelativePerson.setUsage(busRelativePersonEnterpriseVo.getUsage());
            busRelativePerson.setPrjectManager(busRelativePersonEnterpriseVo.getPrjectManager());
            busRelativePerson.setCreateUserId(busRelativePersonEnterpriseVo.getCreateUserId());
            busRelativePerson.setUpdateUserId(busRelativePersonEnterpriseVo.getUpdateUserId());
            busRelativePerson.setCreateTime(busRelativePersonEnterpriseVo.getCreateTime());
            busRelativePerson.setUpdateTime(busRelativePersonEnterpriseVo.getUpdateTime());
            int insertSelective = busRelativePersonDao.insertSelective(busRelativePerson);
            log.info("新增企业相对人成功,受影响行数:{}",insertSelective);
            return insertSelective;
        } catch (Exception e) {
            log.error("新增企业相对人失败,异常信息:{}",e.getMessage());
            throw new CustomerException("新增企业相对人失败");
        }
    }

    @Override
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
            busRelativePerson.setIsResult(busRelativePersonEnterpriseVo.getIsResult());
            busRelativePerson.setEconomics(busRelativePersonEnterpriseVo.getEconomics());
            busRelativePerson.setUsage(busRelativePersonEnterpriseVo.getUsage());
            busRelativePerson.setPrjectManager(busRelativePersonEnterpriseVo.getPrjectManager());
            busRelativePerson.setCreateUserId(busRelativePersonEnterpriseVo.getCreateUserId());
            busRelativePerson.setUpdateUserId(busRelativePersonEnterpriseVo.getUpdateUserId());
            int updateByPrimaryKeySelective = busRelativePersonDao.updateByPrimaryKeySelective(busRelativePerson);
            log.info("更新企业相对人成功,受影响行数:{}",updateByPrimaryKeySelective);
            return updateByPrimaryKeySelective;
        } catch (Exception e) {
            log.error("更新企业相对人失败,异常信息:{}",e.getMessage());
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
    public int insertBank(BusRelativePersonBankVo busRelativePersonBankVo) throws CustomerException {
        try {
            BusRelativePerson busRelativePerson = new BusRelativePerson();
            busRelativePerson.setRelativePerId(IdUtils.nextId());
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
            busRelativePerson.setIsResult(busRelativePersonBankVo.getIsResult());
            busRelativePerson.setEconomics(busRelativePersonBankVo.getEconomics());
            busRelativePerson.setUsage(busRelativePersonBankVo.getUsage());
            busRelativePerson.setPrjectManager(busRelativePersonBankVo.getPrjectManager());
            busRelativePerson.setCreateUserId(busRelativePersonBankVo.getCreateUserId());
            busRelativePerson.setUpdateUserId(busRelativePersonBankVo.getUpdateUserId());
            busRelativePerson.setCreateTime(busRelativePersonBankVo.getCreateTime());
            busRelativePerson.setUpdateTime(busRelativePersonBankVo.getUpdateTime());
            int insertSelective = busRelativePersonDao.insertSelective(busRelativePerson);
            log.info("新增银行相对人成功,受影响行数:{}",insertSelective);
            return insertSelective;
        } catch (Exception e) {
            log.error("新增银行相对人失败,异常信息:{}",e.getMessage());
            throw new CustomerException("新增银行相对人失败");
        }
    }

    @Override
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
            busRelativePerson.setIsResult(busRelativePersonBankVo.getIsResult());
            busRelativePerson.setEconomics(busRelativePersonBankVo.getEconomics());
            busRelativePerson.setUsage(busRelativePersonBankVo.getUsage());
            busRelativePerson.setPrjectManager(busRelativePersonBankVo.getPrjectManager());
            busRelativePerson.setCreateUserId(busRelativePersonBankVo.getCreateUserId());
            busRelativePerson.setUpdateUserId(busRelativePersonBankVo.getUpdateUserId());
            int updateByPrimaryKeySelective = busRelativePersonDao.updateByPrimaryKeySelective(busRelativePerson);
            log.info("更新银行相对人成功,受影响行数:{}",updateByPrimaryKeySelective);
            return updateByPrimaryKeySelective;
        } catch (Exception e) {
            log.error("更新银行相对人失败,异常信息:{}",e.getMessage());
            throw new CustomerException("更新银行相对人失败");
        }
    }
}
