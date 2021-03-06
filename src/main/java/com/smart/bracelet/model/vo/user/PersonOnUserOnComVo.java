package com.smart.bracelet.model.vo.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 用户人员公司实体类
 */
@Data
public class PersonOnUserOnComVo {

    /**
     * 人员ID
     */
    @NotNull(message = "人员ID不能为空")
    private Long personId;

    /**
     * 备注
     */
    private String note;
    /**
     * 人员名称
     */
    @NotBlank(message = "人员名称不能为空")
    private String personName;
    /**
     * 人员性别
     */
    @NotBlank(message = "人员性别不能为空")
    private String sex;
    /**
     * 人员类型
     */
    @NotBlank(message = "人员类型不能为空")
    private String personType;
    /**
     * 公司ID
     */
    @NotNull(message = "公司ID不能为空")
    private Long companyId;
    /**
     * 年龄
     */
    @NotNull(message = "年龄不能为空")
    private Integer age;

    /**
     * 联系电话
     */
    @NotBlank(message = "联系电话不能为空")
    private String tel;


}
