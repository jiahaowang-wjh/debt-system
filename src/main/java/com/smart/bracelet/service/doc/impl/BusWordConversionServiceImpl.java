package com.smart.bracelet.service.doc.impl;

import com.smart.bracelet.controller.doc.BusElectronSealController;
import com.smart.bracelet.dao.assets.BusConfirmDao;
import com.smart.bracelet.dao.user.PubDocDao;
import com.smart.bracelet.enums.*;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusAgentSalesContract;
import com.smart.bracelet.model.po.assets.BusCollectionLetter;
import com.smart.bracelet.model.po.doc.BusElectronSeal;
import com.smart.bracelet.model.po.user.PubDoc;
import com.smart.bracelet.model.vo.assets.*;
import com.smart.bracelet.model.vo.debt.AgreementInfoShow;
import com.smart.bracelet.model.vo.debt.PlanServiceInfo;
import com.smart.bracelet.service.assets.*;
import com.smart.bracelet.service.debt.BusCivilService;
import com.smart.bracelet.service.debt.PubDebtService;
import com.smart.bracelet.service.doc.BusWordConversionService;
import com.smart.bracelet.service.user.PubDocService;
import com.smart.bracelet.utils.ConvertUpMoney;
import com.smart.bracelet.utils.IdUtils;

import com.smart.bracelet.utils.PdfUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private PubDocDao pubDocDao;

    /**
     * 暨尽协议
     *
     * @param reportId
     * @param comId
     * @throws ParseException
     */
    @Override
    public Long fillInWordAndSaveAsSpecifyFormatCumOut(Long reportId, Long comId,String parta,String partaCard,String partaTel) throws ParseException, CustomerException {
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
            pubDoc.setDocName(DocumentPath.PDF_SAVE_CUMOUT.getName());
            pubDoc.setDocPath(readPath);
            pubDoc.setReportId(initialize.getReportId());
            pubDocDao.insertSelective(pubDoc);
            //创建电子章
            BusElectronSeal busElectronSeal = new BusElectronSeal();
            //信息分析暨尽调协议
            busElectronSeal.setDocType("4");
            busElectronSeal.setFilePath(savePath);
            busElectronSeal.setDocId(nextId);
            busElectronSeal.setParta(parta);
            busElectronSeal.setPartaCard(partaCard);
            busElectronSeal.setPartaTel(partaTel);
            busElectronSealController.addPubUser(busElectronSeal);
            return nextId;
        } catch (ParseException e) {
            throw new CustomerException("盖章失败，异常信息"+e.getMessage());
        }
        catch (CustomerException e) {
            throw new CustomerException("盖章失败,异常信息"+e.getMessage());
        }
    }
    /**
     * 填充Word并保存为指定格式策划服务协议
     *
     * @author liuzq
     * @date 2020/9/20
     */
    @Override
    public void fillInWordAndSaveAsSpecifyFormatPlan(Long reportId, Long comId,String parta,String partaCard,String partaTel) throws CustomerException {
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
        pubDoc.setDocName(DocumentPath.PDF_SAVE_CUMOUT.getName());
        pubDoc.setDocPath(readPath);
        pubDoc.setReportId(planServiceInfo.getReportId());
        pubDocDao.insertSelective(pubDoc);
        //创建电子章
        BusElectronSeal busElectronSeal = new BusElectronSeal();
        //信息分析暨尽调协议
        busElectronSeal.setDocType("5");
        busElectronSeal.setFilePath(savePath);
        busElectronSeal.setDocId(nextId);
        busElectronSeal.setParta(parta);
        busElectronSeal.setPartaCard(partaCard);
        busElectronSeal.setPartaTel(partaTel);
        busElectronSealController.addPubUser(busElectronSeal);
    }

    /**
     * 债权转让协议
     *
     * @param propertId
     * @param comId
     */
    @Override
    public void fillInWordAndSaveAsSpecifyFormatTransfer(Long propertId, Long comId,String parta,String partaCard,String partaTel) throws CustomerException, ParseException {
        //设置模板读取路径
        String readPath = DocumentPath.WORD_TEMPLATE_TRANSFER.getPath() + DocumentPath.WORD_TEMPLATE_TRANSFER.getFileName();
        //设置pdf文件保存路径
        String savePath = DocumentPath.PDF_SAVE_TRANSFER.getPath() + DocumentPath.PDF_SAVE_TRANSFER.getName() + IdUtils.nextId() + ".pdf";
        Map<String, String> map = new HashMap<>(20);
        BusAssignmentAgreementShow initialize = busAssignmentAgreementService.initialize(propertId, comId);
        map.put(DocEransfer.ASSNO.getName(), initialize.getAssignmentAgreementNo());
        map.put(DocEransfer.DEBT_NAME.getName(), initialize.getDebtName());
        map.put(DocEransfer.DEBT_IDCARD.getName(), initialize.getIdCard());
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
        //替换模板并保存为PDF
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);


        //创建文档
        PubDoc pubDoc = new PubDoc();
        long nextId = IdUtils.nextId();
        pubDoc.setDocId(nextId);
        pubDoc.setContract(initialize.getAssignmentAgreementNo());
        pubDoc.setDocName(DocumentPath.PDF_SAVE_CUMOUT.getName());
        pubDoc.setDocPath(readPath);
        pubDoc.setReportId(initialize.getReportId());
        pubDocDao.insertSelective(pubDoc);
        //创建电子章
        BusElectronSeal busElectronSeal = new BusElectronSeal();
        //信息分析暨尽调协议
        busElectronSeal.setDocType("6");
        busElectronSeal.setFilePath(savePath);
        busElectronSeal.setDocId(nextId);
        busElectronSeal.setParta(parta);
        busElectronSeal.setPartaCard(partaCard);
        busElectronSeal.setPartaTel(partaTel);
        busElectronSealController.addPubUser(busElectronSeal);
    }

    /**
     * 债权转让确认
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
        for (String item: authName) {
            stringBuffer.append(item+".");
        }
        map.put(DocTransferConfirm.AUTHNAME.getName(), stringBuffer.toString());
        Date contractTime = initialize.getContractTime();
        System.out.println(String.format("%tY",contractTime)+String.format("%tm",contractTime));
        map.put(DocTransferConfirm.CONT_THIS_YAER.getName(),String.format("%tY",contractTime));
        map.put(DocTransferConfirm.CONT_THIS_MOON.getName(),String.format("%tm",contractTime));
        map.put(DocTransferConfirm.CONT_THIS_DAY.getName(), String.format("%td",contractTime));
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
    }

    /**
     * 资产债权转让通知书
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
        map.put(DocNotice.NOTICE_NO.getName(),initialize.getNoticeNo());
        map.put(DocNotice.DEBT_DAME.getName(),initialize.getDebtName());
        map.put(DocNotice.PERSON_NAME.getName(),initialize.getPersonName());
        map.put(DocNotice.NOTICE_NO.DEBT_REASON.getName(),initialize.getPersonReason());//未获取到数据来源
        map.put(DocNotice.DEBT_AUTHIS_MONEY.getName(),initialize.getAmountThis().toString());
        Date contractTime = initialize.getContractTime();
        map.put(DocNotice.CON_TIME_YAER.getName(),String.format("%tY",contractTime));
        map.put(DocNotice.CON_TIME_MOON.getName(),String.format("%tm",contractTime));
        map.put(DocNotice.CON_TIME_DAY.getName(),String.format("%td",contractTime));
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
    }

    /**
     * 资产债权确认书
     * @param propertId
     * @throws CustomerException
     * @throws ParseException
     */
    @Override
    public void fillInWordAndSaveAsSpecifyFormatProve(Long propertId,String parta,String partaCard,String partaTel) throws CustomerException, ParseException {
        //设置模板读取路径
        String readPath = DocumentPath.WORD_TEMPLATE_PROVE.getPath() + DocumentPath.WORD_TEMPLATE_PROVE.getFileName();
        //设置pdf文件保存路径
        String savePath = DocumentPath.PDF_SAVE_PROVE.getPath() + DocumentPath.PDF_SAVE_PROVE.getName() + IdUtils.nextId() + ".pdf";
        BusConfirmShow initialize = busConfirmService.initialize(propertId);
        Map<String, String> map = new HashMap<>(20);
        map.put(DocProve.CONFIRM_NO.getName(),initialize.getConfirmNo());
        map.put(DocProve.DEBT_NAME.getName(),initialize.getDebtName());
        map.put(DocProve.PERSON_NAME.getName(),initialize.getPersonName());
        map.put(DocProve.ASSAG_NO.getName(),initialize.getAssignmentAgreementNo());
        Date createTime = initialize.getCreateTime();
        map.put(DocProve.DEBT_YAER.getName(),String.format("%tY",createTime));
        map.put(DocProve.DEBT_MOON.getName(),String.format("%tm",createTime));
        map.put(DocProve.DEBT_DAY.getName(),String.format("%td",createTime));
        map.put(DocProve.THIS_MONEY.getName(),initialize.getAmountThis().toString());
        map.put(DocProve.SERVICE_BENJIN.getName(),initialize.getServicePrincipal().toString());
        map.put(DocProve.SERVICE_LIXI.getName(),initialize.getServiceInterest().toString());
        Date a = initialize.getContractTime();
        map.put(DocProve.CONT_YAER.getName(),String.format("%tY",a));
        map.put(DocProve.CONT_MOON.getName(),String.format("%tm",a));
        map.put(DocProve.CONT_DAY.getName(),String.format("%td",a));
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
        //创建文档
        PubDoc pubDoc = new PubDoc();
        long nextId = IdUtils.nextId();
        pubDoc.setDocId(nextId);
        pubDoc.setContract(initialize.getConfirmNo());
        pubDoc.setDocName(DocumentPath.PDF_SAVE_CUMOUT.getName());
        pubDoc.setDocPath(readPath);
        pubDoc.setReportId(initialize.getReportId());
        pubDocDao.insertSelective(pubDoc);
        //创建电子章
        BusElectronSeal busElectronSeal = new BusElectronSeal();
        //信息分析暨尽调协议
        busElectronSeal.setDocType("9");
        busElectronSeal.setFilePath(savePath);
        busElectronSeal.setDocId(nextId);
        busElectronSeal.setParta(parta);
        busElectronSeal.setPartaCard(partaCard);
        busElectronSeal.setPartaTel(partaTel);
        busElectronSealController.addPubUser(busElectronSeal);


    }

    /**
     * 催款函
     * @param propertId
     * @param comId
     * @throws CustomerException
     * @throws ParseException
     */
    @Override
    public void fillInWordAndSaveAsSpecifyFormatLetter(Long propertId,Long comId,String parta,String partaCard,String partaTel) throws CustomerException, ParseException {
        //设置模板读取路径
        String readPath = DocumentPath.WORD_TEMPLATE_LETTER.getPath() + DocumentPath.WORD_TEMPLATE_LETTER.getFileName();
        //设置pdf文件保存路径
        String savePath = DocumentPath.PDF_SAVE_LETTER.getPath() + DocumentPath.PDF_SAVE_LETTER.getName() + IdUtils.nextId() + ".pdf";
        BusCollectionLetterShow initialize = busCollectionLetterService.initialize(propertId,comId);
        Map<String, String> map = new HashMap<>(20);
        map.put(DocLetter.LETTER_NO.getName(),initialize.getCollectionLettertNo());
        map.put(DocLetter.PERSON_NAME.getName(),initialize.getPersonName());
        map.put(DocLetter.DEBT_NAME.getName(),initialize.getDebtName());
        map.put(DocLetter.THIS_MOEY.getName(),initialize.getAmountThis().toString());
        map.put(DocLetter.THIS_MOEY_MAX.getName(),initialize.getMoneyMax());
        Date contractDate = initialize.getContractDate();
        map.put(DocLetter.CONT_YAER.getName(),String.format("%tY",contractDate));
        map.put(DocLetter.CONT_MOON.getName(),String.format("%tm",contractDate));
        map.put(DocLetter.CONT_DAY.getName(),String.format("%td",contractDate));
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);


        //创建文档
        PubDoc pubDoc = new PubDoc();
        long nextId = IdUtils.nextId();
        pubDoc.setDocId(nextId);
        pubDoc.setContract(initialize.getCollectionLettertNo());
        pubDoc.setDocName(DocumentPath.PDF_SAVE_CUMOUT.getName());
        pubDoc.setDocPath(readPath);
        pubDoc.setReportId(initialize.getReportId());
        pubDocDao.insertSelective(pubDoc);
        //创建电子章
        BusElectronSeal busElectronSeal = new BusElectronSeal();
        //信息分析暨尽调协议
        busElectronSeal.setDocType("10");
        busElectronSeal.setFilePath(savePath);
        busElectronSeal.setDocId(nextId);
        busElectronSeal.setParta(parta);
        busElectronSeal.setPartaCard(partaCard);
        busElectronSeal.setPartaTel(partaTel);
        busElectronSealController.addPubUser(busElectronSeal);
    }

    /**
     * 委托代理销售
     * @param propertId
     * @param comId
     * @throws CustomerException
     * @throws ParseException
     */
    @Override
    public void fillInWordAndSaveAsSpecifyFormatConsignment(Long propertId,Long comId,String parta,String partaCard,String partaTel) throws CustomerException, ParseException {
        //设置模板读取路径
        String readPath = DocumentPath.WORD_TEMPLATE_CONSIG.getPath() + DocumentPath.WORD_TEMPLATE_CONSIG.getFileName();
        //设置pdf文件保存路径
        String savePath = DocumentPath.PDF_SAVE_CONSIG.getPath() + DocumentPath.PDF_SAVE_CONSIG.getName() + IdUtils.nextId() + ".pdf";
        BusAgentSalesContractShow initialize = busAgentSalesContractService.initialize(propertId, comId);
        Map<String, String> map = new HashMap<>(20);
        map.put(DocConsignment.CONT_NO.getName(),initialize.getSalesNo());
        map.put(DocConsignment.DEBT_NAME.getName(),initialize.getDebtName());
        map.put(DocConsignment.DEBT_CARD.getName(),initialize.getDebtIdCard());
        if(initialize.getReportPropert().equals("1")){
            map.put(DocConsignment.DEBT_ADD.getName(),initialize.getPriAdd());
            map.put(DocConsignment.DEBT_PHONE.getName(),initialize.getPriPhone());
        }else {
            map.put(DocConsignment.DEBT_ADD.getName(),initialize.getCorBankAdd());
            map.put(DocConsignment.DEBT_PHONE.getName(),initialize.getCorBankPhone());
        }
        map.put(DocConsignment.DAIXIAO_YAER.getName(),String.format("%tY",initialize.getCreateTime()));
        map.put(DocConsignment.DAIXIAO_MOON.getName(),String.format("%tm",initialize.getCreateTime()));
        map.put(DocConsignment.DAIXIAO_DAY.getName(),String.format("%td",initialize.getCreateTime()));
        map.put(DocConsignment.DAIXIAO_JIESHU_YAER.getName(),String.format("%tY",new SimpleDateFormat("yyyy-mm-dd").parse(initialize.getEndTime())));
        map.put(DocConsignment.DAIXIAO_JIESHU_MOON.getName(),String.format("%tm",new SimpleDateFormat("yyyy-mm-dd").parse(initialize.getEndTime())));
        map.put(DocConsignment.DAIXIAO_JIESHU_DAY.getName(),String.format("%td",new SimpleDateFormat("yyyy-mm-dd").parse(initialize.getEndTime())));

        map.put(DocConsignment.THIS_MONEY.getName(),initialize.getAmountThis().toString());
        map.put(DocConsignment.THIS_MONEY_MAX.getName(),initialize.getAmountThisMax());
        map.put(DocConsignment.AVG_MONEY.getName(),initialize.getAverageMoney());
        map.put(DocConsignment.DEBT_YINHANGKAHAO.getName(),initialize.getBankCard());
        map.put(DocConsignment.DEBT_KAIHUHANG.getName(),initialize.getBank());
        map.put(DocConsignment.CONT_YAER.getName(),String.format("%tY",initialize.getContractDate()));
        map.put(DocConsignment.CONT_MOON.getName(),String.format("%tm",initialize.getContractDate()));
        map.put(DocConsignment.CONT_DAY.getName(),String.format("%td",initialize.getContractDate()));
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);


        //创建文档
        PubDoc pubDoc = new PubDoc();
        long nextId = IdUtils.nextId();
        pubDoc.setDocId(nextId);
        pubDoc.setContract(initialize.getSalesNo());
        pubDoc.setDocName(DocumentPath.PDF_SAVE_CUMOUT.getName());
        pubDoc.setDocPath(readPath);
        pubDoc.setReportId(initialize.getReportId());
        pubDocDao.insertSelective(pubDoc);
        //创建电子章
        BusElectronSeal busElectronSeal = new BusElectronSeal();
        //信息分析暨尽调协议
        busElectronSeal.setDocType("11");
        busElectronSeal.setFilePath(savePath);
        busElectronSeal.setDocId(nextId);
        busElectronSeal.setParta(parta);
        busElectronSeal.setPartaCard(partaCard);
        busElectronSeal.setPartaTel(partaTel);
        busElectronSealController.addPubUser(busElectronSeal);
    }

    /**
     * 和解协议
     * @param propertId
     * @param comId
     * @throws CustomerException
     * @throws ParseException
     */
    @Override
    public void fillInWordAndSaveAsSpecifyFormatReconciliation(Long propertId, Long comId,String parta,String partaCard,String partaTel) throws CustomerException, ParseException {
        //设置模板读取路径
        String readPath = DocumentPath.WORD_TEMPLATE_RECILIATION.getPath() + DocumentPath.WORD_TEMPLATE_RECILIATION.getFileName();
        //设置pdf文件保存路径
        String savePath = DocumentPath.PDF_SAVE_RECILIATION.getPath() + DocumentPath.PDF_SAVE_RECILIATION.getName() + IdUtils.nextId() + ".pdf";
        BusCompromiseAgreementShow initialize = busCompromiseAgreementService.initialize(propertId, comId);
        Map<String, String> map = new HashMap<>(20);
        map.put(DocReconciliation.REC_NO.getName(),initialize.getCompromiseAgreementNo());
        map.put(DocReconciliation.PERSON_NAME.getName(),initialize.getPersonName());
        map.put(DocReconciliation.DEBT_NAME.getName(),initialize.getDebtName());
        map.put(DocReconciliation.THIS_MONEY.getName(),initialize.getAmountThis().toString());
        map.put(DocReconciliation.XUANZE.getName(),initialize.getPartybMode());
        map.put(DocReconciliation.AVG.getName(),initialize.getAverage());
        map.put(DocReconciliation.DEBT_DAY.getName(),initialize.getDay());
        map.put(DocReconciliation.CONT_YAER.getName(),String.format("%tY",initialize.getContractDate()));
        map.put(DocReconciliation.CONT_MOON.getName(),String.format("%tm",initialize.getContractDate()));
        map.put(DocReconciliation.DEBT_DAY.getName(),String.format("%td",initialize.getContractDate()));
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);

        //创建文档
        PubDoc pubDoc = new PubDoc();
        long nextId = IdUtils.nextId();
        pubDoc.setDocId(nextId);
        pubDoc.setContract(initialize.getCompromiseAgreementNo());
        pubDoc.setDocName(DocumentPath.PDF_SAVE_CUMOUT.getName());
        pubDoc.setDocPath(readPath);
        pubDoc.setReportId(initialize.getReportId());
        pubDocDao.insertSelective(pubDoc);
        //创建电子章
        BusElectronSeal busElectronSeal = new BusElectronSeal();
        //信息分析暨尽调协议
        busElectronSeal.setDocType("12");
        busElectronSeal.setFilePath(savePath);
        busElectronSeal.setDocId(nextId);
        busElectronSeal.setParta(parta);
        busElectronSeal.setPartaCard(partaCard);
        busElectronSeal.setPartaTel(partaTel);
        busElectronSealController.addPubUser(busElectronSeal);

    }

    /**
     * 线上委托销售
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
        map.put(DocOnlineConsignment.ONLINE_NO.getName(),initialize.getProtocolNo());
        map.put(DocOnlineConsignment.DEBT_NAME.getName(),initialize.getDebtName());
        map.put(DocOnlineConsignment.DEBT_CARD.getName(),initialize.getDebtIdCard());
        if(initialize.getReportPropert().equals("1")){
            map.put(DocOnlineConsignment.DEBT_ADD.getName(),initialize.getPriAdd());
            map.put(DocOnlineConsignment.DEBT_PHONE.getName(),initialize.getPriPhone());
        }else{
            map.put(DocOnlineConsignment.DEBT_ADD.getName(),initialize.getCorBankAdd());
            map.put(DocOnlineConsignment.DEBT_PHONE.getName(),initialize.getCorBankPhone());
        }
        map.put(DocOnlineConsignment.KAISHI_YAER.getName(),String.format("%tY",initialize.getCreateTime()));
        map.put(DocOnlineConsignment.KAISHI_MOON.getName(),String.format("%tm",initialize.getCreateTime()));
        map.put(DocOnlineConsignment.KAISHI_DAY.getName(),String.format("%td",initialize.getCreateTime()));

        map.put(DocOnlineConsignment.JIESHU_YAER.getName(),String.format("%tY",new SimpleDateFormat("yyyy-MM-dd").parse(initialize.getEndTime())));
        map.put(DocOnlineConsignment.JIESHU_MOON.getName(),String.format("%tm",new SimpleDateFormat("yyyy-MM-dd").parse(initialize.getEndTime())));
        map.put(DocOnlineConsignment.JIESHU_DAY.getName(),String.format("%td",new SimpleDateFormat("yyyy-MM-dd").parse(initialize.getEndTime())));

        map.put(DocOnlineConsignment.THIS_MONEY.getName(),initialize.getAmountThis().toString());
        map.put(DocOnlineConsignment.THIS_MONEY_MAX.getName(), ConvertUpMoney.toChinese(initialize.getAmountThis().toString()));
        map.put(DocOnlineConsignment.JIFEN.getName(),initialize.getIntegral());
        map.put(DocOnlineConsignment.CONT_YAER.getName(),String.format("%tY",initialize.getContractDate()));
        map.put(DocOnlineConsignment.CONT_MOON.getName(),String.format("%tm",initialize.getContractDate()));
        map.put(DocOnlineConsignment.CONT_DAY.getName(),String.format("%td",initialize.getContractDate()));
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
    }

    /**
     * 0.信息分析暨尽调协议（天泽系统）
     */
    public void informationAnalysis() {
        //设置模板读取路径
        String readPath = "D:/doc/0.信息分析暨尽调协议（天泽系统）.docx";
        //设置pdf文件保存路径
        String savePath = "D:/doc/0.信息分析暨尽调协议（天泽系统）" + IdUtils.nextId() + ".pdf";
        LocalDate date = LocalDate.now();
        Map<String, String> map = new HashMap<>(20);
        map.put("agreementNumber", IdUtils.nextId() + "");
        map.put("reporter", "张三");
        map.put("reporterIDCard", "" + IdUtils.nextId());
        map.put("partyA", "张三");
        map.put("partyB", "李四");
        map.put("yyy1", date.getYear() + "");
        map.put("M1", date.getMonthValue() + "");
        map.put("d1", date.getDayOfMonth() + "");
        map.put("yyy2", date.getYear() + "");
        map.put("M2", date.getMonthValue() + "");
        map.put("d2", date.getDayOfMonth() + "");
        //替换模板并保存为PDF
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
    }

    /**
     * 1.策划方案服务协议(天泽系统）
     */
    public void planningScheme() {
        //设置模板读取路径
        String readPath = "D:/doc/1.策划方案服务协议(天泽系统）.docx";
        //设置pdf文件保存路径
        String savePath = "D:/doc/1.策划方案服务协议(天泽系统）" + IdUtils.nextId() + ".pdf";
        LocalDate date = LocalDate.now();
        Map<String, String> map = new HashMap<>(20);
        map.put("agreementNumber", IdUtils.nextId() + "");
        map.put("debtName", "张三");
        map.put("debtIdCard", "510364198712021816");
        map.put("idCardAddress", "重庆市渝中区xxxx");
        map.put("phoneNumber", "18765453643");
        map.put("situation", "1");
        map.put("amount", "11000");
        map.put("amountInWords", "壹万壹仟");
        map.put("principal", "10000");
        map.put("interest", "1000");
        map.put("serviceFee", "1100");
        map.put("serviceFeeInWords", "壹仟壹佰");
        map.put("yyy1", date.getYear() + "");
        map.put("M1", date.getMonthValue() + "");
        map.put("d1", date.getDayOfMonth() + "");
        map.put("yyy2", date.getYear() + "");
        map.put("M2", date.getMonthValue() + "");
        map.put("d2", date.getDayOfMonth() + "");
        //替换模板并保存为PDF
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
    }

    /**
     * 2.债权转让协议1（资产系统）
     */
    public void debtAssignmentAgreement() {
        //设置模板读取路径
        String readPath = "D:/doc/2.债权转让协议1（资产系统）.docx";
        //设置pdf文件保存路径
        String savePath = "D:/doc/2.债权转让协议1（资产系统）" + IdUtils.nextId() + ".pdf";
        Map<String, String> map = new HashMap<>(20);
        LocalDate date = LocalDate.now();
        map.put("agreementNumber", IdUtils.nextId() + "");
        map.put("debtName", "张三");
        map.put("idCard", "510265197612271644");
        map.put("idCardAddress", "重庆市渝中区xxxx");
        map.put("phoneNumber", "17578655634");
        map.put("personName", "李四");
        map.put("yyy1 ", "2020");
        map.put("M1", "5");
        map.put("d1", "26");
        map.put("yyy2", date.getYear() + "");
        map.put("M2", date.getMonthValue() + "");
        map.put("d2", date.getDayOfMonth() + "");
        map.put("amount", "11000");
        map.put("principal", "10000");
        map.put("interest", "1000");
        map.put("amount2", "11000");
        map.put("partyA", "张三");
        map.put("partyB", "李四");
        map.put("yyy3", date.getYear() + "");
        map.put("M3", date.getMonthValue() + "");
        map.put("d3", date.getDayOfMonth() + "");
        map.put("yyy4", date.getYear() + "");
        map.put("M4", date.getMonthValue() + "");
        map.put("d4", date.getDayOfMonth() + "");
        //这里设置需要填充的表格行数
        int length = 6;
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
                map.put("productName" + i, "商品" + i);
                map.put("model" + i, "SPR-138");
                map.put("unit" + i, "个");
                map.put("unitPrice" + i, "1");
                map.put("amount" + i, "10");
                map.put("total" + i, "10");
                map.put("remarks" + i, "");
            }
        }
        //替换模板并保存为PDF
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
    }


    /**
     * 3.债权转让确认书 （资产系统）
     */
    public void confirmation() {
        //设置模板读取路径
        String readPath = "D:/doc/3.债权转让确认书 （资产系统）.docx";
        //设置pdf文件保存路径
        String savePath = "D:/doc/3.债权转让确认书 （资产系统）" + IdUtils.nextId() + ".pdf";
        LocalDate date = LocalDate.now();
        Map<String, String> map = new HashMap<>(20);
        map.put("agreementNumber", IdUtils.nextId() + "");
        map.put("agreementNumber2", IdUtils.nextId() + "");
        map.put("agreementNumber3", IdUtils.nextId() + "");
        map.put("debtName", "张三");
        map.put("personName", "李四");
        map.put("guarantee", "王五");
        map.put("amount", "11000");
        map.put("yyy1", date.getYear() + "");
        map.put("M1", date.getMonthValue() + "");
        map.put("d1", date.getDayOfMonth() + "");
        map.put("yyy2", date.getYear() + "");
        map.put("M2", date.getMonthValue() + "");
        map.put("d2", date.getDayOfMonth() + "");
        map.put("yyy3", date.getYear() + "");
        map.put("M3", date.getMonthValue() + "");
        map.put("d3", date.getDayOfMonth() + "");
        map.put("yyy4", date.getYear() + "");
        map.put("M4", date.getMonthValue() + "");
        map.put("d4", date.getDayOfMonth() + "");
        //替换模板并保存为PDF
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
    }

    /**
     * 4.债权转让通知书 （资产系统）
     */
    public void notice() {
        //设置模板读取路径
        String readPath = "D:/doc/4.债权转让通知书 （资产系统）.docx";
        //设置pdf文件保存路径
        String savePath = "D:/doc/4.债权转让通知书 （资产系统）" + IdUtils.nextId() + ".pdf";
        LocalDate date = LocalDate.now();
        Map<String, String> map = new HashMap<>(20);
        map.put("agreementNumber", IdUtils.nextId() + "");
        map.put("debtName", "张三");
        map.put("personName", "李四");
        map.put("personReason", "因xxx，造成了巨大的损失，所以需要在这里完成他们的事物");
        map.put("idCard", "510364198712021816");
        map.put("amount", "11000");
        map.put("yyyy", date.getYear() + "");
        map.put("MM", date.getMonthValue() + "");
        map.put("dd", date.getDayOfMonth() + "");
        //替换模板并保存为PDF
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);

    }

    /**
     * 5.债权确认书 （资产系统）
     */
    public void confirmationOfCreditorRights() {
        //设置模板读取路径
        String readPath = "D:/doc/5.债权确认书 （资产系统）.docx";
        //设置pdf文件保存路径
        String savePath = "D:/doc/5.债权确认书 （资产系统）" + IdUtils.nextId() + ".pdf";
        Map<String, String> map = new HashMap<>(20);
        LocalDate date = LocalDate.now();
        map.put("agreementNumber", IdUtils.nextId() + "");
        map.put("personName", "李四");
        map.put("debtName", "张三");
        map.put("agreementNumber2", IdUtils.nextId() + "");
        map.put("yyy1", date.getYear() + "");
        map.put("M1", date.getMonthValue() + "");
        map.put("d1", date.getDayOfMonth() + "");
        map.put("principal", "11000");
        map.put("interest", "1000");
        map.put("yyy2", date.getYear() + "");
        map.put("M2", date.getMonthValue() + "");
        map.put("d2", date.getDayOfMonth() + "");
        map.put("yyy3", date.getYear() + "");
        map.put("M3", date.getMonthValue() + "");
        map.put("d3", date.getDayOfMonth() + "");
        //替换模板并保存为PDF
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
    }

    /**
     * 6.催款函 （资产系统）
     */
    public void dunningLetter() {
        //设置模板读取路径
        String readPath = "D:/doc/6.催款函 （资产系统）.docx";
        //设置pdf文件保存路径
        String savePath = "D:/doc/6.催款函 （资产系统）" + IdUtils.nextId() + ".pdf";
        Map<String, String> map = new HashMap<>(20);
        LocalDate date = LocalDate.now();
        map.put("agreementNumber", IdUtils.nextId() + "");
        map.put("debtName", "张三");
        map.put("personName", "李四");
        map.put("agreementNumber2", IdUtils.nextId() + "");
        map.put("amount", "11000");
        map.put("amountInWords", "壹万壹仟");
        map.put("yyyy", date.getYear() + "");
        map.put("MM", date.getMonthValue() + "");
        map.put("dd", date.getDayOfMonth() + "");
        //替换模板并保存为PDF
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
    }

    /**
     * 7.委托代理销售合同1 （资产系统）
     */
    public void salesContract() {
        //设置模板读取路径
        String readPath = "D:/doc/7.委托代理销售合同1 （资产系统）.docx";
        //设置pdf文件保存路径
        String savePath = "D:/doc/7.委托代理销售合同1 （资产系统）" + IdUtils.nextId() + ".pdf";
        Map<String, String> map = new HashMap<>(20);
        LocalDate date = LocalDate.now();
        map.put("agreementNumber", IdUtils.nextId() + "");
        map.put("debtName", "张三");
        map.put("idCard", "510453197607161416");
        map.put("idCardAddress", "重庆市渝中区xxxx");
        map.put("phoneNumber", "13656467865");
        map.put("yyy1", "2020");
        map.put("M1", "6");
        map.put("d1", "21");
        map.put("yyy2", date.getYear() + "");
        map.put("M2", date.getMonthValue() + "");
        map.put("d2", date.getDayOfMonth() + "");
        map.put("amount", "11000");
        map.put("amountInWords", "壹万壹仟");
        map.put("bankCard", "5642245785546532");
        map.put("bank", "中国银行");
        map.put("partyA", "张三");
        map.put("partyB", "李四");
        map.put("yyy3", date.getYear() + "");
        map.put("M3", date.getMonthValue() + "");
        map.put("d3", date.getDayOfMonth() + "");
        map.put("yyy4", date.getYear() + "");
        map.put("M4", date.getMonthValue() + "");
        map.put("d4", date.getDayOfMonth() + "");
        //这里设置需要填充的表格行数
        int length = 6;
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
                map.put("productName" + i, "商品" + i);
                map.put("model" + i, "SPR-138");
                map.put("unit" + i, "个");
                map.put("unitPrice" + i, "1");
                map.put("amount" + i, "10");
                map.put("total" + i, "10");
                map.put("remarks" + i, "");
            }
        }
        //替换模板并保存为PDF
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
    }

    /**
     * 8.委托代理销售合同补充协议 （资产系统）
     */
    public void supplementalAgreement() {
        //设置模板读取路径
        String readPath = "D:/doc/8.委托代理销售合同补充协议 （资产系统）.docx";
        //设置pdf文件保存路径
        String savePath = "D:/doc/8.委托代理销售合同补充协议 （资产系统）" + IdUtils.nextId() + ".pdf";
        Map<String, String> map = new HashMap<>(20);
        LocalDate date = LocalDate.now();
        map.put("agreementNumber", IdUtils.nextId() + "");
        map.put("agreementNumber2", IdUtils.nextId() + "");
        map.put("debtName", "张三");
        map.put("partyA", "张三");
        map.put("partyB", "李四");
        map.put("yyy1", date.getYear() + "");
        map.put("M1", date.getMonthValue() + "");
        map.put("d1", date.getDayOfMonth() + "");
        map.put("yyy2", date.getYear() + "");
        map.put("M2", date.getMonthValue() + "");
        map.put("d2", date.getDayOfMonth() + "");
        map.put("yyy3", date.getYear() + "");
        map.put("M3", date.getMonthValue() + "");
        map.put("d3", date.getDayOfMonth() + "");
        //替换模板并保存为PDF
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
    }

    /**
     * 9.和解协议 （资产系统）
     */
    public void settlementAgreement() {
        //设置模板读取路径
        String readPath = "D:/doc/9.和解协议 （资产系统）.docx";
        //设置pdf文件保存路径
        String savePath = "D:/doc/9.和解协议 （资产系统）" + IdUtils.nextId() + ".pdf";
        Map<String, String> map = new HashMap<>(20);
        LocalDate date = LocalDate.now();
        map.put("agreementNumber", IdUtils.nextId() + "");
        map.put("personName", "李四");
        map.put("debtName", "张三");
        map.put("amount", "11000");
        String situation = "三";
        map.put("situation", situation);
        //根据不同的选项替换内容
        if ("一".equals(situation)) {
            map.put("amount2", "10000");
            map.put("average", "");
            map.put("days", "");
        }
        if ("二".equals(situation)) {
            map.put("amount2", "");
            map.put("average", "2000");
            map.put("days", "15");
        }
        if ("三".equals(situation)) {
            map.put("amount2", "");
            map.put("average", "");
            map.put("days", "");
        }
        map.put("partyA", "张三");
        map.put("partyB", "李四");
        map.put("yyy1", date.getYear() + "");
        map.put("M1", date.getMonthValue() + "");
        map.put("d1", date.getDayOfMonth() + "");
        map.put("yyy2", date.getYear() + "");
        map.put("M2", date.getMonthValue() + "");
        map.put("d2", date.getDayOfMonth() + "");
        map.put("yyy3", date.getYear() + "");
        map.put("M3", date.getMonthValue() + "");
        map.put("d3", date.getDayOfMonth() + "");

        //替换模板并保存为PDF
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
    }

    /**
     * 14委托线上代理销售合同
     */
    public void onlineAgent() {
        //设置模板读取路径
        String readPath = "D:/doc/14委托线上代理销售合同.docx";
        //设置pdf文件保存路径
        String savePath = "D:/doc/14委托线上代理销售合同" + IdUtils.nextId() + ".pdf";
        Map<String, String> map = new HashMap<>(20);
        LocalDate date = LocalDate.now();
        map.put("agreementNumber", IdUtils.nextId() + "");
        map.put("client", "张三");
        map.put("idCard", "510265197612271644");
        map.put("idCardAddress", "重庆市渝中区xxxx");
        map.put("phoneNumber", "13876353678");
        map.put("yyy1", "2020");
        map.put("M1", "5");
        map.put("d1", "12");
        map.put("yyy2", "2020");
        map.put("M2", "6");
        map.put("d2", "18");
        map.put("amount", "11000");
        map.put("amountInWords", "壹万壹仟");
        map.put("fraction", "123");
        map.put("accountNumber", "67338267272");
        map.put("phoneNumber2", "17865253568");
        map.put("idCard2", "501286198702214698");
        map.put("partyA", "张三");
        map.put("partyB", "李四");
        map.put("yyy3", date.getYear() + "");
        map.put("M3", date.getMonthValue() + "");
        map.put("d3", date.getDayOfMonth() + "");
        map.put("yyy4", date.getYear() + "");
        map.put("M4", date.getMonthValue() + "");
        map.put("d4", date.getDayOfMonth() + "");
        //这里设置需要填充的表格行数
        int length = 6;
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
                map.put("productName" + i, "商品" + i);
                map.put("model" + i, "SPR-138");
                map.put("unit" + i, "个");
                map.put("unitPrice" + i, "1");
                map.put("amount" + i, "10");
                map.put("total" + i, "10");
                map.put("remarks" + i, "");
            }
        }
        map.put("total", "60");
        //替换模板并保存为PDF
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
    }

    /**
     * 收据（报备费）
     */
    public void filingFeeReceipt() {
        //设置模板读取路径
        String readPath = "D:/doc/收据（报备费）.docx";
        //设置pdf文件保存路径
        String savePath = "D:/doc/收据（报备费）" + IdUtils.nextId() + ".pdf";
        Map<String, String> map = new HashMap<>(20);
        LocalDate date = LocalDate.now();
        map.put("office1", "重庆市办事处");
        map.put("office2", "重庆市办事处");
        map.put("debtName", "张三");
        map.put("personName", "李四");
        map.put("number1", "TZFWF00002");
        map.put("number2", "TZFWF00002");
        map.put("bbCost1", "11000");
        map.put("bbCostInWords1", "壹万壹仟元整");
        map.put("bbCost2", "11000");
        map.put("bbCostInWords2", "壹万壹仟元整");
        map.put("yyy1", date.getYear() + "");
        map.put("M1", date.getMonthValue() + "");
        map.put("d1", date.getDayOfMonth() + "");
        map.put("yyy2", date.getYear() + "");
        map.put("M2", date.getMonthValue() + "");
        map.put("d2", date.getDayOfMonth() + "");
        //替换模板并保存为PDF
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
    }

    /**
     * 收据（预付款）
     */
    public void prepaymentReceipt() {
        //设置模板读取路径
        String readPath = "D:/doc/收据（预付款）.docx";
        //设置pdf文件保存路径
        String savePath = "D:/doc/收据（预付款）" + IdUtils.nextId() + ".pdf";
        Map<String, String> map = new HashMap<>(20);
        LocalDate date = LocalDate.now();
        map.put("office1", "重庆市办事处");
        map.put("debtName", "张三");
        map.put("number1", "JRYFK00002");
        map.put("moneyWay", "11000");
        map.put("moneyWayInWords", "壹万壹仟元整");
        map.put("yyy1", date.getYear() + "");
        map.put("M1", date.getMonthValue() + "");
        map.put("d1", date.getDayOfMonth() + "");
        //替换模板并保存为PDF
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
    }

    /**
     * 收据（咨询服务费）
     */
    public void consultingServiceFeeReceipt() {
        //设置模板读取路径
        String readPath = "D:/doc/收据（咨询服务费）.docx";
        //设置pdf文件保存路径
        String savePath = "D:/doc/收据（咨询服务费）" + IdUtils.nextId() + ".pdf";
        Map<String, String> map = new HashMap<>(20);
        LocalDate date = LocalDate.now();
        map.put("office1", "重庆市办事处");
        map.put("payer", "张素芳");
        map.put("number1", "TZFWF00002");
        map.put("consultingMoney", "11000");
        map.put("consultingMoneyInWords", "壹万壹仟元整");
        map.put("yyy1", date.getYear() + "");
        map.put("M1", date.getMonthValue() + "");
        map.put("d1", date.getDayOfMonth() + "");
        //替换模板并保存为PDF
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
    }

}
