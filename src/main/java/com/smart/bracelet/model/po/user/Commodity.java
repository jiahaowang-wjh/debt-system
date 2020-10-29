package com.smart.bracelet.model.po.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Commodity {

    /**
     * 商品名
     */
    @NotBlank(message = "商品名不能为空")
    String modityName;
    /**
     * 商品型号
     */
    @NotBlank(message = "商品型号不能为空")
    String moditySpecificat;
    /**
     * 计量单位
     */
    @NotBlank(message = "计量单位不能为空")
    String partyaSeal;
    /**
     * 单价
     */
    @NotBlank(message = "单价不能为空")
    String modityPlace;

}
