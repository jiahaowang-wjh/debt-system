package com.smart.bracelet.model.vo.assets;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * bus_agent_sales_contract
 *
 * @author
 */
@Data
public class BusAgentSalesContractVo implements Serializable {
    /**
     * 代理销售合同ID
     */
    @NotNull(message = "代理销售合同ID不能为空")
    private Long salesContractId;

    /**
     * 资产ID
     */
    @NotNull(message = "资产ID不能为空")
    private Long propertId;

    /**
     * 编号
     */
    @NotBlank(message = "编号不能为空")
    private String salesNo;

    /**
     * 寄售日期
     */
    @NotNull(message = "寄售日期不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date consignmentDate;

    /**
     * 寄售商品
     */
    @NotNull(message = "寄售商品不能为空")
    private String consignmentCommod;

    /**
     * 商品金额
     */
    @NotNull(message = "商品金额不能为空")
    private Float commodMoney;

    /**
     * 甲方户名
     */
    @NotBlank(message = "甲方户名不能为空")
    private String accountName;

    /**
     * 账号
     */
    @NotBlank(message = "账号不能为空")
    private String accountNume;

    /**
     * 开户行
     */
    @NotBlank(message = "开户行不能为空")
    private String bank;

    /**
     * 甲方签字
     */
    @NotBlank(message = "甲方签字不能为空")
    private String partyaSign;

    /**
     * 甲方盖章
     */
    @NotBlank(message = "甲方盖章不能为空")
    private String partyaSeal;

    /**
     * 甲方时间
     */
    @NotNull(message = "甲方时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date partyaTime;

    /**
     * 乙方签字
     */
    @NotBlank(message = "乙方签字不能为空")
    private String partybSign;

    /**
     * 乙方盖章
     */
    @NotBlank(message = "乙方盖章不能为空")
    private String partybSeal;

    /**
     * 乙方时间
     */
    @NotNull(message = "乙方时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date partybTime;

}