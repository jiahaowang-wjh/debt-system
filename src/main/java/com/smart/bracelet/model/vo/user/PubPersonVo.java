package com.smart.bracelet.model.vo.user;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * pub_person
 * @author 
 */
@Data
public class PubPersonVo implements Serializable {
    private static final long serialVersionUID = -1016572727977055013L;
    /**
     * 人员ID
     */
    @NotNull(message = "人员ID不能为空")
    private Long personId;

    /**
     * 公司ID
     */
    private Long companyId;

    /**
     * 人员名称
     */
    private String personName;

    /**
     * 人员类型
     */
    private String personType;

    /**
     * 人员性别
     */
    private String sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 联系电话
     */
    private String tel;

    /**
     * 备注
     */
    private String note;


}