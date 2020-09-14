package com.smart.bracelet.model.vo.debt;

import lombok.Data;

@Data
public class BusPayDetailInfo {
    /**
     *支付ID
     */
    Long payId;
    /**
     * 报备Id
     */
    Long reportId;
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
    Float cost;
    /**
     * 支付凭证
     */
    String voucher;
    /**
     *支付状态
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
}
