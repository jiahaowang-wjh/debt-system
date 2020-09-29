package com.smart.bracelet.model.vo.assets;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    String average;
    /**
     * 解债日期中日的数字
     */
    String day;
    /**
     * 解债日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    Date createTime;
    /**
     * 解债类型
     */
    String debtType;

    /**
     * 解债年限
     */
    String debtYaer;

    /**
     * 期数
     */
    String number;

    /**
     * 和解编号
     */
    String compromiseAgreementNo;

    /**
     * 签约日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    Date contractDate;

    /**
     * 选择偿还方式
     */
    String partybMode;

    /**
     * 报备ID
     */
    Long reportId;

}
