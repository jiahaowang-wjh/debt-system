package com.smart.bracelet.model.vo.assets;

import lombok.Data;

import java.util.Date;

/**
 * 债权转让确认书页面初始化实体
 */
@Data
public class BusConfirmShow {

    /**
     * 债务人姓名
     */
    String debtName;

    /**
     *债务人身份证号
     */
    String personCard;

    /**
     * （私人性质）债务人电话
     */
    String priPhone;

    /**
     * （企业/银行性质）债务人电话
     */
    String corBankPhone;

    /**
     * 债权人姓名
     */
    String personName;
    /**
     * 债权转让协议编号
     */
    String assignmentAgreementNo;
    /**
     * 解债日期
     */
    Date createTime;
    /**
     * 本金
     */
    Float servicePrincipal;
    /**
     * 利息
     */
    Float serviceInterest;

    /**
     * 性质
     */
    String reportPropert;
}
