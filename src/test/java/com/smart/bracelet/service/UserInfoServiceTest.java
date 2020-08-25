package com.smart.bracelet.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smart.bracelet.dao.debt.BusReportDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusReport;
import com.smart.bracelet.model.utilesBean.VerifyCode;
import com.smart.bracelet.model.vo.debt.BusReportListVo;
import com.smart.bracelet.service.debt.BusReportService;
import com.smart.bracelet.service.utilsService.IVerifyCodeGen;
import com.smart.bracelet.service.utilsService.impl.SimpleCharVerifyCodeGenImpl;
import com.smart.bracelet.utils.IdUtils;
import com.smart.bracelet.utils.RepNoUtils;
import javafx.scene.input.DataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

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
        String encode = new BCryptPasswordEncoder().encode("1234567");
        System.out.println(encode);
    }

}