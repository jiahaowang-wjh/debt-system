package com.smart.bracelet.model.vo.debt;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * 策划服务协议初始化
 */
@Data
public class PlanServiceInfo {

    /**
     * 债事人姓名
     */
    String debtName;

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
     * 乙方盖章
     */
    String partybSeal;

    /**
     * 策划方案服务费
     */
    String planMoney;

    /**
     * 策划方案服务费大写
     */
    String planMoneyMax;

    /**
     * 性质
     */
    String reportPropert;

    /**
     * 甲方地址
     */
    String partyaAddrInfo;

    /**
     * 甲方联系人
     */
    String partyaPersonInfo;

    /**
     * 甲方联系方式
     */
    String partyaTelInfo;
}
