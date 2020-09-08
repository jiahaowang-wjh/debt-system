package com.smart.bracelet.model.po.debt;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * bus_propert
 *
 * @author
 */
@Data
public class BusPropert implements Serializable {
    /**
     * 资产ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long propertId;

    /**
     * 相对人ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "相对人ID不能为空")
    private Long relativePerId;

    /**
     * 报备ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "报备ID不能为空")
    private Long reportId;

    /**
     * 民事调解ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "民事调解ID不能为空")
    private Long civilId;

    /**
     * 解债ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "解债ID不能为空")
    private Long debtId;

    /**
     * 阶段
     */
    private String stage;

    /**
     * 状态
     */
    @NotBlank(message = "状态不能为空")
    private String status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    @NotNull(message = "创建人不能为空")
    private Long createId;

}