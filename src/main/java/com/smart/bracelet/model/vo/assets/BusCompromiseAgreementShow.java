package com.smart.bracelet.model.vo.assets;

import lombok.Data;

import java.util.Date;

/**
 * 和解协议页面初始化实体
 */
@Data
public class BusCompromiseAgreementShow {

    /**
     * 债务人姓名
     */
    String personName;
    /**
     * 债权人姓名
     */
    String debtName;
    /**
     * 解债金额小写
     */
    Float amountThis;
    /**
     * 解债每期贷款
     */
    /**
     * 解债日期中日的数字
     */
    String day;
    /**
     * 解债日期
     */
    Date createTime;
}
