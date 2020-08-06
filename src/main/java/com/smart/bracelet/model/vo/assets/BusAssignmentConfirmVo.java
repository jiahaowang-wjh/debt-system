package com.smart.bracelet.model.vo.assets;

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
public class BusAssignmentConfirmVo implements Serializable {
    /**
     * 确认ID
     */
    @NotNull(message = "确认ID不能为空")
    private Long posseConfirmtId;

    /**
     * 资产ID
     */
    @NotNull(message = "资产ID不能为空")
    private Long propertId;

    /**
     * 编号
     */
    @NotBlank(message = "编号不能为空")
    private String confirmNo;

    /**
     * 债权人姓名
     */
    @NotBlank(message = "债权人姓名不能为空")
    private String creditorName;

    /**
     * 债权人签字-盖章
     */
    @NotBlank(message = "债权人签字不能为空")
    private String creditorSign;

    /**
     * 唯一编码
     */
    @NotBlank(message = "唯一编码不能为空")
    private String noCode;

    /**
     * 签约日期
     */
    @NotNull(message = "签约日期不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date signDate;

    /**
     * 担保人
     */
    @NotBlank(message = "担保人不能为空")
    private String guarantee;

    /**
     * 担保编号
     */
    @NotBlank(message = "担保编号不能为空")
    private String guaranteeNo;

    /**
     * 资产公司名称
     */
    @NotBlank(message = "资产公司名称不能为空")
    private String assetsCompanyName;

    /**
     * 资产证号
     */
    @NotBlank(message = "资产证号不能为空")
    private String assetsCard;

    /**
     * 资产签约日期
     */
    @NotNull(message = "资产签约日期不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date assetsDate;

    /**
     * 法定代表
     */
    @NotBlank(message = "法定代表不能为空")
    private String legalRepresen;

    /**
     * 法定代表签约日期
     */
    @NotNull(message = "法定代表签约日期不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date legalRepresenDate;

    /**
     * 债务人
     */
    @NotBlank(message = "债务人不能为空")
    private String obligor;

    /**
     * 债务人签字-盖章
     */
    @NotBlank(message = "债务人签字-盖章不能为空")
    private String obligorSign;

    /**
     * 身份证号
     */
    @NotBlank(message = "身份证号不能为空")
    private String obligorIdcard;

    /**
     * 债务人签约日期
     */
    @NotNull(message = "债务人签约日期不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date obligorDate;

}