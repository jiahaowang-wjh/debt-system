package com.smart.bracelet.model.po.debt;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * bus_pledge_property
 *
 * @author
 */
@Data
public class BusPledgeProperty implements Serializable {

    /**
     * 质押财产ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long pledgePropertyId;

    /**
     * 质押合同ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "质押合同ID不能为空")
    private Long pledgeContractId;

    /**
     * 解债ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "解债ID不能为空")
    private Long debtId;

    /**
     * 质押财产名称
     */
    @NotBlank(message = "质押财产名称不能为空")
    private String propertyName;

    /**
     * 鉴定证书号
     */
    @NotBlank(message = "鉴定证书号不能为空")
    private String propertyNo;

    /**
     * 规格
     */
    @NotBlank(message = "规格不能为空")
    private String specifications;

    /**
     * 单价
     */
    @NotNull(message = "单价不能为空")
    private Float price;

    /**
     * 金额
     */
    @NotNull(message = "金额不能为空")
    private Float amount;

    /**
     * 备注
     */
    private String note;


}