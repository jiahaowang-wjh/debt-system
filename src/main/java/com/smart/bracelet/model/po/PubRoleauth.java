package com.smart.bracelet.model.po;

import lombok.Data;

import java.io.Serializable;

/**
 * pub_roleauth
 * @author 
 */
@Data
public class PubRoleauth implements Serializable {
    private static final long serialVersionUID = -4780346107081735686L;
    /**
     * 角色权限ID
     */
    private Long roleauthId;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 权限ID
     */
    private Long authId;


}