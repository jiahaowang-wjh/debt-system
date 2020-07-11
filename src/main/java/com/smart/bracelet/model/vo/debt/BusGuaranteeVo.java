package com.smart.bracelet.model.vo.debt;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * bus_guarantee
 * @author 
 */
@Data
public class BusGuaranteeVo implements Serializable {
    private static final long serialVersionUID = 624406071241526679L;
    /**
     * 担保人ID
     */
    @NotNull(message = "担保人ID不能为空")
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