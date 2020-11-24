package com.smart.bracelet.service;

import com.smart.bracelet.controller.doc.BusElectronSealController;
import com.smart.bracelet.controller.doc.BusWordConversionController;
import com.smart.bracelet.dao.assets.BusAgentSalesContractDao;
import com.smart.bracelet.dao.assets.BusAgentSalesContractModityDao;
import com.smart.bracelet.dao.debt.*;
import com.smart.bracelet.model.po.debt.BusPropert;
import com.smart.bracelet.model.po.debt.DebtModel;
import com.smart.bracelet.service.assets.BusPropertService;
import com.smart.bracelet.service.assets.CumoutProtocolService;
import com.smart.bracelet.service.debt.BusPayDetailService;
import com.smart.bracelet.service.debt.BusRelativePersonService;
import com.smart.bracelet.service.debt.BusReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
public class UserInfoServiceTest {


    @Autowired
    private BusAgentSalesContractModityDao busAgentSalesContractModityDao;

    @Autowired
    private BusReportService busReportService;

    @Autowired
    private BusReportDao busReportDao;

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

    @Autowired
    private TestDao testDao;

    @Autowired
    private BusPropertService busPropertService;




    @Test
    public void testB() throws Exception {


    }


    @Test
    public void testA() throws Exception {

        Long reportId = 8019052418102525952L;
        BusPropert busPropert = busPropertService.selectByProId(reportId);
        if(busPropert!=null){
            testDao.delBusAssessment(busPropert.getPropertId());
            testDao.delBusAssignmentAgreement(busPropert.getPropertId());
            testDao.delBusAssignmentConfirm(busPropert.getPropertId());
            testDao.delBusConfirm(busPropert.getPropertId());
            testDao.delBusAssignmentNotice(busPropert.getPropertId());
            testDao.delBusAgentSalesContract(busPropert.getPropertId());
            testDao.delBusCollectionLetter(busPropert.getPropertId());
            testDao.delCumoutProtocol(busPropert.getPropertId());
            testDao.busCompromiseAgreement(busPropert.getPropertId());
            testDao.delBusPropert(reportId);
        }
        testDao.delPubDebt(reportId);
        testDao.delBusCivil(reportId);
        testDao.delBusRelativePerson(reportId);
        testDao.delbusPayDetail(reportId);
        testDao.delBusRealAuth(reportId);
        testDao.delBusReport(reportId);
    }

}