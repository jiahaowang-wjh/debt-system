package com.smart.bracelet.enums;

/**
 * @author junyunxiao
 * @version 1.0
 * @Description: 操作成功的返回信息
 * @date 2019/3/27 9:35
 */
public enum SuccessResultCode {

    /**
     * 操作成功
     */
    SUCCESS("200", "操作成功"),

    /**
     * 认证成功
     */
    AUTHENTICATION_SUCCESS("200", "认证成功"),

    /**
     * 退出登录成功
     */
    LOGOUT_SUCCESS("200", "退出登录成功");

    private String code;
    private String message;

    SuccessResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }


    public String getMessage() {
        return message;
    }


}
