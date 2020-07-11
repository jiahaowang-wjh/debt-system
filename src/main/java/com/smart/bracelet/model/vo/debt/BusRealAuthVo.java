package com.smart.bracelet.model.vo.debt;

import lombok.Data;

import java.io.Serializable;

/**
 * bus_real_auth
 * @author 
 */
@Data
public class BusRealAuthVo implements Serializable {
    private static final long serialVersionUID = 3778427708323786019L;
    /**
     * 实名ID
     */
    private Long realId;

    /**
     * 报备ID
     */
    private Long reportId;

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