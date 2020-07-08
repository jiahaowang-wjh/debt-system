package com.smart.bracelet.model.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * pub_role
 * @author 
 */
@Data
public class PubRoleVo implements Serializable {

    private static final long serialVersionUID = 5119376141965875789L;
    /**
     * 角色ID
     */
    @NotNull(message = "角色Id不能为空")
    private Long roleId;

    /**
     * 角色名
     */
    private String rolename;

    /**
     * 是否有效
     */
    private String isenable;

    /**
     * 备注
     */
    private String note;


}