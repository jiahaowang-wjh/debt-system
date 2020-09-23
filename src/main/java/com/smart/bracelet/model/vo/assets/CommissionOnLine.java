package com.smart.bracelet.model.vo.assets;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class CommissionOnLine {


    /**
     * 性质
     */
    String reportPropert;

    /**
     *债权人姓名
     */
    String debtName;
    /**
     *地址（私人）
     */
    String priAdd;
    /**
     *地址（企业或银行）
     */
    String corBankAdd;
    /**
     *身份证
     */
    String debtIdCard;
    /**
     *电话（私人）
     */
    String priPhone;
    /**
     *电话（企业或银行）
     */
    String corBankPhone;
    /**
     *解债金额
     */
    Float amountThis;

    /**
     *解债开始日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    Date createTime;

    /**
     * 截至日期
     */
    String endTime;
    /**
     *解债年限
     */
    String debtYaer;

    /**
     * 编号
     */
    String protocolNo;

    /**
     * 积分
     */
    String integral;

}
