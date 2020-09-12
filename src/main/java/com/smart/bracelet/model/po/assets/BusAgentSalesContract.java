package com.smart.bracelet.model.po.assets;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
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
public class BusAgentSalesContract implements Serializable {

    /**
     * 代理销售合同ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long salesContractId;

    /**
     * 资产ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "资产ID不能为空")
    private Long propertId;

    /**
     * 代销时间开始
     */
    @NotNull(message = "代销时间开始不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateStart;

    /**
     * 附件
     */
    String annex;

    /**
     * 编号
     */
    private String salesNo;

    /**
     * 代销时间结束
     */
    @NotNull(message = "代销时间结束不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateEnd;

    /**
     * 附议
     */
    @NotBlank(message = "附议不能为空")
    private String second;

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

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    BusAgentSalesContractModity[] busAgentSalesContractModity;
}