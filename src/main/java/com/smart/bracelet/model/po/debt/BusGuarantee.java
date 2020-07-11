package com.smart.bracelet.model.po.debt;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @NotNull(message = "解债ID不能为空")
    private Long debtId;

    /**
     * 姓名
     */
    @NotBlank(message = "姓名不能为空")
    private String authname;

    /**
     * 身份证号码
     */
    @NotBlank(message = "身份证号码不能为空")
    private String card;

    /**
     * 选择银行
     */
    @NotBlank(message = "选择银行不能为空")
    private String bank;

    /**
     * 银行卡号
     */
    @NotBlank(message = "银行卡号不能为空")
    private String bankCard;

    /**
     * 银行预留手机号
     */
    @NotBlank(message = "银行预留手机号不能为空")
    private String bankTel;

    /**
     * 手机验证码
     */
    @NotBlank(message = "手机验证码不能为空")
    private String telCheck;

}