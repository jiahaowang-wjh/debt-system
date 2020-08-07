package com.smart.bracelet.model.po.assets;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * bus_compromise_agreement
 *
 * @author
 */
@Data
public class BusCompromiseAgreement implements Serializable {

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
     * 数据一
     */
    @NotNull(message = "数据一不能为空")
    private Long data1;

    /**
     * 数据二
     */
    @NotNull(message = "数据二不能为空")
    private Float data2;

    /**
     * 数据三
     */
    @NotNull(message = "数据三不能为空")
    private Integer data3;

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

}