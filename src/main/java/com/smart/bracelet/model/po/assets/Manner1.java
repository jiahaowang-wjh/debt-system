package com.smart.bracelet.model.po.assets;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class Manner1 {
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

    @NotNull(message = "公司id不能为空")
    Long comId;

    /**
     * 签约日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "签约日期不能为空")
    private Date contractDate;

    /**
     * 编号
     */
    @NotBlank(message = "编号不能为空")
    String compromiseAgreementNo;

    /**
     * 支付现金
     */
    private Float cash;

    /**
     * 甲方法人代表
     */
    private String partyaSubrogation;


    /**
     * 甲方盖章
     */
    private String partyaSeal;

    /**
     * 乙方盖章
     */
    private String partybSeal;

    /**
     * 乙方法人代表
     */
    private String partybSubrogation;

    /**
     * 乙方日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date partybDate;


}
