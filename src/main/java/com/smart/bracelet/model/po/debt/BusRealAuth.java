package com.smart.bracelet.model.po.debt;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * bus_real_auth
 *
 * @author
 */
@Data
public class BusRealAuth implements Serializable {
    private static final long serialVersionUID = -4616797975259664310L;
    /**
     * 实名ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long realId;

    /**
     * 报备ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "报备ID不能为空")
    private Long reportId;

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