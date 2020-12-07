package com.smart.bracelet.model.vo.assets;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 资产债权转让通知书页面初始化实体
 */
@Data
public class BusAssignmentNoticeShow {

    Long reportId;

    String debtIdCardCor;
    String idCardCor;
    /**
     * 债务人姓名
     */
    String personName;

    /**
     *债权人姓名
     */
    String debtName;
    /**
     * 债权人性质
     */
    String debtPropert;

    /**
     * 债权人身份证号
     */
    String debtIdCard;

    /**
     * 债权人手机号私人
     */
    String debtPhonePri;

    /**
     * 债权人手机号企业或银行
     */
    String debtPhoneCor;

    /**
     *债务人身份证号
     */
    String idCard;

    /**
     * 债务人性质
     */
    String perPropert;

    /**
     * 债务人手机号私人
     */
    String perPhonePri;
    /**
     * 债务人手机号 企业或银行
     */
    String perPhoneCor;
    /**
     *债事原因
     */
    String personReason;
    /**
     *解债金额
     */
    Float amountThis;

    /**
     *债权转让协议编号
     */
    String assignmentAgreementNo;

    /**
     * 通知书编号
     */
    String noticeNo;


    /**
     * 签约日期
     */
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    Date contractTime;
}
