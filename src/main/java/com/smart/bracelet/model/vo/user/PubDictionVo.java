package com.smart.bracelet.model.vo.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * pub_diction
 *
 * @author
 */
@Data
public class PubDictionVo implements Serializable {
    private static final long serialVersionUID = -639099083034009062L;
    /**
     * 字典ID
     */
    @NotNull(message = "字典ID不能为空")
    private Long dictionId;

    /**
     * 字典类型
     */
    @NotBlank(message = "不能为空")
    private String dictionType;

    /**
     * 字典编码
     */
    @NotBlank(message = "字典编码不能为空")
    private String dictionCode;

    /**
     * 字典编号
     */
    @NotBlank(message = "字典编号不能为空")
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