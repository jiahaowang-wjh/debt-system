package com.smart.bracelet.service.doc;

import com.smart.bracelet.exception.CustomerException;

import java.text.ParseException;

/**
 * TODO:
 *
 * @author liuzq
 * @version 1.0
 * @date 2020/9/20
 **/
public interface BusWordConversionService {

    /**
     * 填充Word并保存为指定格式（暨尽协议）
     */
    Long fillInWordAndSaveAsSpecifyFormatCumOut(Long reportId, Long comId) throws CustomerException, ParseException;


    /**
     * 填充Word并保存为指定格式（策划方案）
     */
    void fillInWordAndSaveAsSpecifyFormatPlan(Long debtId,Long comId) throws CustomerException;

    /**
     * 填充Word并保存为指定格式（债权转让协议）
     */
    void fillInWordAndSaveAsSpecifyFormatTransfer(Long propertId,Long comId) throws CustomerException, ParseException;


    /**
     * 填充Word并保存为指定格式（债权转让确认书）
     */
    void fillInWordAndSaveAsSpecifyFormatConfrim(Long propertId) throws CustomerException, ParseException;

    /**
     * 填充Word并保存为指定格式（债权转让通知书）
     */
    void fillInWordAndSaveAsSpecifyFormatNotice(Long propertId) throws CustomerException, ParseException;

    /**
     * 填充Word并保存为指定格式（债权确认书）
     */
    void fillInWordAndSaveAsSpecifyFormatProve(Long propertId) throws CustomerException, ParseException;


    /**
     * 填充Word并保存为指定格式（催款函）
     */
    void fillInWordAndSaveAsSpecifyFormatLetter(Long propertId,Long comId) throws CustomerException, ParseException;

    /**
     * 填充Word并保存为指定格式（委托代理销售合同）
     */
    void fillInWordAndSaveAsSpecifyFormatConsignment(Long propertId,Long comId) throws CustomerException, ParseException;


    /**
     * 填充Word并保存为指定格式（和解协议）
     */
    void fillInWordAndSaveAsSpecifyFormatReconciliation(Long propertId,Long comId) throws CustomerException, ParseException;

    /**
     * 填充Word并保存为指定格式（委托线上代理销售合同）
     */
    void fillInWordAndSaveAsSpecifyFormatOnlineCons(Long propertId,Long comId) throws CustomerException, ParseException;



    /**
     * 填充Word并保存为指定格式（报备费发票）
     */
    void fillInWordAndSaveAsSpecifyFormatReportFee(Long reportId,String parta,String partaCard,String partaTel) throws CustomerException, ParseException;


    /**
     * 填充Word并保存为指定格式（咨询服务费发票）
     */
    void fillInWordAndSaveAsSpecifyFormatdvisory(Long reportId,String parta,String partaCard,String partaTel) throws CustomerException, ParseException;

    /**
     * 填充Word并保存为指定格式（货款务费发票）
     */
    void fillInWordAndSaveAsSpecifyPayment(Long reportId,String parta,String partaCard,String partaTel) throws CustomerException, ParseException;

}
