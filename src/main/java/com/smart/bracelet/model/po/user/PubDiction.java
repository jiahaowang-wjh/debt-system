package com.smart.bracelet.model.po.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @NotBlank(message = "字典类型不能为空")
    private String dictionType;

    /**
     * 字典编码
     */
    @NotBlank(message = "字典类型不能为空")
    private String dictionCode;

    /**
     * 字典编号
     */
    @NotBlank(message = "字典类型不能为空")
    private String dictionNo;

    /**
     * 字典显示
     */
    @NotBlank(message = "字典类型不能为空")
    private String dictionDis;

    /**
     * 排序
     */
    @NotNull(message = "排序不能为空")
    private Long sort;

    /**
     * 备注
     */
    private String note;


}