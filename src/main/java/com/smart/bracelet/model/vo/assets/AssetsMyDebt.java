package com.smart.bracelet.model.vo.assets;

import lombok.Data;

import javax.validation.constraints.NotBlank;
@Data
public class AssetsMyDebt {

    /**
     * 公司类型
     */
    @NotBlank(message = "公司类型不能为空")
    private String companyType;

}
