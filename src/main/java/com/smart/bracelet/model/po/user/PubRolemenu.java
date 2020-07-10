package com.smart.bracelet.model.po.user;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * pub_rolemenu
 * @author 
 */
@Data
public class PubRolemenu implements Serializable {
    private static final long serialVersionUID = -2075499288816921861L;
    /**
     * 角色菜单ID
     */
    private Long rolemenuId;

    /**
     * 角色ID
     */
    @NotNull(message = "角色ID不能为空")
    private Long roleId;

    /**
     * 菜单ID
     */
    @NotNull(message = "菜单ID不能为空")
    private Long menuId;


}