package com.smart.bracelet.model.po;

import lombok.Data;

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
    private Long roleId;

    /**
     * 菜单ID
     */
    private Long menuId;


}