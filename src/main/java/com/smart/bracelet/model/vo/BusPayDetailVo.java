package com.smart.bracelet.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * bus_pay_detail
 * @author 
 */
@Data
public class BusPayDetailVo implements Serializable {
    private static final long serialVersionUID = -1201383858936745186L;
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