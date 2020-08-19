package com.smart.bracelet.model.vo.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * pub_auth
 * @author 
 */
@Data
public class PubAuthVo implements Serializable {
    private static final long serialVersionUID = 4529113546954065228L;
    /**
     * 权限ID
     */
    @NotNull(message = "权限ID不能为空")
    private Long authId;

    /**
     * 菜单ID
     */
    @NotNull(message = "菜单ID不能为空")
    private Long menuId;
    /**
     * 权限名
     */
    @NotBlank(message = "权限名不能为空")
    private String authname;

    /**
     * 接口名称
     */
    private String interfacename;

    /**
     * 备注
     */
    private String note;


}