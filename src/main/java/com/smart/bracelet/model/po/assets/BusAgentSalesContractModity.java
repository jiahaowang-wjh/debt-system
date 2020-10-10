package com.smart.bracelet.model.po.assets;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * bus_agent_sales_contract_modity
 *
 * @author
 */
@Data
public class BusAgentSalesContractModity implements Serializable {

    /**
     * 代理销售合同商品ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long salesContractModityId;

    /**
     * 代理销售合同ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long salesContractId;

    /**
     * 委托线上代理销售合同ID
     */
    private Long protocolId;

    /**
     * 商品名
     */
    @NotBlank(message = "商品名不能为空")
    private String modityName;

    /**
     * 商品单价
     */
    @NotBlank(message = "商品单价不能为空")
    private String modityPlace;

    /**
     * 商品型号
     */
    @NotBlank(message = "商品型号不能为空")
    private String moditySpecificat;

    /**
     * 计量单位
     */
    @NotBlank(message = "计量单位不能为空")
    private String partyaSeal;


    /**
     * 商品数量
     */
    @NotNull(message = "商品数量不能为空")
    private Integer partybSeal;

    /**
     * 商品备注
     */
    private String partybTime;

    /**
     * 合计
     */
    @NotBlank(message = "合计不能为空")
    String moneyNum1;

}