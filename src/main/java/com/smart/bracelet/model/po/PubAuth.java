package com.smart.bracelet.model.po;

import lombok.Data;

import java.io.Serializable;

/**
 * pub_auth
 * @author 
 */
@Data
public class PubAuth implements Serializable {
    private static final long serialVersionUID = 5813554454156426349L;
    /**
     * 权限ID
     */
    private Long authId;

    /**
     * 权限名
     */
    private String authname;

    /**
     * 接口名称
     */
    private String interfacename;

    /**
     * 备注
     */
    private String note;


}