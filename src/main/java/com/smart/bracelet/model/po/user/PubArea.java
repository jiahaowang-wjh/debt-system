package com.smart.bracelet.model.po.user;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * pub_area
 *
 * @author
 */
@Data
public class PubArea implements Serializable {
    private static final long serialVersionUID = 1237046587129569561L;
    /**
     * 区域id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long areaId;

    /**
     * 区域名称
     */
    @NotBlank(message = "区域名不能为空")
    private String areaName;

    /**
     * 区域编码
     */
    @NotBlank(message = "区域编码不能为空")
    private String areaCode;

    /**
     * 父级节点
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "父级Id不能为空")
    private Long parentId;

    /**
     * 备注
     */
    private String note;


}