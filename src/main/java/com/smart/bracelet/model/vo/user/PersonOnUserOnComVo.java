package com.smart.bracelet.model.vo.user;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 用户人员公司实体类
 */
@Data
public class PersonOnUserOnComVo {
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
     * 人员名称
     */
    private String personName;

    /**
     * 人员类型
     */
    private String personType;
    /**
     * 公司ID
     */
    @NotNull(message = "公司ID不能为空")
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



}
