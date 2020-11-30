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
        Long[] res = {8018007230683873280L, 8018012226129297408L, 8018019427262726144L, 8018021924983341056L, 8018023999096029184L, 8018026172664053760L
                , 8018043384703418368L, 8018059807462981632L, 8018061626574569472L, 8019048242362515456L, 8019050374813777920L, 8019051424199278592L
        };
        for (Long item : res) {
            List<BusPropert> busPropert = busPropertService.selectByProId(item);
            for (BusPropert item1: busPropert) {
                testDao.delBusAssessment(item1.getPropertId());
                testDao.delBusAssignmentAgreement(item1.getPropertId());
                testDao.delBusAssignmentConfirm(item1.getPropertId());
                testDao.delBusConfirm(item1.getPropertId());
                testDao.delBusAssignmentNotice(item1.getPropertId());
                testDao.delBusAgentSalesContract(item1.getPropertId());
                testDao.delBusCollectionLetter(item1.getPropertId());
                testDao.delCumoutProtocol(item1.getPropertId());
                testDao.busCompromiseAgreement(item1.getPropertId());
            }
            testDao.delBusPropert(item);
            testDao.delPubDebt(item);
            testDao.delBusCivil(item);
            testDao.delBusRelativePerson(item);
            testDao.delbusPayDetail(item);
            testDao.delBusRealAuth(item);
            testDao.delBusReport(item);
        }
    }

}