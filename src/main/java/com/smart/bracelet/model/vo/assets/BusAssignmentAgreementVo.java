package com.smart.bracelet.model.vo.assets;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * bus_assignment_agreement
 *
 * @author
 */
@Data
public class BusAssignmentAgreementVo implements Serializable {

    /**
     * 转让协议ID
     */
    @NotNull(message = "转让协议ID不能为空")
    private Long assignmentAgreementId;

    /**
     * 资产ID
     */
    @NotNull(message = "资产ID不能为空")
    private Long propertId;

    /**
     * 债事化解方式
     */
    @NotBlank(message = "债事化解方式不能为空")
    private String defuseWay;

    /**
     * 预付货款方式
     */
    @NotBlank(message = "预付货款方式不能为空")
    private String moneyWay;

    /**
     * 协议日期
     */
    @NotNull(message = "协议日期不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date agreementDate;

    /**
     * 协议截止日期
     */
    @NotNull(message = "协议截止日期不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date agreementDateEnd;

    /**
     * 甲方盖章
     */
    @NotBlank(message = "甲方盖章不能为空")
    private String partyaSeal;

    /**
     * 乙方盖章
     */
    @NotBlank(message = "乙方盖章不能为空")
    private String partybSeal;

    /**
     * 甲方签约时间
     */
    @NotNull(message = "甲方签约时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date partyaSignupTime;

    /**
     * 乙方签约时间
     */
    @NotNull(message = "乙方签约时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date partybSignupTime;

    /**
     * 签约地
     */
    @NotBlank(message = "签约地不能为空")
    private String signupAddr;

}