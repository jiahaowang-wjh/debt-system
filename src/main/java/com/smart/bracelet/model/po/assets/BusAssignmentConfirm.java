package com.smart.bracelet.model.po.assets;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * bus_assignment_confirm
 *
 * @author
 */
@Data
public class BusAssignmentConfirm implements Serializable {
    /**
     * 确认ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long posseConfirmtId;

    /**
     * 资产ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "资产ID不能为空")
    private Long propertId;

    /**
     * 签约日期
     */
    @NotNull(message = "签约日期不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date signDate;

    /**
     * 编号
     */
    @NotNull(message = "编号不能为空")
    private String confirmNo;

    /**
     * 债权人姓名
     */
    private String creditorName;

    /**
     * 债权人签字-盖章
     */
    private String creditorSign;

    /**
     * 唯一编码
     */
    private String noCode;


    /**
     * 担保人
     */
    private String guarantee;


    /**
     * 资产公司名称
     */
    private String assetsCompanyName;

    /**
     * 资产证号
     */
    private String assetsCard;

    /**
     * 资产签约日期
     */
    private Date assetsDate;

    /**
     * 法定代表
     */
    private String legalRepresen;

    /**
     * 法定代表签约日期
     */
    private Date legalRepresenDate;

    /**
     * 债务人
     */
    private String obligor;

    /**
     * 债务人签字-盖章
     */
    private String obligorSign;

    /**
     * 身份证号
     */
    private String obligorIdcard;

    /**
     * 债务人签约日期
     */
    private Date obligorDate;

}