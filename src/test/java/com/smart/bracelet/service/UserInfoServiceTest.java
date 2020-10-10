package com.smart.bracelet.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.smart.bracelet.dao.assets.BusAgentSalesContractDao;
import com.smart.bracelet.dao.assets.BusAgentSalesContractModityDao;
import com.smart.bracelet.dao.debt.BusCivilDao;
import com.smart.bracelet.dao.debt.BusRelativePersonDao;
import com.smart.bracelet.dao.debt.PubDebtDao;
import com.smart.bracelet.model.po.debt.BusMediatePerson;
import com.smart.bracelet.model.po.debt.BusRelativePerson;
import com.smart.bracelet.model.vo.assets.BusAgentSalesContractShow;
import com.smart.bracelet.model.vo.assets.CommModiey;
import com.smart.bracelet.model.vo.debt.AuxiliaryDownload;
import com.smart.bracelet.model.vo.debt.PlanServiceInfo;
import com.smart.bracelet.model.vo.debt.ReportFee;
import com.smart.bracelet.service.debt.BusPayDetailService;
import com.smart.bracelet.service.debt.BusReportService;
import com.smart.bracelet.utils.BigDecimalUtil;
import com.smart.bracelet.utils.ConvertUpMoney;
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

    @Test
    public void testA() throws ParseException {
        ReportFee reportFee = busPayDetailService.selectByRepId(7997288195058655232L, "1");
        System.out.println(reportFee);
    }

}