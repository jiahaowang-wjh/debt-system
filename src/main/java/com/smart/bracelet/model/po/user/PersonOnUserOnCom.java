package com.smart.bracelet.model.po.user;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 用户人员公司实体类
 */
@Data
public class PersonOnUserOnCom {

    /**
     * 人员ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long personId;

    /**
     * 备注
     */
    private String note;
    /**
     * 人员名称
     */
    private String personName;
    /**
     * 人员性别
     */
    private String sex;
    /**
     * 人员类型
     */
    private String personType;
    /**
     * 公司ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long companyId;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 公司类型
     */
    private String companyType;
    /**
     * 联系电话
     */
    private String tel;
    /**
     * 登录名
     */
    String loginName;
    /**
     * 账号类型
     */
    String userType;

    /**
     * 用户ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    Long userId;
}
