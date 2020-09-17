package com.smart.bracelet.model.vo.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * pub_rolemenu
 *
 * @author
 */
@Data
public class PubRolemenuVo implements Serializable {
    private static final long serialVersionUID = -2340299662807069492L;
    /**
     * 角色菜单ID
     */
    @NotNull(message = "角色菜单ID不能为空")
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