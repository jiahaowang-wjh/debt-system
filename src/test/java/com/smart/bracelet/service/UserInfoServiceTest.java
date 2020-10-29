package com.smart.bracelet.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.smart.bracelet.controller.doc.BusElectronSealController;
import com.smart.bracelet.controller.doc.BusWordConversionController;
import com.smart.bracelet.controller.publicmethod.Formula;
import com.smart.bracelet.dao.assets.BusAgentSalesContractDao;
import com.smart.bracelet.dao.assets.BusAgentSalesContractModityDao;
import com.smart.bracelet.dao.debt.BusCivilDao;
import com.smart.bracelet.dao.debt.BusRelativePersonDao;
import com.smart.bracelet.dao.debt.PubDebtDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.debt.BusMediatePerson;
import com.smart.bracelet.model.po.debt.BusRelativePerson;
import com.smart.bracelet.model.vo.assets.BusAgentSalesContractShow;
import com.smart.bracelet.model.vo.assets.CommModiey;
import com.smart.bracelet.model.vo.assets.CommissionOnLine;
import com.smart.bracelet.model.vo.assets.FormulaVo;
import com.smart.bracelet.model.vo.debt.AuxiliaryDownload;
import com.smart.bracelet.model.vo.debt.PlanServiceInfo;
import com.smart.bracelet.model.vo.debt.ReportFee;
import com.smart.bracelet.service.assets.CumoutProtocolService;
import com.smart.bracelet.service.debt.BusPayDetailService;
import com.smart.bracelet.service.debt.BusRelativePersonService;
import com.smart.bracelet.service.debt.BusReportService;
import com.smart.bracelet.utils.BigDecimalUtil;
import com.smart.bracelet.utils.ConvertUpMoney;
import com.smart.bracelet.utils.DocUtils;
import com.smart.bracelet.utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserInfoServiceTest {


    @Autowired
    private BusAgentSalesContractModityDao busAgentSalesContractModityDao;
    @Autowired
    private BusReportService busReportDao;
    @Autowired
    private BusAgentSalesContractDao busAgentSalesContractDao;
    @Autowired
    BusRelativePersonDao busRelativePersonDao;
    @Autowired
    BusCivilDao BusCivilDao;
    @Autowired
    private PubDebtDao pubDebtDao;
    @Autowired
    BusPayDetailService busPayDetailService;
    @Autowired
    private CumoutProtocolService cumoutProtocolService;

    @Autowired
    private BusElectronSealController busElectronSealController;

    @Autowired
    private BusWordConversionController busWordConversionController;

    @Autowired
    private BusRelativePersonService busRelativePersonService;
    @Test
    public void testA() throws Exception {
        List<AuxiliaryDownload> list = busRelativePersonService.selectDow(null, null);
        for (AuxiliaryDownload item: list) {
            System.out.println(item.toString());
        }
    }

}