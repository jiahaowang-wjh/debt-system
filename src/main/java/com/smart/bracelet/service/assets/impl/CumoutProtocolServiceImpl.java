package com.smart.bracelet.service.assets.impl;

import com.smart.bracelet.controller.publicmethod.Formula;
import com.smart.bracelet.dao.assets.BusAgentSalesContractModityDao;
import com.smart.bracelet.dao.assets.CumoutProtocolDao;
import com.smart.bracelet.dao.user.PubCompanyDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusAgentSalesContract;
import com.smart.bracelet.model.po.assets.BusAgentSalesContractModity;
import com.smart.bracelet.model.po.assets.CumoutProtocol;
import com.smart.bracelet.model.po.user.PubCompany;
import com.smart.bracelet.model.vo.assets.CommissionOnLine;
import com.smart.bracelet.model.vo.assets.CumoutProtocolVo;
import com.smart.bracelet.service.assets.CumoutProtocolService;
import com.smart.bracelet.utils.BigDecimalUtil;
import com.smart.bracelet.utils.ConvertUpMoney;
import com.smart.bracelet.utils.IdUtils;
import com.smart.bracelet.utils.RepNoUtils;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class CumoutProtocolServiceImpl implements CumoutProtocolService {

    @Autowired
    private CumoutProtocolDao cumoutProtocolDao;

    @Autowired
    private BusAgentSalesContractModityDao busAgentSalesContractModityDao;

    @Autowired
    private PubCompanyDao pubCompanyDao;


    @Override
    public int deleteByPrimaryKey(Long protocolId) {
        return 0;
    }

    @Override
    public Long insertSelectiveJson(String jsonData) throws CustomerException {
        try {
            JSONObject obj = new JSONObject().fromObject(jsonData);
            CumoutProtocol record = (CumoutProtocol) JSONObject.toBean(obj,CumoutProtocol.class);
            long protocolId = IdUtils.nextId();
            BusAgentSalesContractModity[] busAgentSalesContractModity = record.getBusAgentSalesContractModity();
            List<BusAgentSalesContractModity> list = new ArrayList<>();
            if (busAgentSalesContractModity != null && busAgentSalesContractModity.length != 0) {
                for (BusAgentSalesContractModity item : busAgentSalesContractModity) {
                    BusAgentSalesContractModity modity = new BusAgentSalesContractModity();
                    modity.setSalesContractModityId(IdUtils.nextId());
                    modity.setProtocolId(protocolId);
                    modity.setModityName(item.getModityName());
                    modity.setModityPlace(item.getModityPlace());
                    modity.setModitySpecificat(item.getModitySpecificat());
                    modity.setPartyaSeal(item.getPartyaSeal());
                    modity.setPartybSeal(item.getPartybSeal());
                    modity.setPartybTime(item.getPartybTime());
                    modity.setMoneyNum1(item.getMoneyNum1());
                    list.add(modity);
                }
            }
            record.setProtocolId(protocolId);
            int i = cumoutProtocolDao.insertSelective(record);
            log.info("新增委托线上代理销售合同成功，受影响行数：{}", i);
            int i1 = busAgentSalesContractModityDao.insertSelectives(list);
            log.info("新增商品寄售成功，受影响行数：{}", i1);
            return protocolId;
        } catch (Exception e) {
            log.error("新增商品寄售失败,异常信息：{}", e.getMessage());
            throw new CustomerException("新增商品寄售失败");
        }
    }

    @Override
    public Long insertSelective(CumoutProtocol record) throws CustomerException {
        try {
            long protocolId = IdUtils.nextId();
            BusAgentSalesContractModity[] busAgentSalesContractModity = record.getBusAgentSalesContractModity();
            List<BusAgentSalesContractModity> list = new ArrayList<>();
            if (busAgentSalesContractModity != null && busAgentSalesContractModity.length != 0) {
                for (BusAgentSalesContractModity item : busAgentSalesContractModity) {
                    BusAgentSalesContractModity modity = new BusAgentSalesContractModity();
                    modity.setSalesContractModityId(IdUtils.nextId());
                    modity.setProtocolId(protocolId);
                    modity.setModityName(item.getModityName());
                    modity.setModityPlace(item.getModityPlace());
                    modity.setModitySpecificat(item.getModitySpecificat());
                    modity.setPartyaSeal(item.getPartyaSeal());
                    modity.setPartybSeal(item.getPartybSeal());
                    modity.setPartybTime(item.getPartybTime());
                    modity.setMoneyNum1(item.getMoneyNum1());
                    list.add(modity);
                }
            }
            record.setProtocolId(protocolId);
            int i = cumoutProtocolDao.insertSelective(record);
            log.info("新增委托线上代理销售合同成功，受影响行数：{}", i);
            int i1 = busAgentSalesContractModityDao.insertSelectives(list);
            log.info("新增商品寄售成功，受影响行数：{}", i1);
            return protocolId;
        } catch (Exception e) {
            log.error("新增商品寄售失败,异常信息：{}", e.getMessage());
            throw new CustomerException("新增商品寄售失败");
        }
    }

    @Override
    public CumoutProtocol selectByPrimaryKey(Long protocolId) {
        CumoutProtocol cumoutProtocol = cumoutProtocolDao.selectByPrimaryKey(protocolId);
        List<BusAgentSalesContractModity> list = busAgentSalesContractModityDao.selectBySalesProtocolId(protocolId);
        BusAgentSalesContractModity[] busAgentSalesContractModities = new BusAgentSalesContractModity[list.size()];
        for (int i=0;i<list.size();i++){
            busAgentSalesContractModities[i]=list.get(i);
        }
        cumoutProtocol.setBusAgentSalesContractModity(busAgentSalesContractModities);
        return cumoutProtocol;
    }

    @Override
    public int updateByPrimaryKeySelective(String jsonData) throws CustomerException {
        try {
            JSONObject obj = new JSONObject().fromObject(jsonData);
            CumoutProtocolVo record = (CumoutProtocolVo) JSONObject.toBean(obj,CumoutProtocolVo.class);
            System.out.println(record.getContractDate());
            int i1 = busAgentSalesContractModityDao.deleteByContractId(record.getProtocolId());
            log.info("删除线上委托销售商品成功："+i1);
            int i = cumoutProtocolDao.updateByPrimaryKeySelective(record);
            log.info("更新线上委托销销售合同成功："+i);
            BusAgentSalesContractModity[] busAgentSalesContractModity = record.getBusAgentSalesContractModity();
            List<BusAgentSalesContractModity> list = new ArrayList<>();
            if (busAgentSalesContractModity != null && busAgentSalesContractModity.length != 0) {
                for (BusAgentSalesContractModity item : busAgentSalesContractModity) {
                    BusAgentSalesContractModity modity = new BusAgentSalesContractModity();
                    modity.setSalesContractModityId(IdUtils.nextId());
                    modity.setProtocolId(record.getProtocolId());
                    modity.setModityName(item.getModityName());
                    modity.setModityPlace(item.getModityPlace());
                    modity.setModitySpecificat(item.getModitySpecificat());
                    modity.setPartyaSeal(item.getPartyaSeal());
                    modity.setPartybSeal(item.getPartybSeal());
                    modity.setPartybTime(item.getPartybTime());
                    modity.setMoneyNum1(item.getMoneyNum1());
                    list.add(modity);
                }
            }
            int i2 = busAgentSalesContractModityDao.insertSelectives(list);
            log.info("新增线上委托销售商品成功："+i2);
            return 0;
        } catch (Exception e) {
            log.error("更新线上销售合同失败，异常信息：{}",e.getMessage());
            throw new CustomerException("更新线上销售合同失败");
        }
    }

    @Override
    public CommissionOnLine initialize(Long propertId, Long comId) throws ParseException, CustomerException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            PubCompany a = pubCompanyDao.selectByPrimaryKey(comId);
            CommissionOnLine initialize = cumoutProtocolDao.initialize(propertId);
            List<BusAgentSalesContractModity> list = busAgentSalesContractModityDao.selectBySalesProtocolId(initialize.getProtocolId());
            String money = "1";
            for (BusAgentSalesContractModity item : list) {
                money = BigDecimalUtil.add(item.getMoneyNum1(), money, 2);
            }
            money = BigDecimalUtil.sub(money, "1", 2);
            initialize.setAmountThisMax(ConvertUpMoney.toChinese(initialize.getAmountThis().toString()));
            initialize.setAllCommodityMoney(money);
            initialize.setBusAgentSalesContractModities(list);
            Date createTime =  null;
            if(initialize.getContractDate()==null){
                createTime = new Date();
            }else{
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
            switch (initialize.getDebtYaer()) {
                case "1":
                    String div1 = BigDecimalUtil.div(initialize.getAmountThis().toString(), "12", 2);
                    initialize.setIntegral(div1);
                    break;
                case "2":
                    String div2 = BigDecimalUtil.div(initialize.getAmountThis().toString(), "24", 2);
                    initialize.setIntegral(div2);
                    break;
                case "3":
                    String div3 = BigDecimalUtil.div(initialize.getAmountThis().toString(), "36", 2);
                    initialize.setIntegral(div3);
                    break;
            }
            if (StringUtils.isEmpty(initialize.getProtocolNo())) {
                initialize.setProtocolNo(RepNoUtils.createRepNo("SW", a.getCompanyNameMax(), cumoutProtocolDao.selectNo()));
                initialize.setContractDate(createTime);
            }
            if (initialize.getReportPropert().equals("1")) {
                initialize.setCorBankAdd(null);
                initialize.setCorBankPhone(null);
            } else {
                initialize.setPriAdd(null);
                initialize.setPriPhone(null);
            }
            return initialize;
        } catch (ParseException e) {
            throw new CustomerException("初始化失败，异常信息：{}" + e.getMessage());
        } catch (NumberFormatException e) {
            throw new CustomerException("初始化失败，异常信息：{}" + e.getMessage());
        }
    }

}
