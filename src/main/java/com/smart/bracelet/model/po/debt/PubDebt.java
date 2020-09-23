package com.smart.bracelet.model.po.debt;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * pub_debt
 *
 * @author
 */
@Data
public class PubDebt implements Serializable {
    /**
     * 解债ID
     */
    private Long debtId;

    /**
     * 报备ID
     */
    @NotNull(message = "报备ID不能为空")
    private Long reportId;

    /**
     * 相对人ID
     */
    @NotNull(message = "相对人ID不能为空")
    private Long relativePerId;

    /**
     * 民事调解ID
     */
    @NotNull(message = "民事调解ID不能为空")
    private Long civilId;

    /**
     * 解债编号
     */
    private String debtNo;

    /**
     * 状态
     */
    private String status;

    /**
     * 审核原因
     */
    private String checkReason;

    /**
     * 审核时间
     */
    private Date checkDate;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;


    /**
     * 本次策划方案服务费
     */
    @NotNull(message = "本次策划方案服务费不能为空")
    private Float thisPlanMoney;

    /**
     * 债全总金额
     */
    @NotNull(message = "债全总金额不能为空")
    private Float amountTotal;

    /**
     * 累计化解金额
     */
    @NotNull(message = "累计化解金额不能为空")
    private Float amountCumulative;

    /**
     * 本次申请转让债权金额
     */
    @NotNull(message = "本次申请转让债权金额不能为空")
    private Float amountThis;

    /**
     * 解债类型
     */
    @NotBlank(message = "解债类型不能为空")
    private String debtType;

    /**
     * 解债年份
     */
    @NotBlank(message = "解债年份不能为空")
    private String debtYaer;

    /**
     * 甲方身份情况
     */
    @NotBlank(message = "甲方身份情况不能为空")
    private String partyaIdentity;

    /**
     * 乙方身份情况
     */
    @NotBlank(message = "乙方身份情况不能为空")
    private String partybIdentity;

    /**
     * 甲方确认送达地址
     */
    @NotBlank(message = "甲方确认送达地址不能为空")
    private String partyaAddr;

    /**
     * 甲方确认送达联系人
     */
    @NotBlank(message = "甲方确认送达联系人不能为空")
    private String partyaPerson;

    /**
     * 甲方确认送达联系电话
     */
    @NotBlank(message = "甲方确认送达联系电话不能为空")
    private String partyaTel;

    /**
     * 乙方确认送达地址
     */
    @NotBlank(message = "乙方确认送达地址不能为空")
    private String partybAddr;

    /**
     * 乙方确认送达联系人
     */
    @NotBlank(message = "乙方确认送达联系人不能为空")
    private String partybPerson;

    /**
     * 乙方确认送达联系电话
     */
    @NotBlank(message = "乙方确认送达联系电话不能为空")
    private String partybTel;

    /**
     * 服务编号
     */
    private String serviceNo;

    /**
     * 策划服务日期
     */
    private Date serviceDate;

    /**
     * 委托事项
     */
    private String matters;

    /**
     * 签约日期
     */
    private Date contractDate;

    /**
     * 本金
     */
    Float servicePrincipal;

    /**
     * 利息
     */
    Float serviceInterest;
}