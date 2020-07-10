package com.smart.bracelet.model.vo.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * pub_user
 * @author 
 */
@Data
public class PubUserVo implements Serializable {

    private static final long serialVersionUID = 1035311812340605920L;
    /**
     * 用户ID
     */
    @NotNull(message = "用户ID不能为空")
    private Long userId;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 人员ID
     */
    private Long personId;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 登陆名
     */
    private String loginName;

    /**
     * 密码
     */
    private String passwordMd5;

    /**
     * 用户图像
     */
    private String userAvatar;

    /**
     * 是否有效
     */
    private String isenable;

    /**
     * 备注
     */
    private String note;
}