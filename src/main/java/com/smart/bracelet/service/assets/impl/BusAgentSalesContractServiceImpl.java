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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
            System.out.println(record.getAnnex());
            long l = IdUtils.nextId();
            String a = busAgentSalesContractDao.selectNo();
            record.setSalesContractId(l);
            record.setSalesNo(RepNoUtils.createRepNo("TZ", "DLXS", a));
            busAgentSalesContractDao.insertSelective(record);
            log.info("新增委托合同成功");
            BusAgentSalesContractModity[] busAgentSalesContractModity2 = record.getBusAgentSalesContractModity();
            List<BusAgentSalesContractModity> list = new ArrayList<>();
            for (BusAgentSalesContractModity busAgentSalesContractModity: busAgentSalesContractModity2) {
                BusAgentSalesContractModity busAgentSalesContractModity1 = new BusAgentSalesContractModity();
                busAgentSalesContractModity1.setSalesContractModityId(IdUtils.nextId());
                busAgentSalesContractModity1.setSalesContractId(l);
                busAgentSalesContractModity1.setModityName(busAgentSalesContractModity.getModityName());
                busAgentSalesContractModity1.setModityPlace(busAgentSalesContractModity.getModityPlace());
                busAgentSalesContractModity1.setModitySpecificat(busAgentSalesContractModity.getModitySpecificat());
                busAgentSalesContractModity1.setPartyaSeal(busAgentSalesContractModity.getPartyaSeal());
                busAgentSalesContractModity1.setPartyaTime(busAgentSalesContractModity.getPartyaTime());
                busAgentSalesContractModity1.setPartyaSeal(busAgentSalesContractModity.getPartyaSeal());
                busAgentSalesContractModity1.setPartybSeal(busAgentSalesContractModity.getPartybSeal());
                busAgentSalesContractModity1.setPartybTime(busAgentSalesContractModity.getPartybTime());
                list.add(busAgentSalesContractModity1);
            }
            int i = busAgentSalesContractModityDao.insertSelectives(list);
            log.info("新增委托合同商品成功,受影响行数：{}",i);
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
