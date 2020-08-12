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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserInfoServiceTest {

    @Autowired
    private BusReportService busReportDao;

    @Test
    public void testA() throws CustomerException {
        PageHelper.startPage(1,10);
        List<BusReportListVo> listVos = busReportDao.queryBusReport();
        PageInfo<BusReportListVo> busReportPageInfo = new PageInfo<>(listVos);
        System.out.println(busReportPageInfo);
    }
}