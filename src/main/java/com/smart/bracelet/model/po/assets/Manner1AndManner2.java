package com.smart.bracelet.model.po.assets;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class Manner1AndManner2 {
    /**
     * 和解协议ID
     */
    private Long compromiseAgreementId;

    /**
     * 资产ID
     */
    @NotNull(message = "资产ID不能为空")
    private Long propertId;

    /**
     * 乙方清偿债务
     */
    @NotBlank(message = "乙方清偿债务不能为空")
    private String partybMode;

    /**
     *支付现金
     */
    @NotNull(message = "支付现金不能为空")
    private Long cash;

    /**
     * 分期期数
     */
    @NotNull(message = "数据一不能为空")
    private Long StagingNumber;

    /**
     * 每期还款金额
     */
    @NotNull(message = "数据二不能为空")
    private Float money;

    /**
     * 每期还款日
     */
    @NotNull(message = "数据三不能为空")
    private Integer days;



    /**
     * 甲方法人代表
     */
    @NotBlank(message = "甲方法人代表不能为空")
    private String partyaSubrogation;

    /**
     * 甲方日期
     */
    @NotNull(message = "甲方日期不能为空")
    private Date partyaDate;

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
     * 乙方法人代表
     */
    @NotBlank(message = "乙方法人代表不能为空")
    private String partybSubrogation;

    /**
     * 乙方日期
     */
    @NotNull(message = "乙方日期不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date partybDate;

    /**
     * 类型
     */
    private String type;


}
