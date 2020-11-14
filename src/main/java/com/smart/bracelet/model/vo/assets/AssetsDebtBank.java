package com.smart.bracelet.model.vo.assets;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;

@Data
public class AssetsDebtBank {

    /**
     * 相对人ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    Long relativePerId;
    /**
     * 审核原因
     */
    String checkReason;
    /**
     * 报备ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    Long reportId;
    /**
     * 债务人姓名
     */
    String personName;

    /**
     * 债权人
     */
    String debtName;

    /**
     * 资产ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    Long propertId;
    /**
     * 报备编号
     */
    String reportNo;
    /**
     * 解债编号
     */
    String debtNo;
    /**
     * 资产评估编号
     */
    String assessmentNo;
    /**
     * 阶段
     */
    String stage;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    Date createTime;

    /**
     * 解债类型
     */
    String debtType;

    /**
     * 状态
     */
    String status;

    /**
     * 本次解债金额
     */
    Float amountThis;

    /**
     * 解债年限
     */
    String debtYaer;

    /**
     * 货款缴费金额
     */
    String huoKuanMoney;

    /**
     * 相对人类型
     */
    String reportType;

    String debtData1;

    String personData1;

    @JsonSerialize(using = ToStringSerializer.class)
    Long payId;
}
