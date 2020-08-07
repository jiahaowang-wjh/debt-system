package com.smart.bracelet.model.vo.assets;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * bus_bank_guarante
 *
 * @author
 */
@Data
public class BusBankGuaranteVo implements Serializable {

    /**
     * 银行保函ID
     */
    @NotNull(message = "银行保函ID不能为空")
    private Long bankGuaranteId;

    /**
     * 资产ID
     */
    @NotNull(message = "资产ID不能为空")
    private Long propertId;

    /**
     * 甲方签字
     */
    @NotBlank(message = "甲方签字不能为空")
    private String partyaSign;

    /**
     * 甲方日期
     */
    @NotNull(message = "甲方日期不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
     * 乙方签字
     */
    @NotBlank(message = "乙方签字不能为空")
    private String partybSign;

    /**
     * 乙方日期
     */
    @NotNull(message = "乙方日期不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date partybDate;

    /**
     * 合同地点
     */
    @NotBlank(message = "合同地点不能为空")
    private String contractPlace;

}