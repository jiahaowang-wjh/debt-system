package com.smart.bracelet.model.po.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ComPerUserInfo {

    /**
     * 角色Id
     */
    @NotNull(message = " 角色Id不能为空")
    Long roleId;

    /**
     * 公司Id
     */
    Long companyId;

    /**
     * 区域ID
     */
    @NotNull(message = "区域ID不能为空")
    Long areaId;
    /**
     * 公司名称
     */
    @NotBlank(message = "公司名称不能为空")
    String companyName;
    /**
     * 公司名称首字母缩写（大写）
     */
    @NotBlank(message = "公司名称首字母缩写不能为空")
    String companyNameMax;
    /**
     * 公司类型
     */
    @NotBlank(message = "公司类型不能为空")
    String companyType;
    /**
     * 公司法人
     */
    @NotBlank(message = "公司法人不能为空")
    String companyLeperson;
    /**
     * 公司联系电话
     */
    @NotBlank(message = "公司联系电话不能为空")
    String companyTel;
    /**
     * 人员ID
     */
    Long personId;
    /**
     * 人员名称
     */
    @NotBlank(message = "人员名称不能为空")
    String personName;
    /**
     * 人员类型
     */
    @NotBlank(message = "人员类型不能为空")
    String personType;
    /**
     * 人员性别
     */
    @NotBlank(message = "人员性别不能为空")
    String sex;
    /**
     * 年龄
     */
    @NotNull(message = "年龄不能为空")
    int age;
    /**
     * 联系电话
     */
    @NotBlank(message = "联系电话不能为空")
    String tel;
    /**
     * 人员备注
     */
    String perNote;
    /**
     * 用户ID
     */
    Long userId;
    /**
     * 登陆名
     */
    @NotBlank(message = "登陆名不能为空")
    String loginName;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    String passwordMd5;
    /**
     * 是否有效
     */
    @NotBlank(message = "是否有效不能为空")
    String isenable;
    /**
     * 用户类型
     */
    @NotBlank(message = "用户类型不能为空")
    String userType;
    /**
     * 用户备注
     */
    String userNote;
}
