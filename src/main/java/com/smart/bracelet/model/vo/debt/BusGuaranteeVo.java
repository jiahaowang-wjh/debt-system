package com.smart.bracelet.model.vo.debt;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * bus_guarantee
 * @author 
 */
@Data
public class BusGuaranteeVo implements Serializable {
    private static final long serialVersionUID = 624406071241526679L;
    /**
     * 担保人ID
     */
    @NotNull(message = "担保人ID不能为空")
    private Long guaranteeId;

    /**
     * 民事调解ID
     */
    private Long civilId;

    /**
     * 姓名
     */
    private String authname;

    /**
     * 身份证号码
     */
    private String card;

    /**
     * 单位类型
     */
    String unitType;
    /**
     * 联系电话
     */
    String tel;
    /**
     * 地址
     */
    String address;

}