package com.smart.bracelet.service.assets.impl;

import com.smart.bracelet.controller.publicmethod.Formula;
import com.smart.bracelet.dao.assets.BusAgentSalesContractDao;
import com.smart.bracelet.dao.assets.BusAgentSalesContractModityDao;
import com.smart.bracelet.dao.debt.PubDebtDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusAgentSalesContract;
import com.smart.bracelet.model.po.assets.BusAgentSalesContractModity;
import com.smart.bracelet.model.po.debt.PubDebt;
import com.smart.bracelet.model.vo.assets.BusAgentSalesContractShow;
import com.smart.bracelet.model.vo.assets.BusAgentSalesContractVo;
import com.smart.bracelet.model.vo.assets.FormulaVo;
import com.smart.bracelet.service.assets.BusAgentSalesContractService;
import com.smart.bracelet.utils.ConvertUpMoney;
import com.smart.bracelet.utils.IdUtils;
import com.smart.bracelet.utils.RepNoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
@Slf4j
public class BusAgentSalesContractServiceImpl implements BusAgentSalesContractService {

    @Autowired
    private BusAgentSalesContractDao busAgentSalesContractDao;

    @Autowired
    private BusAgentSalesContractModityDao busAgentSalesContractModityDao;

    @Autowired
    private PubDebtDao pubDebtDao;

    @Override
    public int deleteByPrimaryKey(Long salesContractId) throws CustomerException {
        try {
            int i = busAgentSalesContractDao.deleteByPrimaryKey(salesContractId);
            return i;
        } catch (Exception e) {
            log.error("删除失败,异常信息:{}", e.getMessage());
            throw new CustomerException("删除失败");
        }
    }

    @Override
    public Long insertSelective(BusAgentSalesContract record) throws CustomerException {
        try {
            long l = IdUtils.nextId();
            String a = busAgentSalesContractDao.selectNo();
            record.setSalesContractId(l);
            record.setSalesNo(RepNoUtils.createRepNo("TZ", "DLXS", a));
            busAgentSalesContractDao.insertSelective(record);
            log.info("新增委托合同成功");
            BusAgentSalesContractModity busAgentSalesContractModity = new BusAgentSalesContractModity();
            busAgentSalesContractModity.setSalesContractModityId(IdUtils.nextId());
            busAgentSalesContractModity.setSalesContractId(l);
            busAgentSalesContractModity.setModityName(record.getModityName());
            busAgentSalesContractModity.setModityPlace(record.getModityPlace());
            busAgentSalesContractModity.setModitySpecificat(record.getModitySpecificat());
            busAgentSalesContractModity.setPartyaSeal(record.getPartyaSeal1());
            busAgentSalesContractModity.setPartyaTime(record.getPartyaTime1());
            busAgentSalesContractModity.setPartyaSeal(record.getPartyaSeal1());
            busAgentSalesContractModity.setPartybSeal(record.getPartybSeal1());
            busAgentSalesContractModity.setPartybTime(record.getPartybTime1());
            busAgentSalesContractModityDao.insertSelective(busAgentSalesContractModity);
            log.info("新增委托合同商品成功");
            return l;
        } catch (Exception e) {
            log.error("新增失败,异常信息:{}", e.getMessage());
            throw new CustomerException("新增失败");
        }
    }

    @Override
    public BusAgentSalesContract selectByPrimaryKey(Long salesContractId) {
        return busAgentSalesContractDao.selectByPrimaryKey(salesContractId);
    }

    @Override
    public int updateByPrimaryKeySelective(BusAgentSalesContractVo record) throws CustomerException {
        try {
            return busAgentSalesContractDao.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            log.error("更新失败,异常信息:{}", e.getMessage());
            throw new CustomerException("更新失败");
        }
    }

    @Override
    public BusAgentSalesContractShow initialize(Long relativePerId) throws CustomerException {


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            PubDebt pubDebt = pubDebtDao.selectByRelativePerId(relativePerId);
            Formula formula = new Formula();
            FormulaVo calculation = formula.Calculation(pubDebt.getDebtType(),Integer.parseInt(pubDebt.getDebtYaer()),pubDebt.getAmountThis());
            BusAgentSalesContractShow initialize = busAgentSalesContractDao.initialize(relativePerId);
            Date createTime = initialize.getCreateTime();
            String format1 = simpleDateFormat.format(createTime);
            Date parse = simpleDateFormat.parse(format1);
            initialize.setAverageMoney(calculation.getAverage());
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(parse);
            rightNow.add(Calendar.YEAR, +Integer.parseInt(initialize.getDebtYaer()));
            Date date = rightNow.getTime();
            String format = simpleDateFormat.format(date);
            initialize.setEndTime(format);
            initialize.setAmountThisMax(ConvertUpMoney.toChinese(initialize.getAmountThis().toString()));
            if (initialize.getReportPropert().equals("1")) {
                initialize.setCorBankPhone("NULL");
                initialize.setCorBankAdd("NULL");
            } else {
                initialize.setPriPhone("NULL");
                initialize.setPriAdd("NULL");
            }
            return initialize;
        } catch (Exception e) {
            log.error("异常信息:{}", e.getMessage());
            throw new CustomerException("初始化失败");
        }
    }

    @Override
    public BusAgentSalesContract selectByPropertId(Long propertId) {
        return busAgentSalesContractDao.selectByPropertId(propertId);
    }
}
