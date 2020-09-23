package com.smart.bracelet.model.po.assets;

import com.fasterxml.jackson.annotation.JsonFormat;
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
     * 编号
     */
    @NotBlank(message = "编号不能为空")
    private String salesNo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "合同日期不能为空")
    Date contractDate;








    /**
     * 代销时间开始
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateStart;


    /**
     * 代销时间结束
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateEnd;

    /**
     * 附议
     */
    private String second;

    /**
     * 甲方盖章
     */
    private String partyaSeal;

    /**
     * 甲方时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date partyaTime;

    /**
     * 乙方盖章
     */
    private String partybSeal;

    /**
     * 乙方时间
     */
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

    /**
     * 附件
     */
    String annex;


    BusAgentSalesContractModity[] busAgentSalesContractModity;
}