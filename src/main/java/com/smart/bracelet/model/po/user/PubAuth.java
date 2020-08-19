package com.smart.bracelet.model.po.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * pub_auth
 * @author 
 */
@Data
public class PubAuth implements Serializable {
    private static final long serialVersionUID = 5813554454156426349L;
    /**
     * 权限ID
     */
    private Long authId;

    /**
     * 权限名
     */
    @NotBlank(message = "权限名不能为空")
    private String authname;

    /**
     * 菜单ID
     */
    @NotNull(message = "菜单ID不能为空")
    private Long menuId;

    /**
     * 接口名称
     */
    @NotBlank(message = "接口名不能为空")
    private String interfacename;

    /**
     * 备注
     */
    private String note;


}