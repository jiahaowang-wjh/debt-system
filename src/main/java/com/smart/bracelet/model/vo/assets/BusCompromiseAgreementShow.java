package com.smart.bracelet.model.vo.assets;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;

/**
 * 和解协议页面初始化实体
 */
@Data
public class BusCompromiseAgreementShow {

    @JsonSerialize(using = ToStringSerializer.class)
    Long propertId;

    /**
     * 债务人姓名
     */
    String personName;
    /**
     * 债权人姓名
     */
    String debtName;
    /**
     * 债权人电话号码（私人）
     */
    String priDebtPhone;

    /**
     * 债权人电话号码（企业银行）
     */
    String corBackDebtPhone;
    /**
     * 相对人电话(私人)
     */
    String personPriPhone;

    /**
     * 相对人电话（企业银行）
     */
    String personCorPhone;

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
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
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
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    Date contractDate;

    /**
     * 选择偿还方式
     */
    String partybMode;

    /**
     * 报备ID
     */
    Long reportId;

    /**
     * 债事人人性质
     */
    String debtReportPropert;

    /**
     * 债务人身份证
     */
    String idCard;
    /**
     * 相对人性质
     */
    String personReportPropert;
}
