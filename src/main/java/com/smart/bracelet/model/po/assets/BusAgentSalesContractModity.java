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
    private Long salesContractModityId;

    /**
     * 代理销售合同ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "代理销售合同ID不能为空")
    private Long salesContractId;

    /**
     * 商品名
     */
    @NotBlank(message = "商品名不能为空")
    private String modityName;

    /**
     * 商品产地
     */
    @NotBlank(message = "商品产地不能为空")
    private String modityPlace;

    /**
     * 商品规格
     */
    @NotBlank(message = "商品规格不能为空")
    private String moditySpecificat;

    /**
     * 计量单位
     */
    @NotBlank(message = "计量单位不能为空")
    private String partyaSeal;

    /**
     * 商品包装
     */
    @NotBlank(message = "商品包装不能为空")
    private String partyaTime;

    /**
     * 商品数量
     */
    @NotNull(message = "商品数量不能为空")
    private Integer partybSeal;

    /**
     * 商品备注
     */
    private String partybTime;


}