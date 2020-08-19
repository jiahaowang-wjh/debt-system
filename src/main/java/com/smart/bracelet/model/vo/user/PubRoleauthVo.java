package com.smart.bracelet.model.vo.user;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * pub_roleauth
 *
 * @author
 */
@Data
public class PubRoleauthVo implements Serializable {
    private static final long serialVersionUID = 3174881850325924442L;
    /**
     * 角色权限ID
     */
    @NotNull(message = "角色权限ID不能为空")
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
    /**
     * 备注
     */
    private String note;

}