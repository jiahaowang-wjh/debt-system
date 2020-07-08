package com.smart.bracelet.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * pub_roleauth
 * @author 
 */
@Data
public class PubRoleauthVo implements Serializable {
    private static final long serialVersionUID = 3174881850325924442L;
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