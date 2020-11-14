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
 * cumout_protocol
 * @author 
 */
@Data
public class CumoutProtocol implements Serializable {
    /**
     * 委托线上代理销售合同ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long protocolId;

    /**
     * 编号
     */
    @NotBlank(message = "编号不能为空")
    private String protocolNo;

    /**
     * 资产id
     */
    @NotBlank(message = "资产ID不能为空")
    private String propertId;

    /**
     * 签约时间
     */
    private String contractDate;

    BusAgentSalesContractModity[] busAgentSalesContractModity;
}