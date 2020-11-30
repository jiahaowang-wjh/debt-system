package com.smart.bracelet.service.doc.impl;

import com.smart.bracelet.controller.doc.BusElectronSealController;
import com.smart.bracelet.dao.assets.BusConfirmDao;
import com.smart.bracelet.dao.user.PubDocDao;
import com.smart.bracelet.enums.*;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusAgentSalesContract;
import com.smart.bracelet.model.po.assets.BusAgentSalesContractModity;
import com.smart.bracelet.model.po.assets.BusCollectionLetter;
import com.smart.bracelet.model.po.debt.BusPayDetail;
import com.smart.bracelet.model.po.debt.BusRelativePerson;
import com.smart.bracelet.model.po.doc.BusElectronSeal;
import com.smart.bracelet.model.po.user.PubDoc;
import com.smart.bracelet.model.vo.assets.*;
import com.smart.bracelet.model.vo.debt.AgreementInfoShow;
import com.smart.bracelet.model.vo.debt.PlanServiceInfo;
import com.smart.bracelet.model.vo.debt.ReportFee;
import com.smart.bracelet.service.assets.*;
import com.smart.bracelet.service.debt.BusCivilService;
import com.smart.bracelet.service.debt.BusPayDetailService;
import com.smart.bracelet.service.debt.BusRelativePersonService;
import com.smart.bracelet.service.debt.PubDebtService;
import com.smart.bracelet.service.doc.BusWordConversionService;
import com.smart.bracelet.service.user.PubDocService;
import com.smart.bracelet.utils.BigDecimalUtil;
import com.smart.bracelet.utils.ConvertUpMoney;
import com.smart.bracelet.utils.IdUtils;

import com.smart.bracelet.utils.PdfUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

/**
 * @author liuzq
 * @version 1.0
 * @date 2020/9/20
 **/
@Service
@Slf4j
public class BusWordConversionServiceImpl implements BusWordConversionService {


    @Autowired
    private PubDebtService pubDebtService;

    @Autowired
    private BusCivilService busCivilService;

    @Autowired
    private BusAssignmentAgreementService busAssignmentAgreementService;

    @Autowired
    private BusAssignmentConfirmService busAssignmentConfirmService;

    @Autowired
    private BusAssignmentNoticeService busAssignmentNoticeService;

    @Autowired
    private BusConfirmService busConfirmService;

    @Autowired
    private BusElectronSealController busElectronSealController;

    @Autowired
    private BusCollectionLetterService busCollectionLetterService;

    @Autowired
    private BusAgentSalesContractService busAgentSalesContractService;

    @Autowired
    private BusCompromiseAgreementService busCompromiseAgreementService;

    @Autowired
    private CumoutProtocolService cumoutProtocolService;

    @Autowired
    private BusPayDetailService busPayDetailService;

    @Autowired
    private PubDocDao pubDocDao;


    /**
     * 暨尽协议
     *
     * @param reportId
     * @param comId
     * @throws ParseException
     */
    @Override
    public Long fillInWordAndSaveAsSpecifyFormatCumOut(Long reportId, Long comId) throws ParseException, CustomerException {
        try {
            //设置模板读取路径
            String readPath = DocumentPath.WORD_TEMPLATE_CUMOUT.getPath() + DocumentPath.WORD_TEMPLATE_CUMOUT.getFileName();
            //设置pdf文件保存路径
            String savePath = DocumentPath.PDF_SAVE_CUMOUT.getPath() + DocumentPath.PDF_SAVE_CUMOUT.getName() + IdUtils.nextId() + ".pdf";
            AgreementInfoShow initialize = busCivilService.initialize(reportId, comId);
            Map<String, String> map = new HashMap<>(20);
            map.put(DocCumOut.DEBT_NO.getName(), initialize.getAgreementNo());
            map.put(DocCumOut.DEBT_NAME.getName(), initialize.getDebtName());
            map.put(DocCumOut.DEBT_CARD.getName(), initialize.getIdCard());
            Date contractDate = initialize.getAgreementDate();
            map.put(DocCumOut.DEBT_YEAR.getName(), String.format("%tY", contractDate));
            map.put(DocCumOut.DEBT_MOON.getName(), String.format("%tm", contractDate));
            map.put(DocCumOut.DEBT_DAY.getName(), String.format("%td", contractDate));
            PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
            //创建文档
            PubDoc pubDoc = new PubDoc();
            long nextId = IdUtils.nextId();
            pubDoc.setDocId(nextId);
            pubDoc.setContract(initialize.getAgreementNo());
            pubDoc.setDocName(DocumentPath.WORD_TEMPLATE_CUMOUT.getName());
            pubDoc.setDocPath(savePath);
            pubDoc.setReportId(initialize.getReportId());
            pubDoc.setDocType("1");
            pubDocDao.insertSelective(pubDoc);
            //创建电子章
            BusElectronSeal busElectronSeal = new BusElectronSeal();
            //信息分析暨尽调协议
            busElectronSeal.setDocType("4");
            busElectronSeal.setFilePath(savePath);
            busElectronSeal.setDocId(nextId);
            busElectronSeal.setParta(initialize.getDebtName());
            busElectronSeal.setPartaCard(initialize.getIdCard());
            if (initialize.getReportPropert().equals("1")) {
                busElectronSeal.setPartaTel(initialize.getPriPhone());
            } else {
                busElectronSeal.setPartaTel(initialize.getCorBankPhone());
            }
            busElectronSealController.addPubUser(busElectronSeal);
            return nextId;
        } catch (ParseException e) {
            throw new CustomerException("盖章失败，异常信息" + e.getMessage());
        } catch (CustomerException e) {
            throw new CustomerException("盖章失败,异常信息" + e.getMessage());
        }
    }

    /**
     * 填充Word并保存为指定格式策划服务协议
     *
     * @author liuzq
     * @date 2020/9/20
     */
    @Override
    public void fillInWordAndSaveAsSpecifyFormatPlan(Long reportId, Long comId) throws CustomerException {
        //设置模板读取路径
        String readPath = DocumentPath.WORD_TEMPLATE.getPath() + DocumentPath.WORD_TEMPLATE.getFileName();
        //设置pdf文件保存路径
        String savePath = DocumentPath.PDF_SAVE.getPath() + DocumentPath.PDF_SAVE.getName() + IdUtils.nextId() + ".pdf";
        PlanServiceInfo planServiceInfo = pubDebtService.initializePlan(reportId, comId);
        Map<String, String> map = new HashMap<>(20);
        map.put(DocReplaceEnum.DEBT_NAME.getName(), planServiceInfo.getDebtName());
        map.put(DocReplaceEnum.DEBT_NO.getName(), planServiceInfo.getServiceNo());
        map.put(DocReplaceEnum.DEBT_ID_CARD.getName(), planServiceInfo.getPersonCard());
        map.put(DocReplaceEnum.SITUATION.getName(), planServiceInfo.getMatters());
        map.put(DocReplaceEnum.AMOUNT.getName(), planServiceInfo.getAmountThis().toString());
        map.put(DocReplaceEnum.AMOUNT_IN_WORDS.getName(), planServiceInfo.getAmountThisMax());
        map.put(DocReplaceEnum.PRINCIPAL.getName(), planServiceInfo.getServicePrincipal().toString());
        map.put(DocReplaceEnum.INTEREST.getName(), planServiceInfo.getServiceInterest().toString());
        map.put(DocReplaceEnum.DEBT_AMOUNT_THIS.getName(), planServiceInfo.getThisPlanMoney());
        map.put(DocReplaceEnum.DEBT_AMOUNT_THIS_MAX.getName(), planServiceInfo.getThisPlanMoneyMax());
        Date contractDate = planServiceInfo.getContractDate();
        map.put(DocReplaceEnum.DEBT_YEAR.getName(), String.format("%tY", contractDate));
        map.put(DocReplaceEnum.DEBT_MOON.getName(), String.format("%tm", contractDate));
        map.put(DocReplaceEnum.DEBT_DAY.getName(), String.format("%td", contractDate));
        if (planServiceInfo.getReportPropert().equals("1")) {
            map.put(DocReplaceEnum.ID_CARD_ADDRESS.getName(), planServiceInfo.getPriAdd());
            map.put(DocReplaceEnum.PHONE_NUMBER.getName(), planServiceInfo.getPriPhone());
        } else {
            map.put(DocReplaceEnum.ID_CARD_ADDRESS.getName(), planServiceInfo.getCorBankAdd());
            map.put(DocReplaceEnum.PHONE_NUMBER.getName(), planServiceInfo.getCorBankPhone());
        }
        //替换模板并保存为PDF
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
        //创建文档
        PubDoc pubDoc = new PubDoc();
        long nextId = IdUtils.nextId();
        pubDoc.setDocId(nextId);
        pubDoc.setContract(planServiceInfo.getServiceNo());
        pubDoc.setDocName(DocumentPath.WORD_TEMPLATE.getName());
        pubDoc.setDocPath(savePath);
        pubDoc.setReportId(planServiceInfo.getReportId());
        pubDoc.setDocType("1");
        pubDocDao.insertSelective(pubDoc);
        //创建电子章
        BusElectronSeal busElectronSeal = new BusElectronSeal();
        //信息分析暨尽调协议
        busElectronSeal.setDocType("5");
        busElectronSeal.setFilePath(savePath);
        busElectronSeal.setDocId(nextId);
        busElectronSeal.setParta(planServiceInfo.getDebtName());
        busElectronSeal.setPartaCard(planServiceInfo.getPersonCard());
        if (planServiceInfo.getReportPropert().equals("1")) {
            busElectronSeal.setPartaTel(planServiceInfo.getPriPhone());
        } else {
            busElectronSeal.setPartaTel(planServiceInfo.getCorBankPhone());
        }
        busElectronSealController.addPubUser(busElectronSeal);
    }

    /**
     * 债权转让协议
     *
     * @param propertId
     * @param comId
     */
    @Override
    public void fillInWordAndSaveAsSpecifyFormatTransfer(Long propertId, Long comId) throws CustomerException, ParseException {
        //设置模板读取路径
        String readPath = DocumentPath.WORD_TEMPLATE_TRANSFER.getPath() + DocumentPath.WORD_TEMPLATE_TRANSFER.getFileName();
        //设置pdf文件保存路径
        String savePath = DocumentPath.PDF_SAVE_TRANSFER.getPath() + DocumentPath.PDF_SAVE_TRANSFER.getName() + IdUtils.nextId() + ".pdf";
        Map<String, String> map = new HashMap<>(20);
        BusAssignmentAgreementShow initialize = busAssignmentAgreementService.initialize(propertId, comId);
        map.put(DocEransfer.ASSNO.getName(), initialize.getAssignmentAgreementNo());
        map.put(DocEransfer.DEBT_NAME.getName(), initialize.getDebtName());
        map.put(DocEransfer.DEBT_IDCARD.getName(), initialize.getIdCard());
        log.info("{}", initialize.getDebtName() + "---" + initialize.getCorBankPhone() + "-----" + initialize.getPriPhone());
        if (initialize.getReportPropert().equals("1")) {
            map.put(DocEransfer.DEBT_ADD.getName(), initialize.getPriAdd());
            map.put(DocEransfer.DEBT_PHONE.getName(), initialize.getPriPhone());
        } else {
            map.put(DocEransfer.DEBT_ADD.getName(), initialize.getCorBankAdd());
            map.put(DocEransfer.DEBT_PHONE.getName(), initialize.getCorBankPhone());
        }
        map.put(DocEransfer.PERSON_NAME.getName(), initialize.getPersonName());
        Date obligatTime = initialize.getObligatTime();
        map.put(DocEransfer.PERSON_YARE.getName(), String.format("%tY", obligatTime));
        map.put(DocEransfer.PERSON_MOON.getName(), String.format("%tm", obligatTime));
        map.put(DocEransfer.PERSON_DAY.getName(), String.format("%td", obligatTime));
        String thisTime = initialize.getThisTime();
        map.put(DocEransfer.THIS_YAER.getName(), String.format("%tY", new SimpleDateFormat("yyyy-MM-dd").parse(thisTime)));
        map.put(DocEransfer.THIS_MOON.getName(), String.format("%tm", new SimpleDateFormat("yyyy-MM-dd").parse(thisTime)));
        map.put(DocEransfer.THIS_DAY.getName(), String.format("%td", new SimpleDateFormat("yyyy-MM-dd").parse(thisTime)));

        map.put(DocEransfer.AMOUNTTHIS.getName(), initialize.getAmountThis().toString());
        map.put(DocEransfer.SERVICE_PRIN.getName(), initialize.getServicePrincipal().toString());
        map.put(DocEransfer.SERVICE_INTST.getName(), initialize.getServiceInterest().toString());
        map.put(DocEransfer.SERVICE_MONEY.getName(), initialize.getMoney().toString());

        Date contractTime = initialize.getContractTime();
        map.put(DocEransfer.CONST_YAER.getName(), String.format("%tY", contractTime));
        map.put(DocEransfer.CONST_MOON.getName(), String.format("%tm", contractTime));
        map.put(DocEransfer.CONST_DAY.getName(), String.format("%td", contractTime));
        CommissionOnLine initialize1 = cumoutProtocolService.initialize(propertId, comId);
        BusAgentSalesContractShow initialize2 = busAgentSalesContractService.initialize(propertId, comId);
        if (initialize2.getBusAgentSalesContractModity().size() != 0) {
            //这里设置需要填充的表格行数
            List<BusAgentSalesContractModity> busAgentSalesContractModity = initialize2.getBusAgentSalesContractModity();
            int size = busAgentSalesContractModity.size();
            //表格行数默认最多10行
            for (int i = 1; i < 11; i++) {
                if (i > size) {
                    map.put("productName" + i, "");
                    map.put("model" + i, "");
                    map.put("unit" + i, "");
                    map.put("unitPrice" + i, "");
                    map.put("amount" + i, "");
                    map.put("total" + i, "");
                    map.put("remarks" + i, "");
                } else {
                    map.put("productName" + i, busAgentSalesContractModity.get(i - 1).getModityName());
                    map.put("model" + i, busAgentSalesContractModity.get(i - 1).getModitySpecificat());
                    map.put("unit" + i, busAgentSalesContractModity.get(i - 1).getPartyaSeal());
                    map.put("unitPrice" + i, busAgentSalesContractModity.get(i - 1).getModityPlace());
                    map.put("amount" + i, busAgentSalesContractModity.get(i - 1).getPartybSeal().toString());
                    map.put("total" + i, busAgentSalesContractModity.get(i - 1).getMoneyNum1());
                    map.put("remarks" + i, busAgentSalesContractModity.get(i - 1).getPartybTime());
                }

            }
            map.put("total", initialize2.getAllCommodityMoney());
        } else if (initialize1.getBusAgentSalesContractModities().size() != 0) {
            int length = initialize1.getBusAgentSalesContractModities().size();
            String total = "1";
            //表格行数默认最多10行
            for (int i = 1; i < 11; i++) {
                if (i > length) {
                    map.put("productName" + i, "");
                    map.put("model" + i, "");
                    map.put("unit" + i, "");
                    map.put("unitPrice" + i, "");
                    map.put("amount" + i, "");
                    map.put("total" + i, "");
                    map.put("remarks" + i, "");
                } else {
                    total = BigDecimalUtil.add(total, initialize1.getBusAgentSalesContractModities().get(i - 1).getMoneyNum1(), 2);
                    map.put("productName" + i, initialize1.getBusAgentSalesContractModities().get(i - 1).getModityName());
                    map.put("model" + i, initialize1.getBusAgentSalesContractModities().get(i - 1).getModitySpecificat());
                    map.put("unit" + i, initialize1.getBusAgentSalesContractModities().get(i - 1).getPartyaSeal());
                    map.put("unitPrice" + i, initialize1.getBusAgentSalesContractModities().get(i - 1).getModityPlace());
                    map.put("amount" + i, initialize1.getBusAgentSalesContractModities().get(i - 1).getPartybSeal().toString());
                    map.put("total" + i, initialize1.getBusAgentSalesContractModities().get(i - 1).getMoneyNum1());
                    map.put("remarks" + i, initialize1.getBusAgentSalesContractModities().get(i - 1).getPartybTime());
                }
            }
            map.put("total", BigDecimalUtil.sub(total, "1", 2));
        } else {
            for (int i = 1; i < 11; i++) {
                map.put("productName" + i, "");
                map.put("model" + i, "");
                map.put("unit" + i, "");
                map.put("unitPrice" + i, "");
                map.put("amount" + i, "");
                map.put("total" + i, "");
                map.put("remarks" + i, "");
                map.put("total", "");
            }
        }

        //替换模板并保存为PDF
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
        //创建文档
        PubDoc pubDoc = new PubDoc();
        long nextId = IdUtils.nextId();
        pubDoc.setDocId(nextId);
        pubDoc.setContract(initialize.getAssignmentAgreementNo());
        pubDoc.setDocName(DocumentPath.WORD_TEMPLATE_TRANSFER.getName());
        pubDoc.setDocPath(savePath);
        pubDoc.setReportId(initialize.getReportId());
        pubDoc.setDocType("2");
        pubDocDao.insertSelective(pubDoc);
        //创建电子章
        BusElectronSeal busElectronSeal = new BusElectronSeal();
        //信息分析暨尽调协议
        busElectronSeal.setDocType("6");
        busElectronSeal.setFilePath(savePath);
        busElectronSeal.setDocId(nextId);
        busElectronSeal.setParta(initialize.getDebtName());
        busElectronSeal.setPartaCard(initialize.getIdCard());
        if (initialize.getReportPropert().equals("1")) {
            busElectronSeal.setPartaTel(initialize.getPriPhone());
        } else {
            busElectronSeal.setPartaTel(initialize.getCorBankPhone());
        }
        busElectronSealController.addPubUser(busElectronSeal);
    }

    /**
     * 债权转让确认
     *
     * @param propertId
     * @throws CustomerException
     * @throws ParseException
     */
    @Override
    public void fillInWordAndSaveAsSpecifyFormatConfrim(Long propertId) throws CustomerException, ParseException {
        //设置模板读取路径
        String readPath = DocumentPath.WORD_TEMPLATE_CONFIRM.getPath() + DocumentPath.WORD_TEMPLATE_CONFIRM.getFileName();
        //设置pdf文件保存路径
        String savePath = DocumentPath.PDF_SAVE_CONFIRM.getPath() + DocumentPath.PDF_SAVE_CONFIRM.getName() + IdUtils.nextId() + ".pdf";
        BusAssignmentConfirmShow initialize = busAssignmentConfirmService.initialize(propertId);
        Map<String, String> map = new HashMap<>(20);
        map.put(DocTransferConfirm.CONFIRM_NO.getName(), initialize.getConfirmNo());
        map.put(DocTransferConfirm.DEBT_NAME.getName(), initialize.getDebtName());
        map.put(DocTransferConfirm.ASSAGR_NO.getName(), initialize.getAssignmentAgreementNo());
        Date thisTime = initialize.getThisTime();
        map.put(DocTransferConfirm.THIS_YAER.getName(), String.format("%tY", thisTime));
        map.put(DocTransferConfirm.THIS_MOON.getName(), String.format("%tm", thisTime));
        map.put(DocTransferConfirm.THIS_DAY.getName(), String.format("%td", thisTime));
        map.put(DocTransferConfirm.PERSON_NAME.getName(), initialize.getPersonName());
        map.put(DocTransferConfirm.AMOUNT_MONEY.getName(), initialize.getAmountThis().toString());
        List<String> authName = initialize.getAuthName();
        StringBuffer stringBuffer = new StringBuffer();
        for (String item : authName) {
            stringBuffer.append(item + ".");
        }
        map.put(DocTransferConfirm.AUTHNAME.getName(), stringBuffer.toString());
        Date contractTime = initialize.getContractTime();
        System.out.println(String.format("%tY", contractTime) + String.format("%tm", contractTime));
        map.put(DocTransferConfirm.CONT_THIS_YAER.getName(), String.format("%tY", contractTime));
        map.put(DocTransferConfirm.CONT_THIS_MOON.getName(), String.format("%tm", contractTime));
        map.put(DocTransferConfirm.CONT_THIS_DAY.getName(), String.format("%td", contractTime));
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
        //创建文档
        PubDoc pubDoc = new PubDoc();
        long nextId = IdUtils.nextId();
        pubDoc.setDocId(nextId);
        pubDoc.setDocType("2");
        pubDoc.setContract(initialize.getConfirmNo());
        pubDoc.setDocName(DocumentPath.WORD_TEMPLATE_CONFIRM.getName());
        pubDoc.setDocPath(savePath);
        pubDoc.setReportId(initialize.getReportId());
        pubDocDao.insertSelective(pubDoc);
        //创建电子章
        BusElectronSeal busElectronSeal = new BusElectronSeal();
        //债权转让确认
        busElectronSeal.setDocType("7");
        busElectronSeal.setFilePath(savePath);
        busElectronSeal.setDocId(nextId);
        busElectronSeal.setParta(initialize.getPersonName() + "," + initialize.getDebtName());
        busElectronSeal.setPartaCard(initialize.getPerIdCard() + "," + initialize.getDebtIdCard());
        if (initialize.getDebtPropert().equals("1")) {
            if (initialize.getPerPropert().equals("1")) {
                busElectronSeal.setPartaTel( initialize.getPerPhonePri()+ "," + initialize.getDebtPhonePri());
            } else {
                busElectronSeal.setPartaTel(initialize.getPerPhoneCor() + "," + initialize.getDebtPhonePri());
            }
        } else {
            if (initialize.getPerPropert().equals("1")) {
                busElectronSeal.setPartaTel(initialize.getPerPhonePri() + "," + initialize.getDebtPhoneCor());
            } else {
                busElectronSeal.setPartaTel(initialize.getPerPhoneCor() + "," + initialize.getDebtPhoneCor());
            }
        }
        busElectronSealController.addPubUser(busElectronSeal);
    }

    /**
     * 资产债权转让通知书
     *
     * @param propertId
     * @throws CustomerException
     * @throws ParseException
     */
    @Override
    public void fillInWordAndSaveAsSpecifyFormatNotice(Long propertId) throws CustomerException, ParseException {
        //设置模板读取路径
        String readPath = DocumentPath.WORD_TEMPLATE_NOTICE.getPath() + DocumentPath.WORD_TEMPLATE_NOTICE.getFileName();
        //设置pdf文件保存路径
        String savePath = DocumentPath.PDF_SAVE_NOTICE.getPath() + DocumentPath.PDF_SAVE_NOTICE.getName() + IdUtils.nextId() + ".pdf";
        Map<String, String> map = new HashMap<>(20);
        BusAssignmentNoticeShow initialize = busAssignmentNoticeService.initialize(propertId);
        map.put(DocNotice.NOTICE_NO.getName(), initialize.getNoticeNo());
        map.put(DocNotice.DEBT_DAME.getName(), initialize.getDebtName());
        map.put(DocNotice.PERSON_NAME.getName(), initialize.getPersonName());
        map.put(DocNotice.PERSON_IDCARD.getName(), initialize.getIdCard());
        map.put(DocNotice.NOTICE_NO.DEBT_REASON.getName(), initialize.getPersonReason());//未获取到数据来源
        map.put(DocNotice.DEBT_AUTHIS_MONEY.getName(), initialize.getAmountThis().toString());
        Date contractTime = initialize.getContractTime();
        map.put(DocNotice.CON_TIME_YAER.getName(), String.format("%tY", contractTime));
        map.put(DocNotice.CON_TIME_MOON.getName(), String.format("%tm", contractTime));
        map.put(DocNotice.CON_TIME_DAY.getName(), String.format("%td", contractTime));
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
        //创建文档
        PubDoc pubDoc = new PubDoc();
        long nextId = IdUtils.nextId();
        pubDoc.setDocId(nextId);
        pubDoc.setContract(initialize.getNoticeNo());
        pubDoc.setDocName(DocumentPath.WORD_TEMPLATE_NOTICE.getName());
        pubDoc.setDocType("2");
        pubDoc.setDocPath(savePath);
        pubDoc.setReportId(initialize.getReportId());
        pubDocDao.insertSelective(pubDoc);
        //创建电子章
        BusElectronSeal busElectronSeal = new BusElectronSeal();
        //资产债权转让通知书
        busElectronSeal.setDocType("8");
        busElectronSeal.setFilePath(savePath);
        busElectronSeal.setDocId(nextId);
        busElectronSeal.setParta(initialize.getDebtName() + "," + initialize.getPersonName());
        busElectronSeal.setPartaCard(initialize.getDebtIdCard() + "," + initialize.getIdCard());
        if (initialize.getDebtPropert().equals("1")) {
            if (initialize.getPerPropert().equals("1")) {
                busElectronSeal.setPartaTel(initialize.getDebtPhonePri() + "," + initialize.getPerPhonePri());
            } else {
                busElectronSeal.setPartaTel(initialize.getDebtPhonePri() + "," + initialize.getPerPhoneCor());
            }
        } else {
            if (initialize.getPerPropert().equals("1")) {
                busElectronSeal.setPartaTel(initialize.getDebtPhonePri() + "," + initialize.getPerPhonePri());
            } else {
                busElectronSeal.setPartaTel(initialize.getDebtPhonePri() + "," + initialize.getPerPhoneCor());
            }
        }
        busElectronSealController.addPubUser(busElectronSeal);
    }

    /**
     * 资产债权确认书
     *
     * @param propertId
     * @throws CustomerException
     * @throws ParseException
     */
    @Override
    public void fillInWordAndSaveAsSpecifyFormatProve(Long propertId) throws CustomerException, ParseException {
        //设置模板读取路径
        String readPath = DocumentPath.WORD_TEMPLATE_PROVE.getPath() + DocumentPath.WORD_TEMPLATE_PROVE.getFileName();
        //设置pdf文件保存路径
        String savePath = DocumentPath.PDF_SAVE_PROVE.getPath() + DocumentPath.PDF_SAVE_PROVE.getName() + IdUtils.nextId() + ".pdf";
        BusConfirmShow initialize = busConfirmService.initialize(propertId);
        Map<String, String> map = new HashMap<>(20);
        map.put(DocProve.CONFIRM_NO.getName(), initialize.getConfirmNo());
        map.put(DocProve.DEBT_NAME.getName(), initialize.getDebtName());
        map.put(DocProve.PERSON_NAME.getName(), initialize.getPersonName());
        map.put(DocProve.ASSAG_NO.getName(), initialize.getAssignmentAgreementNo());
        Date createTime = initialize.getCreateTime();
        map.put(DocProve.DEBT_YAER.getName(), String.format("%tY", createTime));
        map.put(DocProve.DEBT_MOON.getName(), String.format("%tm", createTime));
        map.put(DocProve.DEBT_DAY.getName(), String.format("%td", createTime));
        map.put(DocProve.THIS_MONEY.getName(), initialize.getAmountThis().toString());
        map.put(DocProve.SERVICE_BENJIN.getName(), initialize.getServicePrincipal().toString());
        map.put(DocProve.SERVICE_LIXI.getName(), initialize.getServiceInterest().toString());
        Date a = initialize.getContractTime();
        map.put(DocProve.CONT_YAER.getName(), String.format("%tY", a));
        map.put(DocProve.CONT_MOON.getName(), String.format("%tm", a));
        map.put(DocProve.CONT_DAY.getName(), String.format("%td", a));
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
        //创建文档
        PubDoc pubDoc = new PubDoc();
        long nextId = IdUtils.nextId();
        pubDoc.setDocId(nextId);
        pubDoc.setContract(initialize.getConfirmNo());
        pubDoc.setDocName(DocumentPath.WORD_TEMPLATE_PROVE.getName());
        pubDoc.setDocPath(savePath);
        pubDoc.setReportId(initialize.getReportId());
        pubDoc.setDocType("2");
        pubDocDao.insertSelective(pubDoc);
        //创建电子章
        BusElectronSeal busElectronSeal = new BusElectronSeal();
        //信息分析暨尽调协议
        busElectronSeal.setDocType("9");
        busElectronSeal.setFilePath(savePath);
        busElectronSeal.setDocId(nextId);
        busElectronSeal.setParta(initialize.getPersonName());
        busElectronSeal.setPartaCard(initialize.getPersonCard());
        if (initialize.getReportPropert().equals("1")) {
            busElectronSeal.setPartaTel(initialize.getPriPhone());
        } else {
            busElectronSeal.setPartaTel(initialize.getCorBackPhone());
        }
        busElectronSealController.addPubUser(busElectronSeal);
    }

    /**
     * 催款函
     *
     * @param propertId
     * @param comId
     * @throws CustomerException
     * @throws ParseException
     */
    @Override
    public void fillInWordAndSaveAsSpecifyFormatLetter(Long propertId, Long comId) throws CustomerException, ParseException {
        //设置模板读取路径
        String readPath = DocumentPath.WORD_TEMPLATE_LETTER.getPath() + DocumentPath.WORD_TEMPLATE_LETTER.getFileName();
        //设置pdf文件保存路径
        String savePath = DocumentPath.PDF_SAVE_LETTER.getPath() + DocumentPath.PDF_SAVE_LETTER.getName() + IdUtils.nextId() + ".pdf";
        BusCollectionLetterShow initialize = busCollectionLetterService.initialize(propertId, comId);
        Map<String, String> map = new HashMap<>(20);
        map.put(DocLetter.LETTER_NO.getName(), initialize.getCollectionLettertNo());
        map.put(DocLetter.PERSON_NAME.getName(), initialize.getPersonName());
        map.put(DocLetter.ASSAG_NO.getName(), initialize.getAssignmentAgreementNo());
        map.put(DocLetter.DEBT_NAME.getName(), initialize.getDebtName());
        map.put(DocLetter.THIS_MOEY.getName(), initialize.getAmountThis().toString());
        map.put(DocLetter.THIS_MOEY_MAX.getName(), initialize.getMoneyMax());
        Date contractDate = initialize.getContractDate();
        map.put(DocLetter.CONT_YAER.getName(), String.format("%tY", contractDate));
        map.put(DocLetter.CONT_MOON.getName(), String.format("%tm", contractDate));
        map.put(DocLetter.CONT_DAY.getName(), String.format("%td", contractDate));
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);

        //创建文档
        PubDoc pubDoc = new PubDoc();
        long nextId = IdUtils.nextId();
        pubDoc.setDocId(nextId);
        pubDoc.setContract(initialize.getCollectionLettertNo());
        pubDoc.setDocName(DocumentPath.WORD_TEMPLATE_LETTER.getName());
        pubDoc.setDocPath(savePath);
        pubDoc.setReportId(initialize.getReportId());
        pubDoc.setDocType("2");
        pubDocDao.insertSelective(pubDoc);
        //创建电子章
        BusElectronSeal busElectronSeal = new BusElectronSeal();
        //信息分析暨尽调协议
        busElectronSeal.setDocType("10");
        busElectronSeal.setFilePath(savePath);
        busElectronSeal.setDocId(nextId);
        busElectronSeal.setParta(initialize.getPersonName());
        busElectronSeal.setPartaCard(initialize.getIdCard());
        if (initialize.getReportPropert().equals("1")) {
            busElectronSeal.setPartaTel(initialize.getPriPhone());
        } else {
            busElectronSeal.setPartaTel(initialize.getCorBackPhone());
        }
        busElectronSealController.addPubUser(busElectronSeal);
    }


    /**
     * 和解协议
     *
     * @param propertId
     * @param comId
     * @throws CustomerException
     * @throws ParseException
     */
    @Override
    public void fillInWordAndSaveAsSpecifyFormatReconciliation(Long propertId, Long comId) throws CustomerException, ParseException {
        //设置模板读取路径
        String readPath = DocumentPath.WORD_TEMPLATE_RECILIATION.getPath() + DocumentPath.WORD_TEMPLATE_RECILIATION.getFileName();
        //设置pdf文件保存路径
        String savePath = DocumentPath.PDF_SAVE_RECILIATION.getPath() + DocumentPath.PDF_SAVE_RECILIATION.getName() + IdUtils.nextId() + ".pdf";
        BusCompromiseAgreementShow initialize = busCompromiseAgreementService.initialize(propertId, comId);

        Map<String, String> map = new HashMap<>(20);
        map.put(DocReconciliation.REC_NO.getName(), initialize.getCompromiseAgreementNo());
        map.put(DocReconciliation.PERSON_NAME.getName(), initialize.getPersonName());
        map.put(DocReconciliation.DEBT_NAME.getName(), initialize.getDebtName());
        map.put(DocReconciliation.THIS_MONEY.getName(), initialize.getAmountThis().toString());
        map.put(DocReconciliation.XUANZE.getName(), initialize.getPartybMode());
        map.put(DocReconciliation.AVG.getName(), initialize.getAverage());
        map.put(DocReconciliation.DEBT_DAY.getName(), initialize.getDay());
        map.put(DocReconciliation.QISHU.getName(), initialize.getNumber());
        map.put(DocReconciliation.CONT_YAER.getName(), String.format("%tY", initialize.getContractDate()));
        map.put(DocReconciliation.CONT_MOON.getName(), String.format("%tm", initialize.getContractDate()));
        map.put(DocReconciliation.CONT_DAY.getName(), String.format("%td", initialize.getContractDate()));
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
        //创建文档
        PubDoc pubDoc = new PubDoc();
        long nextId = IdUtils.nextId();
        pubDoc.setDocId(nextId);
        pubDoc.setContract(initialize.getCompromiseAgreementNo());
        pubDoc.setDocName(DocumentPath.WORD_TEMPLATE_RECILIATION.getName());
        pubDoc.setDocPath(savePath);
        pubDoc.setDocType("2");
        pubDoc.setReportId(initialize.getReportId());
        pubDocDao.insertSelective(pubDoc);
        //创建电子章
        BusElectronSeal busElectronSeal = new BusElectronSeal();
        //信息分析暨尽调协议
        busElectronSeal.setDocType("12");
        busElectronSeal.setFilePath(savePath);
        busElectronSeal.setDocId(nextId);
        busElectronSeal.setParta(initialize.getPersonName());
        busElectronSeal.setPartaCard(initialize.getIdCard());
        if (initialize.getPersonReportPropert().equals("1")) {
            busElectronSeal.setPartaTel(initialize.getPersonPriPhone());
        } else {
            busElectronSeal.setPartaTel(initialize.getPersonCorPhone());
        }
        busElectronSealController.addPubUser(busElectronSeal);
    }


    /**
     * 委托代理销售
     *
     * @param propertId
     * @param comId
     * @throws CustomerException
     * @throws ParseException
     */
    @Override
    public void fillInWordAndSaveAsSpecifyFormatConsignment(Long propertId, Long comId) throws CustomerException, ParseException {
        //设置模板读取路径
        String readPath = DocumentPath.WORD_TEMPLATE_CONSIG.getPath() + DocumentPath.WORD_TEMPLATE_CONSIG.getFileName();
        //设置pdf文件保存路径
        String savePath = DocumentPath.PDF_SAVE_CONSIG.getPath() + DocumentPath.PDF_SAVE_CONSIG.getName() + IdUtils.nextId() + ".pdf";
        BusAgentSalesContractShow initialize = busAgentSalesContractService.initialize(propertId, comId);
        Map<String, String> map = new HashMap<>(20);
        map.put(DocConsignment.CONT_NO.getName(), initialize.getSalesNo());
        map.put(DocConsignment.DEBT_NAME.getName(), initialize.getDebtName());
        map.put(DocConsignment.DEBT_CARD.getName(), initialize.getDebtIdCard());
        if (initialize.getReportPropert().equals("1")) {
            map.put(DocConsignment.DEBT_ADD.getName(), initialize.getPriAdd());
            map.put(DocConsignment.DEBT_PHONE.getName(), initialize.getPriPhone());
        } else {
            map.put(DocConsignment.DEBT_ADD.getName(), initialize.getCorBankAdd());
            map.put(DocConsignment.DEBT_PHONE.getName(), initialize.getCorBankPhone());
        }
        map.put(DocConsignment.DAIXIAO_YAER.getName(), String.format("%tY", initialize.getCreateTime()));
        map.put(DocConsignment.DAIXIAO_MOON.getName(), String.format("%tm", initialize.getCreateTime()));
        map.put(DocConsignment.DAIXIAO_DAY.getName(), String.format("%td", initialize.getCreateTime()));
        map.put(DocConsignment.DAIXIAO_JIESHU_YAER.getName(), String.format("%tY", new SimpleDateFormat("yyyy-MM-dd").parse(initialize.getEndTime())));
        map.put(DocConsignment.DAIXIAO_JIESHU_MOON.getName(), String.format("%tm", new SimpleDateFormat("yyyy-MM-dd").parse(initialize.getEndTime())));
        map.put(DocConsignment.DAIXIAO_JIESHU_DAY.getName(), String.format("%td", new SimpleDateFormat("yyyy-MM-dd").parse(initialize.getEndTime())));

        map.put(DocConsignment.THIS_MONEY.getName(), initialize.getAmountThis().toString());
        map.put(DocConsignment.THIS_MONEY_MAX.getName(), initialize.getAmountThisMax());
        map.put(DocConsignment.AVG_MONEY.getName(), initialize.getAverageMoney());
        map.put(DocConsignment.DEBT_YINHANGKAHAO.getName(), initialize.getBankCard());
        map.put(DocConsignment.DEBT_KAIHUHANG.getName(), initialize.getBank());
        map.put(DocConsignment.CONT_YAER.getName(), String.format("%tY", initialize.getContractDate()));
        map.put(DocConsignment.CONT_MOON.getName(), String.format("%tm", initialize.getContractDate()));
        map.put(DocConsignment.CONT_DAY.getName(), String.format("%td", initialize.getContractDate()));

        //这里设置需要填充的表格行数
        List<BusAgentSalesContractModity> busAgentSalesContractModity = initialize.getBusAgentSalesContractModity();
        int size = busAgentSalesContractModity.size();
        //表格行数默认最多10行
        for (int i = 1; i < 11; i++) {
            if (i > size) {
                map.put("productName" + i, "");
                map.put("model" + i, "");
                map.put("unit" + i, "");
                map.put("unitPrice" + i, "");
                map.put("amount" + i, "");
                map.put("total" + i, "");
                map.put("remarks" + i, "");
            } else {
                map.put("productName" + i, busAgentSalesContractModity.get(i - 1).getModityName());
                map.put("model" + i, busAgentSalesContractModity.get(i - 1).getModitySpecificat());
                map.put("unit" + i, busAgentSalesContractModity.get(i - 1).getPartyaSeal());
                map.put("unitPrice" + i, busAgentSalesContractModity.get(i - 1).getModityPlace());
                map.put("amount" + i, busAgentSalesContractModity.get(i - 1).getPartybSeal().toString());
                map.put("total" + i, busAgentSalesContractModity.get(i - 1).getMoneyNum1());
                map.put("remarks" + i, busAgentSalesContractModity.get(i - 1).getPartybTime());
            }
        }
        map.put("total", initialize.getAllCommodityMoney());
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
        //创建文档
        PubDoc pubDoc = new PubDoc();
        long nextId = IdUtils.nextId();
        pubDoc.setDocId(nextId);
        pubDoc.setContract(initialize.getSalesNo());
        pubDoc.setDocName(DocumentPath.WORD_TEMPLATE_CONSIG.getName());
        pubDoc.setDocPath(savePath);
        pubDoc.setReportId(initialize.getReportId());
        pubDoc.setDocType("2");
        pubDocDao.insertSelective(pubDoc);
        //创建电子章
        BusElectronSeal busElectronSeal = new BusElectronSeal();
        //信息分析暨尽调协议
        busElectronSeal.setDocType("11");
        busElectronSeal.setFilePath(savePath);
        busElectronSeal.setDocId(nextId);
        busElectronSeal.setParta(initialize.getDebtName());
        busElectronSeal.setPartaCard(initialize.getDebtIdCard());
        if (initialize.getReportPropert().equals("1")) {
            busElectronSeal.setPartaTel(initialize.getPriPhone());
        } else {
            busElectronSeal.setPartaTel(initialize.getCorBankPhone());
        }
        busElectronSealController.addPubUser(busElectronSeal);
    }

    /**
     * 线上委托销售
     *
     * @param propertId
     * @param comId
     * @throws CustomerException
     * @throws ParseException
     */
    @Override
    public void fillInWordAndSaveAsSpecifyFormatOnlineCons(Long propertId, Long comId) throws CustomerException, ParseException {
        //设置模板读取路径
        String readPath = DocumentPath.WORD_TEMPLATE_ONLINECONSIG.getPath() + DocumentPath.WORD_TEMPLATE_ONLINECONSIG.getFileName();
        //设置pdf文件保存路径
        String savePath = DocumentPath.PDF_SAVE_ONLINECONSIG.getPath() + DocumentPath.PDF_SAVE_ONLINECONSIG.getName() + IdUtils.nextId() + ".pdf";
        CommissionOnLine initialize = cumoutProtocolService.initialize(propertId, comId);
        Map<String, String> map = new HashMap<>(20);
        map.put(DocOnlineConsignment.ONLINE_NO.getName(), initialize.getProtocolNo());
        map.put(DocOnlineConsignment.DEBT_NAME.getName(), initialize.getDebtName());
        map.put(DocOnlineConsignment.DEBT_CARD.getName(), initialize.getDebtIdCard());
        if (initialize.getReportPropert().equals("1")) {
            map.put(DocOnlineConsignment.DEBT_ADD.getName(), initialize.getPriAdd());
            map.put(DocOnlineConsignment.DEBT_PHONE.getName(), initialize.getPriPhone());
        } else {
            map.put(DocOnlineConsignment.DEBT_ADD.getName(), initialize.getCorBankAdd());
            map.put(DocOnlineConsignment.DEBT_PHONE.getName(), initialize.getCorBankPhone());
        }
        map.put(DocOnlineConsignment.KAISHI_YAER.getName(), String.format("%tY", initialize.getCreateTime()));
        map.put(DocOnlineConsignment.KAISHI_MOON.getName(), String.format("%tm", initialize.getCreateTime()));
        map.put(DocOnlineConsignment.KAISHI_DAY.getName(), String.format("%td", initialize.getCreateTime()));

        map.put(DocOnlineConsignment.JIESHU_YAER.getName(), String.format("%tY", new SimpleDateFormat("yyyy-MM-dd").parse(initialize.getEndTime())));
        map.put(DocOnlineConsignment.JIESHU_MOON.getName(), String.format("%tm", new SimpleDateFormat("yyyy-MM-dd").parse(initialize.getEndTime())));
        map.put(DocOnlineConsignment.JIESHU_DAY.getName(), String.format("%td", new SimpleDateFormat("yyyy-MM-dd").parse(initialize.getEndTime())));

        map.put(DocOnlineConsignment.THIS_MONEY.getName(), initialize.getAmountThis().toString());
        map.put(DocOnlineConsignment.THIS_MONEY_MAX.getName(), ConvertUpMoney.toChinese(initialize.getAmountThis().toString()));
        map.put(DocOnlineConsignment.JIFEN.getName(), initialize.getIntegral());
        map.put(DocOnlineConsignment.CONT_YAER.getName(), String.format("%tY", initialize.getContractDate()));
        map.put(DocOnlineConsignment.CONT_MOON.getName(), String.format("%tm", initialize.getContractDate()));
        map.put(DocOnlineConsignment.CONT_DAY.getName(), String.format("%td", initialize.getContractDate()));

        int length = initialize.getBusAgentSalesContractModities().size();
        String total = "1";
        //表格行数默认最多10行
        for (int i = 1; i < 11; i++) {
            if (i > length) {
                map.put("productName" + i, "");
                map.put("model" + i, "");
                map.put("unit" + i, "");
                map.put("unitPrice" + i, "");
                map.put("amount" + i, "");
                map.put("total" + i, "");
                map.put("remarks" + i, "");
            } else {
                total = BigDecimalUtil.add(total, initialize.getBusAgentSalesContractModities().get(i - 1).getMoneyNum1(), 2);
                map.put("productName" + i, initialize.getBusAgentSalesContractModities().get(i - 1).getModityName());
                map.put("model" + i, initialize.getBusAgentSalesContractModities().get(i - 1).getModitySpecificat());
                map.put("unit" + i, initialize.getBusAgentSalesContractModities().get(i - 1).getPartyaSeal());
                map.put("unitPrice" + i, initialize.getBusAgentSalesContractModities().get(i - 1).getModityPlace());
                map.put("amount" + i, initialize.getBusAgentSalesContractModities().get(i - 1).getPartybSeal().toString());
                map.put("total" + i, initialize.getBusAgentSalesContractModities().get(i - 1).getMoneyNum1());
                map.put("remarks" + i, initialize.getBusAgentSalesContractModities().get(i - 1).getPartybTime());
            }
        }
        map.put("total", BigDecimalUtil.sub(total, "1", 2));
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
        //创建文档
        PubDoc pubDoc = new PubDoc();
        long nextId = IdUtils.nextId();
        pubDoc.setDocId(nextId);
        pubDoc.setContract(initialize.getProtocolNo());
        pubDoc.setDocName(DocumentPath.WORD_TEMPLATE_ONLINECONSIG.getName());
        pubDoc.setDocType("2");
        pubDoc.setDocPath(savePath);
        pubDoc.setReportId(initialize.getReportId());
        pubDocDao.insertSelective(pubDoc);
    }



    /**
     * 报备费发票
     *
     * @param reportId
     * @param parta
     * @param partaCard
     * @param partaTel
     * @throws CustomerException
     * @throws ParseException
     */
    @Override
    public void fillInWordAndSaveAsSpecifyFormatReportFee(Long reportId, String parta, String partaCard, String partaTel, Long debtId, Long propertId) throws CustomerException, ParseException {
        //设置模板读取路径
        String readPath = DocumentPath.WORD_TEMPLATE_REPORT.getPath() + DocumentPath.WORD_TEMPLATE_REPORT.getFileName();
        //设置pdf文件保存路径
        String savePath = DocumentPath.PDF_SAVE_REPORT.getPath() + DocumentPath.PDF_SAVE_REPORT.getName() + IdUtils.nextId() + ".pdf";
        ReportFee reportFee = busPayDetailService.selectByRepId(reportId, "1", debtId, propertId);
        Map<String, String> map = new HashMap<>(20);
        map.put(DocReportFee.DEBT_NAME.getName(), reportFee.getDebtName());
        map.put(DocReportFee.DEBT_NO.getName(), reportFee.getPayNo());
        map.put(DocReportFee.COM_NAME.getName(), reportFee.getCompanyName());
        map.put(DocReportFee.THIS_YAER.getName(), String.format("%tY", reportFee.getThisTime()));
        map.put(DocReportFee.THIS_MOON.getName(), String.format("%tm", reportFee.getThisTime()));
        map.put(DocReportFee.THIS_DAY.getName(), String.format("%td", reportFee.getThisTime()));
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
        //创建文档
        PubDoc pubDoc = new PubDoc();
        long nextId = IdUtils.nextId();
        pubDoc.setDocId(nextId);
        pubDoc.setContract(reportFee.getPayNo());
        pubDoc.setDocName(DocumentPath.WORD_TEMPLATE_REPORT.getName());
        pubDoc.setDocPath(savePath);
        pubDoc.setReportId(reportFee.getReportId());
        pubDoc.setDocType("1");
        pubDocDao.insertSelective(pubDoc);
        //创建电子章
        BusElectronSeal busElectronSeal = new BusElectronSeal();
        //信息分析暨尽调协议
        busElectronSeal.setDocType("1");
        busElectronSeal.setFilePath(savePath);
        busElectronSeal.setDocId(nextId);
        busElectronSeal.setParta(parta);
        busElectronSeal.setPartaCard(partaCard);
        busElectronSeal.setPartaTel(partaTel);
        busElectronSealController.addPubUser(busElectronSeal);
    }

    /**
     * 咨询服务费
     *
     * @param reportId
     * @param parta
     * @param partaCard
     * @param partaTel
     * @throws CustomerException
     * @throws ParseException
     */
    @Override
    public void fillInWordAndSaveAsSpecifyFormatdvisory(Long reportId, String parta, String partaCard, String partaTel, Long debtId, Long propertId) throws CustomerException, ParseException {
        //设置模板读取路径
        String readPath = DocumentPath.WORD_TEMPLATE_ADVISORY.getPath() + DocumentPath.WORD_TEMPLATE_ADVISORY.getFileName();
        //设置pdf文件保存路径
        String savePath = DocumentPath.PDF_SAVE_ADVISORY.getPath() + DocumentPath.PDF_SAVE_ADVISORY.getName() + IdUtils.nextId() + ".pdf";
        Map<String, String> map = new HashMap<>(20);
        ReportFee reportFee = busPayDetailService.selectByRepId(reportId, "3", debtId, propertId);
        map.put(DocReportFee.DEBT_NAME.getName(), reportFee.getDebtName());
        map.put(DocReportFee.DEBT_NO.getName(), reportFee.getPayNo());
        map.put(DocReportFee.COM_NAME.getName(), reportFee.getCompanyName());
        map.put(DocReportFee.THIS_YAER.getName(), String.format("%tY", reportFee.getThisTime()));
        map.put(DocReportFee.MONEY.getName(), reportFee.getCost().toString());
        map.put(DocReportFee.MONEY_MAX.getName(), ConvertUpMoney.toChinese(reportFee.getCost().toString()));
        map.put(DocReportFee.THIS_MOON.getName(), String.format("%tm", reportFee.getThisTime()));
        map.put(DocReportFee.THIS_DAY.getName(), String.format("%td", reportFee.getThisTime()));
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);

        //创建文档
        PubDoc pubDoc = new PubDoc();
        long nextId = IdUtils.nextId();
        pubDoc.setDocId(nextId);
        pubDoc.setContract(reportFee.getPayNo());
        pubDoc.setDocName(DocumentPath.WORD_TEMPLATE_ADVISORY.getName());
        pubDoc.setDocPath(savePath);
        pubDoc.setReportId(reportFee.getReportId());
        pubDoc.setDocType("1");
        pubDocDao.insertSelective(pubDoc);
        //创建电子章
        BusElectronSeal busElectronSeal = new BusElectronSeal();
        //信息分析暨尽调协议
        busElectronSeal.setDocType("2");
        busElectronSeal.setFilePath(savePath);
        busElectronSeal.setDocId(nextId);
        busElectronSeal.setParta(parta);
        busElectronSeal.setPartaCard(partaCard);
        busElectronSeal.setPartaTel(partaTel);
        busElectronSealController.addPubUser(busElectronSeal);
    }

    /**
     * 货款费发票
     *
     * @param reportId
     * @param parta
     * @param partaCard
     * @param partaTel
     * @throws CustomerException
     * @throws ParseException
     */
    @Override
    public void fillInWordAndSaveAsSpecifyPayment(Long reportId, String parta, String partaCard, String partaTel, Long debtId, Long propertId) throws CustomerException, ParseException {
        //设置模板读取路径
        String readPath = DocumentPath.WORD_TEMPLATE_PAYMENT.getPath() + DocumentPath.WORD_TEMPLATE_PAYMENT.getFileName();
        //设置pdf文件保存路径
        String savePath = DocumentPath.PDF_SAVE_PAYMENT.getPath() + DocumentPath.PDF_SAVE_PAYMENT.getName() + IdUtils.nextId() + ".pdf";
        Map<String, String> map = new HashMap<>(20);
        ReportFee reportFee = busPayDetailService.selectByRepId(reportId, "4", debtId, propertId);
        map.put(DocReportFee.DEBT_NAME.getName(), reportFee.getDebtName());
        map.put(DocReportFee.MONEY.getName(), reportFee.getCost().toString());
        map.put(DocReportFee.MONEY_MAX.getName(), ConvertUpMoney.toChinese(reportFee.getCost().toString()));
        map.put(DocReportFee.DEBT_NO.getName(), reportFee.getPayNo());
        map.put(DocReportFee.COM_NAME.getName(), reportFee.getCompanyName());
        map.put(DocReportFee.THIS_YAER.getName(), String.format("%tY", reportFee.getCreateTime()));
        map.put(DocReportFee.THIS_MOON.getName(), String.format("%tm", reportFee.getCreateTime()));
        map.put(DocReportFee.THIS_DAY.getName(), String.format("%td", reportFee.getCreateTime()));
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);

        //创建文档
        PubDoc pubDoc = new PubDoc();
        long nextId = IdUtils.nextId();
        pubDoc.setDocId(nextId);
        pubDoc.setContract(reportFee.getPayNo());
        pubDoc.setDocName(DocumentPath.WORD_TEMPLATE_PAYMENT.getName());
        pubDoc.setDocPath(savePath);
        pubDoc.setReportId(reportFee.getReportId());
        pubDoc.setDocType("2");
        pubDocDao.insertSelective(pubDoc);
        //创建电子章
        BusElectronSeal busElectronSeal = new BusElectronSeal();
        //信息分析暨尽调协议
        busElectronSeal.setDocType("3");
        busElectronSeal.setFilePath(savePath);
        busElectronSeal.setDocId(nextId);
        busElectronSeal.setParta(parta);
        busElectronSeal.setPartaCard(partaCard);
        busElectronSeal.setPartaTel(partaTel);
        busElectronSealController.addPubUser(busElectronSeal);
    }

}
