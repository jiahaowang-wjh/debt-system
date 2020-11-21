package com.smart.bracelet.model.vo.user;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * pub_user
 *
 * @author
 */
@Data
public class PubUserVo implements Serializable {

    private static final long serialVersionUID = 1035311812340605920L;
    /**
     * 用户ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "用户ID不能为空")
    private Long userId;


    /**
     * 人员ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "人员ID不能为空")
    private Long personId;

    /**
     * 角色ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "角色Id不能为空")
    private Long roleId;

    /**
     * 登陆名
     */
    @NotBlank(message = "登录名不能为空")
    private String loginName;

    /**
     * 密码
     */
    private String passwordMd5;

    /**
     * 是否有效
     */
    private String isenable;

    /**
     * 备注
     */
    private String note;

    /**
     * 用户类型
     */
    @NotBlank(message = "用户类型不能为空")
    private String userType;

}