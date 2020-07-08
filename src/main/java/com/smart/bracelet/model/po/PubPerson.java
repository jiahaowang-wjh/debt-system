package com.smart.bracelet.model.po;

import lombok.Data;

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