package com.smart.bracelet.model.po.assets;

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
    private Long protocolId;

    /**
     * 编号
     */
    @NotBlank(message = "编号不能为空")
    private String protocolNo;

    /**
     * 资产id
     */
    @NotNull(message = "资产ID不能为空")
    private Long propertId;

    /**
     * 签约时间
     */
    @NotNull(message = "签约时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date protocolDate;

    BusAgentSalesContractModity[] busAgentSalesContractModity;
}