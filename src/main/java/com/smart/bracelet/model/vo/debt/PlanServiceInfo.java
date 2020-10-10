package com.smart.bracelet.model.vo.debt;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;

/**
 * 策划服务协议初始化
 */
@Data
public class PlanServiceInfo {

    /**
     * 债事人姓名
     */
    String debtName;

    /**
     * 服务编号
     */
    String serviceNo;

    @JsonSerialize(using = ToStringSerializer.class)
    Long debtId;

    /**
     * 债事人身份证
     */
    String personCard;
    /**
     * 债事人地址(私人)
     */
    String priAdd;
    /**
     * 债事人地址(企业/银行)
     */
    String corBankAdd;
    /**
     * 债事人电话(私人)
     */
    String priPhone;
    /**
     * 债事人电话(企业/银行)
     */
    String corBankPhone;
    /**
     * 解债金额
     */
    Float amountThis;
    /**
     * 解债金额大写
     */
    String amountThisMax;

    /**
     * 策划方案服务费
     */
    String thisPlanMoney;

    /**
     * 策划方案服务费大写
     */
    String thisPlanMoneyMax;
    /**
     * 报备ID
     */
    Long reportId;
    /**
     * 性质
     */
    String reportPropert;

    /**
     * 本金
     */
    Float servicePrincipal;
    /**
     * 利息
     */
    Float serviceInterest;

    /**
     * 甲方身份
     */
    String matters;

    /**
     *签约日期
     */
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    Date contractDate;


}
