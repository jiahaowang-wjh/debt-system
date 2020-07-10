package com.smart.bracelet.model.po.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * pub_company
 * @author 
 */
@Data
public class PubCompany implements Serializable {
    private static final long serialVersionUID = -3811838743935049670L;
    /**
     * 公司ID
     */
    private Long companyId;

    /**
     * 区域id
     */
    @NotNull(message = "区域id不能为空")
    private Long areaId;

    /**
     * 公司名称
     */
    @NotBlank(message = "公司名称不能为空")
    private String companyName;

    /**
     * 公司类型
     */
    @NotBlank(message = "公司类型不能为空")
    private String companyType;

    /**
     * 公司法人
     */
    @NotBlank(message = "公司法人不能为空")
    private String companyLeperson;

    /**
     * 公司联系电话
     */
    @NotBlank(message = "公司联系电话不能为空")
    private String companyTel;

}