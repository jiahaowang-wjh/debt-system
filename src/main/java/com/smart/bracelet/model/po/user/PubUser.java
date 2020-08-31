package com.smart.bracelet.model.po.user;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * pub_user
 * @author 
 */
@Data
public class PubUser implements Serializable {
    private static final long serialVersionUID = -8802089460831739668L;
    /**
     * 用户ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;


    /**
     * 人员ID
     */
    @NotNull(message = "人员ID不能为空")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long personId;

    /**
     * 角色ID
     */
    @NotNull(message = "角色Id不能为空")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long roleId;

    /**
     * 登陆名
     */
    @NotBlank(message = "登录名不能为空")
    private String loginName;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String passwordMd5;


    /**
     * 是否有效
     */
    private String isenable;

    /**
     * 备注
     */
    private String note;


}