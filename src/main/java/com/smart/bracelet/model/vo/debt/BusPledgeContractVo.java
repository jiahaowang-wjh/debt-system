package com.smart.bracelet.model.vo.debt;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * bus_pledge_contract
 *
 * @author
 */
@Data
public class BusPledgeContractVo implements Serializable {
    /**
     * 质押合同ID
     */
    @NotNull(message = "质押合同ID不能为空")
    private Long pledgeContractId;

    /**
     * 解债ID
     */
    @NotNull(message = "解债ID不能为空")
    private Long debtId;

    /**
     * 签订日期
     */
    @NotNull(message = "签订日期不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date contractDate;

    /**
     * 合同编号
     */
    @NotBlank(message = "合同编号不能为空")
    private String contractNo;

    /**
     * 质押期现开始
     */
    @NotNull(message = "质押期现开始不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    /**
     * 质押期现结束
     */
    @NotNull(message = "质押期现结束不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    /**
     * 质权人传真
     */
    @NotBlank(message = "质权人传真不能为空")
    private String pledgFax;

    /**
     * 质权人联系人
     */
    @NotBlank(message = "质权人联系人不能为空")
    private String pledgPerson;

    /**
     * 质权人地址
     */
    @NotBlank(message = "不能为空")
    private String pledgAddress;

    /**
     * 质权人电话
     */
    @NotBlank(message = "质权人电话不能为空")
    private String pledgPhone;

    /**
     * 甲方名称
     */
    @NotBlank(message = "甲方名称不能为空")
    private String partyaName;

    /**
     * 甲方法人代表代权
     */
    @NotBlank(message = "甲方法人代表代权不能为空")
    private String partyaLegal;

    /**
     * 甲方日期
     */
    @NotBlank(message = "甲方日期不能为空")
    private String partyaDate;

    /**
     * 出质人
     */
    @NotBlank(message = "出质人不能为空")
    private String pledger;

    /**
     * 甲方法人代表授权
     */
    @NotBlank(message = "甲方法人代表授权不能为空")
    private String partyaDeputy;

}