package com.smart.bracelet.model.po.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * pub_person
 * @author 
 */
@Data
public class PubPerson implements Serializable {
    private static final long serialVersionUID = -8758414954637063579L;
    /**
     * 人员ID
     */
    private Long personId;

    /**
     * 公司ID
     */
    @NotNull(message = "公司ID不能为空")
    private Long companyId;

    /**
     * 人员名称
     */
    @NotBlank(message = "人员名称不能为空")
    private String personName;

    /**
     * 人员类型
     */
    @NotBlank(message = "人员类型不能为空")
    private String personType;

    /**
     * 人员性别
     */
    @NotBlank(message = "人员性别不能为空")
    private String sex;

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

    /**
     * 备注
     */
    private String note;


}