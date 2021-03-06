package com.smart.bracelet.model.vo.debt;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class BusPayDetailInfo {
    /**
     * 支付ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    Long payId;
    /**
     * 报备Id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    Long reportId;

    @JsonSerialize(using = ToStringSerializer.class)
    Long debtId;

    @JsonSerialize(using = ToStringSerializer.class)
    Long propertId;

    /**
     * 报备编号
     */
    String reportNo;
    /**
     * 打款人
     */
    String payertName;
    /**
     * 支付类型
     */
    String payType;
    /**
     * 支付编号
     */
    String payNo;
    /**
     * 支付金额
     */
    @JsonSerialize(using = ToStringSerializer.class)
    Float cost;
    /**
     * 支付凭证
     */
    String voucher;
    /**
     * 支付状态
     */
    String status;

    /**
     * 阶段
     */
    String stage;

    /**
     * 合同人
     */
    String contractName;
    /**
     * 审核原因
     */
    String checkReason;
}
