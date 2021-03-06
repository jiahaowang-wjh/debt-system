package com.smart.bracelet.service.assets.impl;

import com.smart.bracelet.controller.publicmethod.Formula;
import com.smart.bracelet.dao.assets.BusAgentSalesContractDao;
import com.smart.bracelet.dao.assets.BusAgentSalesContractModityDao;
import com.smart.bracelet.dao.assets.BusPropertDao;
import com.smart.bracelet.dao.debt.BusRealAuthDao;
import com.smart.bracelet.dao.debt.PubDebtDao;
import com.smart.bracelet.dao.user.PubCompanyDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusAgentSalesContract;
import com.smart.bracelet.model.po.assets.BusAgentSalesContractModity;
import com.smart.bracelet.model.po.debt.BusPropert;
import com.smart.bracelet.model.po.debt.PubDebt;
import com.smart.bracelet.model.po.user.PubCompany;
import com.smart.bracelet.model.vo.assets.BusAgentSalesContractShow;
import com.smart.bracelet.model.vo.assets.BusAgentSalesContractVo;
import com.smart.bracelet.model.vo.assets.FormulaVo;
import com.smart.bracelet.service.assets.BusAgentSalesContractService;
import com.smart.bracelet.utils.BigDecimalUtil;
import com.smart.bracelet.utils.ConvertUpMoney;
import com.smart.bracelet.utils.IdUtils;
import com.smart.bracelet.utils.RepNoUtils;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private PubCompanyDao pubCompanyDao;

    @Autowired
    private BusPropertDao busPropertDao;

    @Override
    @Transactional(noRollbackFor = Exception.class)
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
    @Transactional(rollbackFor = CustomerException.class)
    public Long insertSelectiveJson(String jsonData) throws CustomerException {
        try {
            JSONObject obj = new JSONObject().fromObject(jsonData);
            BusAgentSalesContract record = (BusAgentSalesContract) JSONObject.toBean(obj, BusAgentSalesContract.class);
            long l = IdUtils.nextId();
            record.setSalesContractId(l);
            busAgentSalesContractDao.insertSelective(record);
            log.info("新增委托合同成功");
            BusAgentSalesContractModity[] busAgentSalesContractModity = record.getBusAgentSalesContractModity();
            List<BusAgentSalesContractModity> list = new ArrayList<>();
            if (busAgentSalesContractModity != null && busAgentSalesContractModity.length != 0) {
                for (BusAgentSalesContractModity item : busAgentSalesContractModity) {
                    BusAgentSalesContractModity modity = new BusAgentSalesContractModity();
                    modity.setSalesContractModityId(IdUtils.nextId());
                    modity.setSalesContractId(l);
                    modity.setModityPlace(item.getModityPlace());
                    modity.setModityName(item.getModityName());
                    modity.setModitySpecificat(item.getModitySpecificat());
                    modity.setPartyaSeal(item.getPartyaSeal());
                    modity.setPartybSeal(item.getPartybSeal());
                    modity.setPartybTime(item.getPartybTime());
                    modity.setMoneyNum1(item.getMoneyNum1());
                    list.add(modity);
                }
                int i = busAgentSalesContractModityDao.insertSelectives(list);
                log.info("新增委托合同商品成功,受影响行数：{}", i);
            }
            return l;
        } catch (Exception e) {
            log.error("新增失败,异常信息:{}", e.getMessage());
            throw new CustomerException("新增失败");
        }
    }

    @Override
    public Long insertSelective(BusAgentSalesContract record) throws CustomerException {
        try {
            long l = IdUtils.nextId();
            record.setSalesContractId(l);
            busAgentSalesContractDao.insertSelective(record);
            log.info("新增委托合同成功");
            BusAgentSalesContractModity[] busAgentSalesContractModity = record.getBusAgentSalesContractModity();
            List<BusAgentSalesContractModity> list = new ArrayList<>();
            if (busAgentSalesContractModity != null && busAgentSalesContractModity.length != 0) {
                for (BusAgentSalesContractModity item : busAgentSalesContractModity) {
                    BusAgentSalesContractModity modity = new BusAgentSalesContractModity();
                    modity.setSalesContractModityId(IdUtils.nextId());
                    modity.setSalesContractId(l);
                    modity.setModityPlace(item.getModityPlace());
                    modity.setModityName(item.getModityName());
                    modity.setModitySpecificat(item.getModitySpecificat());
                    modity.setPartyaSeal(item.getPartyaSeal());
                    modity.setPartybSeal(item.getPartybSeal());
                    modity.setPartybTime(item.getPartybTime());
                    modity.setMoneyNum1(item.getMoneyNum1());
                    list.add(modity);
                }
                int i = busAgentSalesContractModityDao.insertSelectives(list);
                log.info("新增委托合同商品成功,受影响行数：{}", i);
            }
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
    @Transactional(noRollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(String jsonData) throws CustomerException {
        try {
            JSONObject obj = new JSONObject().fromObject(jsonData);
            BusAgentSalesContractVo record = (BusAgentSalesContractVo) JSONObject.toBean(obj, BusAgentSalesContractVo.class);
            int i = busAgentSalesContractModityDao.deleteBySaId(record.getSalesContractId());
            log.info("删除商品信息成功：" + i);
            int i1 = busAgentSalesContractDao.updateByPrimaryKeySelective(record);
            log.info("更新线上委托代理销售合同成功：" + i1);
            BusAgentSalesContractModity[] busAgentSalesContractModity = record.getBusAgentSalesContractModity();
            List<BusAgentSalesContractModity> list = new ArrayList<>();
            if (busAgentSalesContractModity != null && busAgentSalesContractModity.length != 0) {
                for (BusAgentSalesContractModity item : busAgentSalesContractModity) {
                    BusAgentSalesContractModity modity = new BusAgentSalesContractModity();
                    modity.setSalesContractModityId(IdUtils.nextId());
                    modity.setSalesContractId(record.getSalesContractId());
                    modity.setModityPlace(item.getModityPlace());
                    modity.setModityName(item.getModityName());
                    modity.setModitySpecificat(item.getModitySpecificat());
                    modity.setPartyaSeal(item.getPartyaSeal());
                    modity.setPartybSeal(item.getPartybSeal());
                    modity.setPartybTime(item.getPartybTime());
                    modity.setMoneyNum1(item.getMoneyNum1());
                    list.add(modity);
                }
                int i3 = busAgentSalesContractModityDao.insertSelectives(list);
                log.info("新增委托合同商品成功,受影响行数：{}", i3);
            }
            return i1;
        } catch (Exception e) {
            log.error("更新失败,异常信息:{}", e.getMessage());
            throw new CustomerException("更新失败");
        }
    }

    @Override
    public BusAgentSalesContractShow initialize(Long propertId, Long comId) throws CustomerException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            BusPropert busPropert = busPropertDao.selectByPrimaryKey(propertId);
            PubDebt pubDebt = pubDebtDao.selectByPrimaryKey(busPropert.getDebtId());
            Formula formula = new Formula();
            if (pubDebt.getDebtType().equals("1") || pubDebt.getDebtType().equals("2")) {
                pubDebt.setDebtType("2");
            }
            if (pubDebt.getDebtType().equals("3")) {
                pubDebt.setDebtType("1");
            }
            FormulaVo calculation = formula.Calculation(pubDebt.getDebtType(), Integer.parseInt(pubDebt.getDebtYaer()), pubDebt.getAmountThis());
            BusAgentSalesContractShow initialize = busAgentSalesContractDao.initialize(propertId);
            Date createTime =null;
            if(initialize.getContractDate()==null){
                createTime   = new Date();
            }else {
                createTime = initialize.getContractDate();
            }
            initialize.setCreateTime(createTime);
            String format1 = simpleDateFormat.format(createTime);
            Date parse = simpleDateFormat.parse(format1);
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(parse);
            rightNow.add(Calendar.YEAR, +Integer.parseInt(initialize.getDebtYaer()));
            Date date = rightNow.getTime();
            String format = simpleDateFormat.format(date);
            initialize.setEndTime(format);
            initialize.setAverageMoney(calculation.getAverage());
            initialize.setAmountThisMax(ConvertUpMoney.toChinese(initialize.getAmountThis().toString()));
            List<BusAgentSalesContractModity> list = busAgentSalesContractModityDao.selectBySalesContractId(initialize.getSalesContractId());
            String money = "1";
            for (BusAgentSalesContractModity item : list) {
                money = BigDecimalUtil.add(item.getMoneyNum1(), money, 2);
            }
            money = BigDecimalUtil.sub(money, "1", 2);
            initialize.setAllCommodityMoney(money);
            initialize.setBusAgentSalesContractModity(list);
            if (StringUtils.isEmpty(initialize.getSalesNo())) {
                PubCompany pubCompany = pubCompanyDao.selectByPrimaryKey(comId);
                String a = busAgentSalesContractDao.selectNo();
                initialize.setSalesNo(RepNoUtils.createRepNo("FB", pubCompany.getCompanyNameMax(), a));
                initialize.setContractDate(parse);
            }
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
