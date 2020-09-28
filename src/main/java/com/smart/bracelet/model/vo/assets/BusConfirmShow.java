package com.smart.bracelet.model.vo.assets;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 资产债权确认实体
 */
@Data
public class BusConfirmShow {

    /**
     * 债务人姓名
     */
    String debtName;
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
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
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
     * 确认编号
     */
    String confirmNo;

    /**
     * 合同日期
     */
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    Date contractTime;

    /**
     * 解债金额
     */
    Float amountThis;


    Long reportId;

}
