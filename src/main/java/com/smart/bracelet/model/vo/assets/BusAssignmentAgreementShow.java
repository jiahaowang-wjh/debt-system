package com.smart.bracelet.model.vo.assets;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 资产债权转让协议页面初始化实体
 */
@Data
public class BusAssignmentAgreementShow {

    /**
     * 解债类型
     */
    String debtType;
    /**
     * 债权人姓名
     */
    String debtName;
    /**
     * 债权人身份证号
     */
    String idCard;
    /**
     * 债权人地址(私人)
     */
    String priAdd;
    /**
     * 债权人地址(企业/银行)
     */
    String corBankAdd;
    /**
     * 债权人电话(私人)
     */
    String priPhone;
    /**
     * 债权人电话(企业/银行)
     */
    String corBankPhone;
    /**
     * 债务人性质
     */
    String reportPriPropert;
    /**
     * 债务人姓名
     */
    String personName;

    /**
     * 债务人身份证号
     */
    String personCard;

    /**
     * 债务人手机号私人
     */
    String personPriPhone;
    /**
     * 债务人手机号企业或银行
     */
    String personCorBackPhone;

    /**
     * 借款发生时间务
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    Date obligatTime;

    /**
     * 解债金额
     */
    Float amountThis;
    /**
     * 咨询服务费本金
     */
    Float servicePrincipal;
    /**
     * 咨询服务费利息
     */
    Float serviceInterest;
    /**
     * 解债年限
     */
    String debtYaer;
    /**
     * 甲方支付现金
     */
    String money;
    /**
     * 性质
     */
    String reportPropert;

    /**
     * 债权转让协议编号
     */
    String assignmentAgreementNo;

    /**
     * 当前时间
     */
    String thisTime;

    /**
     * 签约日期
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    Date contractTime;

    /**
     * 报备ID
     */
    Long reportId;

    /**
     * 债权人电话企业或银行
     */
    String debtPhoneCor;

    /**
     * 债权人电话私人
     */
    String debtPhonePri;
    /**
     * 债权人性质
     */
    String debtPropert;

    String idCardCor;
}
