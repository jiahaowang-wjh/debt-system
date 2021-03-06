package com.smart.bracelet.model.po.debt;

import cn.hutool.json.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.google.gson.JsonArray;
import com.smart.bracelet.model.vo.debt.CiviliVo;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * bus_civil
 *
 * @author
 */
@Data
public class BusCivil implements Serializable {
    /**
     * 民事调解ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long civilId;

    /**
     * 报备ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "报备ID不能为空")
    private Long reportId;

    /**
     * 相对人ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "相对人ID不能为空")
    private Long relativePerId;

    /**
     * 民事调解号
     */
    private String civilno;

    /**
     * 化解方式
     */
    private String solutions;

    /**
     * 债券债务类型
     */
    @NotBlank(message = "债券债务类型不能为空")
    private String civilType;

    /**
     * 欠款总客额
     */
    @NotNull(message = "欠款总客额不能为空")
    private Float amountTotal;

    /**
     * 欠款总客额本金
     */
    @NotNull(message = "欠款总客额本金不能为空")
    private Float amountPrincipal;

    /**
     * 欠款总客额利息
     */
    @NotNull(message = "欠款总客额利息不能为空")
    private Float amountInterest;

    /**
     * 欠款总客额违约
     */
    @NotNull(message = "欠款总客额违约不能为空")
    private Float amountBreach;

    /**
     * 月利率
     */
    @NotNull(message = "月利率不能为空")
    private Float monthInterest;

    /**
     * 时间段-开始
     */
    @NotNull(message = "时间段-开始不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date starDate;

    /**
     * 时间段-结束
     */
    @NotNull(message = "时间段-结束不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date endDate;

    /**
     * 利息
     */
    @NotNull(message = "利息不能为空")
    private Float interest;

    /**
     * 已支付利息
     */
    @NotNull(message = "已支付利息不能为空")
    private Float interestPayment;

    /**
     * 违约截止时间
     */
    @NotNull(message = "违约截止时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date breachDate;

    /**
     * 已支付违约金额
     */
    @NotNull(message = "已支付违约金额不能为空")
    private Float breachMoney;

    /**
     * 担保方式
     */
    @NotBlank(message = "担保方式不能为空")
    private String guaranteeMeth;

    /**
     * 本息金额合计
     */
    @NotNull(message = "本息金额合计不能为空")
    private Float interestAll;

    /**
     * 债事人自愿放弃内容
     */
    @NotBlank(message = "债事人自愿放弃内容不能为空")
    private String abandonContent;

    /**
     * 债务处理方式
     */
    private String treatmentMethod;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date updateTime;

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
     * 担保人集合
     */
   BusGuarantee[] busGuarantee;

    /**
     * 用户Id（调解员）
     */
    Long[] longs;

    /**
     * 凭证
     */
    String certificate;

    /**
     * 调解人员集合
     */
    CiviliVo[] civiliVos;

    /**
     * 债务形成原因
     */
    String debtReason;

}