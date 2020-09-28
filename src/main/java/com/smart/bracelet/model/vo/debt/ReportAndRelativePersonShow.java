package com.smart.bracelet.model.vo.debt;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class ReportAndRelativePersonShow {

    /**
     * 报备ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    Long reportId;
    /**
     * 相对人ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    Long relativeperId;

    /**
     * 相对人姓名
     */
    String personalName;
    /**
     * 相对人法人代表
     */
    String personalLegalName;
    /**
     * 相对人社会统一信用代码/身份证
     */
    String personalIdCardCode;
    /**
     * 相对人地址
     */
    String personalAdd;
    /**
     * 相对人联系电话
     */
    String personalPhone;


    /**
     * 债事人姓名
     */
    String debtName;
    /**
     * 债事人法人代表
     */
    String debtLegalName;
    /**
     * 债事人社会统一信用代码/身份证
     */
    String debtIdCardCode;
    /**
     * 债事人地址
     */
    String debtAdd;
    /**
     * 债事人联系电话
     */
    String debtPhone;


    /**
     * 债权总额
     */
    String amountTotal;

    /**
     * 累计化解金额
     */
    String amountCumulative;


}
