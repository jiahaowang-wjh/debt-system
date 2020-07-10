package com.smart.bracelet.model.vo.user;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * pub_area
 * @author 
 */
@Data
public class PubAreaVo implements Serializable {
    private static final long serialVersionUID = -7093419064705296032L;
    /**
     * 区域id
     */
    @NotNull(message = "区域id不能为空")
    private Long areaId;

    /**
     * 区域名称
     */
    private String areaName;

    /**
     * 区域编码
     */
    private String areaCode;

    /**
     * 父级节点
     */
    private Long parentId;

    /**
     * 备注
     */
    private String note;


}