package com.smart.bracelet.model.vo.debt;

import lombok.Data;

/**
 * 债事人相对人
 */
@Data
public class DebtAndPerson {
    /**
     * 报备Id
     */
    Long reportId;
    /**
     * 相对人ID
     */
    Long relativePerId;

    /**
     * 债事人身份证号
     */
    String debtIdcard;
    /**
     * 相对人身份证号
     */
    String personIdcard;


    /**
     * 相对人电话（企业、银行）
     */
    String corPhone;
    /**
     * 相对人电话（私人）
     */
    String priPhone;
    /**
     * 相对人性质
     */
    String reportPropert;
    /**
     * 债事人手机号（私人）
     */
    String perPhonePri;
    /**
     * 债事人手机号（企业或银行）
     */
    String perPhoneCor;
}
