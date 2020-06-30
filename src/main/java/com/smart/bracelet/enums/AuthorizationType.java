package com.smart.bracelet.enums;

/**
 * @author junyunxiao
 * @version 1.0
 * @Description: 描述信息
 * @date 2019/12/9 17:54
 */
public enum AuthorizationType {

    /**
     * BASIC认证
     */
    BASIC("Basic "),

    /**
     * AUTHORIZATION
     */
    AUTHORIZATION("Authorization");

    private String type;

    AuthorizationType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
