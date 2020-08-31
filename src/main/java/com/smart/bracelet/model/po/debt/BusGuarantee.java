package com.smart.bracelet.model.po.debt;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * bus_guarantee
 *
 * @author
 */
@Data
public class BusGuarantee implements Serializable {
    private static final long serialVersionUID = 8304093116495140342L;
    /**
     * 担保人ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long guaranteeId;

    /**
     * 民事调解ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "民事调解ID不能为空")
    private Long civilId;

    /**
     * 姓名
     */
    @NotBlank(message = "姓名不能为空")
    private String authname;

    /**
     * 身份证号码
     */
    @NotBlank(message = "身份证号码不能为空")
    private String card;

    /**
     * 单位类型
     */
    @NotBlank(message = "单位类型不能为空")
    String unitType;
    /**
     * 联系电话
     */
    @NotBlank(message = "联系电话不能为空")
    String tel;
    /**
     * 地址
     */
    @NotBlank(message = "地址不能为空")
    String address;
}