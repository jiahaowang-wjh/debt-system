package com.smart.bracelet.model.po;

import lombok.Data;

import java.io.Serializable;

/**
 * pub_diction
 * @author 
 */
@Data
public class PubDiction implements Serializable {
    private static final long serialVersionUID = -6898736789145677586L;
    /**
     * 字典ID
     */
    private Long dictionId;

    /**
     * 字典类型
     */
    private String dictionType;

    /**
     * 字典编码
     */
    private String dictionCode;

    /**
     * 字典编号
     */
    private String dictionNo;

    /**
     * 字典显示
     */
    private String dictionDis;

    /**
     * 排序
     */
    private Long sort;

    /**
     * 备注
     */
    private String note;


}