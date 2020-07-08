package com.smart.bracelet.model.po;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * pub_role
 * @author 
 */
@Data
public class PubRole implements Serializable {
    private static final long serialVersionUID = -2736594286561874485L;
    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 角色名
     */
    @NotBlank(message = "角色名不能为空")
    private String rolename;

    /**
     * 是否有效
     */
    private String isenable;

    /**
     * 备注
     */
    private String note;

}