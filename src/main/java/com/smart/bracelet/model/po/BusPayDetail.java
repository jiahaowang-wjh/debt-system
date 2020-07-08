package com.smart.bracelet.model.po;

import lombok.Data;

import java.io.Serializable;

/**
 * bus_pay_detail
 * @author 
 */
@Data
public class BusPayDetail implements Serializable {
    private static final long serialVersionUID = 226682686868341733L;
    /**
     * 支付ID
     */
    private Long payId;

    /**
     * 报备ID
     */
    private Long reportId;

    /**
     * 合同姓名
     */
    private String contractName;

    /**
     * 打款人姓名
     */
    private String payertName;

    /**
     * 凭证
     */
    private String voucher;

    /**
     * 费用
     */
    private String cost;

    /**
     * 标志
     */
    private String flag;

}