package com.smart.bracelet.model.po.user;

import lombok.Data;

import java.io.Serializable;

/**
 * pub_area
 * @author 
 */
@Data
public class PubArea implements Serializable {
    private static final long serialVersionUID = 1237046587129569561L;
    /**
     * 区域id
     */
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