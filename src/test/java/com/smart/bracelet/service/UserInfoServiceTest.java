package com.smart.bracelet.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.smart.bracelet.dao.assets.BusAgentSalesContractDao;
import com.smart.bracelet.dao.debt.BusRelativePersonDao;
import com.smart.bracelet.model.po.debt.BusRelativePerson;
import com.smart.bracelet.model.vo.assets.BusAgentSalesContractShow;
import com.smart.bracelet.model.vo.debt.AuxiliaryDownload;
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
    private BusReportService busReportDao;
    @Autowired
    private BusAgentSalesContractDao busAgentSalesContractDao;
    @Autowired
    BusRelativePersonDao busRelativePersonDao;
    //  String repNo = "TZ2020BBF000001";

    @Test
    public void testA() throws ParseException {

        String cellphone="15585458544";
        String pwd = cellphone.substring(cellphone.length() - 6);
        System.out.println(pwd);
    }

}