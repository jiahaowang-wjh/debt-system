package com.smart.bracelet.model.po;

import lombok.Data;

import java.io.Serializable;

/**
 * pub_role
 * @author 
 */
@Data
public class PubRole implements Serializable {
    private static final long serialVersionUID = -2736594286561874485L;
    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 角色名
     */
    private String rolename;

    /**
     * 是否有效
     */
    private String isenable;

    /**
     * 备注
     */
    private String note;


}