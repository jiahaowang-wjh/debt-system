package com.smart.bracelet.service;

import com.smart.bracelet.dao.assets.BusAgentSalesContractDao;
import com.smart.bracelet.model.vo.assets.BusAgentSalesContractShow;
import com.smart.bracelet.service.debt.BusReportService;
import com.smart.bracelet.utils.ConvertUpMoney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserInfoServiceTest {

    @Autowired
    private BusReportService busReportDao;
    @Autowired
    private BusAgentSalesContractDao busAgentSalesContractDao;

  //  String repNo = "TZ2020BBF000001";

    @Test
    public void testA() throws ParseException {
//        String repNo ="TZ2020BBFW000001"; //RepNoUtils.createRepNo("TZ", "MSTJ", "TZ2020MSTJ000001");
//        String substring = repNo.substring(0,6);
//        String substring1 = repNo.substring(10);
//        String substring3 = substring+"FWZIXUN"+substring1;
//        System.out.println(substring1);

//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//        String str="2011-08-23";
//        Date dt=sdf.parse(str);
//        Calendar rightNow = Calendar.getInstance();
//        rightNow.setTime(dt);
//        rightNow.add(Calendar.YEAR,+1);//日期减1年
//        Date date = rightNow.getTime();
//        String format = sdf.format(date);
//        System.out.println(format);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        BusAgentSalesContractShow initialize = busAgentSalesContractDao.initialize(798648698420856422L);
        String format1 = simpleDateFormat.format(initialize.getCreateTime());
        System.out.println(format1);
    }

}