package com.smart.bracelet.service;

import com.smart.bracelet.service.debt.BusReportService;
import com.smart.bracelet.utils.ConvertUpMoney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserInfoServiceTest {

    @Autowired
    private BusReportService busReportDao;


  //  String repNo = "TZ2020BBF000001";

    @Test
    public void testA() {
//        String repNo ="TZ2020BBFW000001"; //RepNoUtils.createRepNo("TZ", "MSTJ", "TZ2020MSTJ000001");
//        String substring = repNo.substring(0,6);
//        String substring1 = repNo.substring(10);
//        String substring3 = substring+"FWZIXUN"+substring1;
//        System.out.println(substring1);
        ConvertUpMoney convertUpMoney = new ConvertUpMoney();

        String s = ConvertUpMoney.toChinese("1222.31");
        System.out.println(s);
    }

}