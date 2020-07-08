package com.smart.bracelet.model.po;

import lombok.Data;

import javax.validation.constraints.NotNull;
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
    @NotNull(message = "角色ID不能为空")
    private Long roleId;

    /**
     * 权限ID
     */
    @NotNull(message = "权限ID不能为空")
    private Long authId;


}