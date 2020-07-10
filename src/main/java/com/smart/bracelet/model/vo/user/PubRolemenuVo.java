package com.smart.bracelet.model.vo.user;

import lombok.Data;

import java.io.Serializable;

/**
 * pub_rolemenu
 * @author 
 */
@Data
public class PubRolemenuVo implements Serializable {
    private static final long serialVersionUID = -2340299662807069492L;
    /**
     * 角色菜单ID
     */
    private Long rolemenuId;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 菜单ID
     */
    private Long menuId;


}