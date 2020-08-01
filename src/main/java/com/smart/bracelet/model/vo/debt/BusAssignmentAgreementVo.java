package com.smart.bracelet.model.vo.debt;

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
     * 本人
     */
    @NotBlank(message = "本人不能为空")
    private String name;

    /**
     * 性别
     */
    @NotBlank(message = "性别不能为空")
    private String sex;

    /**
     * 出生年月
     */
    @NotNull(message = "出生年月不能为空")
    @DateTimeFormat(pattern = "yyyy-MM")
    private Date birth;

    /**
     * 身份证号码
     */
    @NotBlank(message = "身份证号码不能为空")
    private String card;

    /**
     * 债务人
     */
    @NotBlank(message = "债务人不能为空")
    private String debtPerson;

    /**
     * 借款金额
     */
    @NotNull(message = "借款金额不能为空")
    private Float loanAmount;

    /**
     * 借款利率
     */
    @NotNull(message = "借款利率不能为空")
    private Float loanInterest;

    /**
     * 借款期限
     */
    @NotBlank(message = "借款期限不能为空")
    private String loanTime;

    /**
     * 承诺人
     */
    @NotBlank(message = "承诺人不能为空")
    private String executePerson;

    /**
     * 证件号
     */
    @NotBlank(message = "证件号不能为空")
    private String executeCard;

    /**
     * 日期
     */
    @NotNull(message = "日期不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date executeDate;

}