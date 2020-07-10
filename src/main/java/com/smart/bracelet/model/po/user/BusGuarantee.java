package com.smart.bracelet.model.po.user;

import lombok.Data;

import java.io.Serializable;

/**
 * bus_guarantee
 * @author 
 */
@Data
public class BusGuarantee implements Serializable {
    private static final long serialVersionUID = 8304093116495140342L;
    /**
     * 担保人ID
     */
    private Long guaranteeId;

    /**
     * 解债ID
     */
    private Long debtId;

    /**
     * 姓名
     */
    private String authname;

    /**
     * 身份证号码
     */
    private String card;

    /**
     * 选择银行
     */
    private String bank;

    /**
     * 银行卡号
     */
    private String bankCard;

    /**
     * 银行预留手机号
     */
    private String bankTel;

    /**
     * 手机验证码
     */
    private String telCheck;

}