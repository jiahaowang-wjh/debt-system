package com.smart.bracelet.model;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户信息表(UserInfo)实体类
 *
 * @author junyunxiao
 * @since 2020-06-30 17:08:10
 */
public class UserInfo implements Serializable {
    private static final long serialVersionUID = -94848992291691863L;
    /**
    * 用户信息Id
    */
    private Long userInfoId;
    /**
    * 用户名
    */
    private String userAccount;
    /**
    * 用户密码，默认密码为身份证后6位，需要引导用户修改默认密码
    */
    private String userPwd;
    /**
    * 姓名
    */
    private String userName;
    /**
    * 身份证号
    */
    private String identificationNumber;
    /**
    * 手机号码
    */
    private String phoneNumber;
    /**
    * 出生日期
    */
    private String userBirthday;
    /**
    * 头像
    */
    private String userAvatar;
    /**
    * 性别(0:女，1:男)
    */
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


    public Long getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(Long userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}
