package com.smart.bracelet.model.po.debt;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
    @JsonSerialize(using = ToStringSerializer.class)
    private Long debtId;

    /**
     * 解债编号
     */
    private String debtNo;

    /**
     * 民事调解ID
     */
    @NotNull(message = "民事调解ID不能为空")
    private Long civilId;

    /**
     * 报备ID
     */
    @NotNull(message = "报备ID不能为空")
    private Long reportId;

    /**
     * 相对人ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "相对人ID不能为空")
    private Long relativePerId;

    /**
     * 债全总金额
     */
    @NotNull(message = "债全总金额不能为空")
    private float amountTotal;

    /**
     * 累计化解金额
     */
    @NotNull(message = "累计化解金额不能为空")
    private float amountCumulative;

    /**
     * 本次化解金额
     */
    @NotNull(message = "本次化解金额不能为空")
    private float amountThis;

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
     * 是否黄金做质押
     */
    @NotBlank(message = "是否黄金做质押不能为空")
    private String isPledge;

    /**
     * 债事化解咨询服务方案
     */
    @NotBlank(message = "债事化解咨询服务方案不能为空")
    private String servicePlan;

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
     * 策划方案服务本金
     */
    @NotNull(message = "策划方案服务本金不能为空")
    private Float servicePrincipal;

    /**
     * 策划方案服务利息
     */
    @NotNull(message = "策划方案服务利息不能为空")
    private Float serviceInterest;


    /**
     * 策划方案服务编号
     */
    String serviceNo;

    /**
     * 甲方受权代表人
     */
    @NotBlank(message = "甲方受权代表人不能为空")
    private String partyaDeputy;

    /**
     * 甲方印章
     */
    @NotBlank(message = "甲方印章不能为空")
    private String partyaSeal;

    /**
     * 甲方签约日期
     */
    @NotNull(message = "甲方签约日期不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date partyaDate;

    /**
     * 审核时间
     */
    @NotNull(message = "审核时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checkDate;

    /**
     * 乙方受权代表人
     */
    @NotBlank(message = "乙方受权代表人不能为空")
    private String partybDeputy;

    /**
     * 乙方印章
     */
    @NotBlank(message = "乙方印章不能为空")
    private String partybSeal;

    /**
     * 乙方签约日期
     */
    @NotNull(message = "乙方签约日期不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date partybDate;

    /**
     * 合同签约地点
     */
    @NotBlank(message = "合同签约地点不能为空")
    private String contractPlace;

    /**
     * 状态
     */
    @NotBlank(message = "状态不能为空")
    private String status;

    /**
     * 审核原因
     */
    @NotBlank(message = "审核原因不能为空")
    private String checkReason;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 甲方身份
     */
    @NotBlank(message = "甲方身份不能为空")
    String partyaIdentity;
    /**
     * 乙方身份
     */
    @NotBlank(message = "乙方身份不能为空")
    String partybIdentity;

    /**
     * 甲方地址
     */
    @NotBlank(message = "甲方地址不能为空")
    String partyaAddrInfo;

    /**
     * 甲方联系人
     */
    @NotBlank(message = "甲方联系人不能为空")
    String partyaPersonInfo;

    /**
     * 甲方联系电话
     */
    @NotBlank(message = "甲方联系电话不能为空")
    String partyaTelInfo;

    /**
     * 担保人集合
     */
    BusGuarantee[] busGuarantee;
}