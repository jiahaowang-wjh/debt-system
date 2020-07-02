package com.smart.bracelet.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.io.Serializable;

/**
 * 用户信息表(UserInfo)实体类
 *
 * @author junyunxiao
 * @since 2020-06-30 17:08:10
 */
@Data
public class UserInfo implements Serializable {
    private static final long serialVersionUID = -2441639470450172630L;
    /**
    * 用户信息Id
    */
    private Long userInfoId;
    /**
    * 用户名
    */
    @NotBlank(message = "用账号不能为空")
    private String userAccount;
    /**
    * 用户密码，默认密码为身份证后6位，需要引导用户修改默认密码
    */
    @NotBlank(message = "用户密码不能为空")
    private String userPwd;
    /**
    * 姓名
    */
    @NotBlank(message = "用户姓名不能为空")
    private String userName;
    /**
    * 身份证号
    */
    @NotBlank(message = "用户身份证号不能为空")
    private String identificationNumber;
    /**
    * 手机号码
    */
    @NotBlank(message = "用户手机号码不能为空")
    private String phoneNumber;
    /**
    * 出生日期
    */
    @NotBlank(message = "用户出生日期不能为空")
    private String userBirthday;
    /**
    * 头像
    */
    private String userAvatar;
    /**
    * 性别(0:女，1:男)
    */
    @NotBlank(message = "用户性别不能为空")
    private String userSex;
    /**
    * 用户状态 (0:锁定，1:正常，默认状态为正常)
    */
    private String userStatus;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;
    /**
    * 备注
    */
    private String remarks;

}
