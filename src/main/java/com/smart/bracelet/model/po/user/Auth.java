package com.smart.bracelet.model.po.user;

import lombok.Data;

@Data
public class Auth {
    /**
     * 权限ID
     */
    private Long authId;

    /**
     * 权限名
     */
    private String authname;

}
