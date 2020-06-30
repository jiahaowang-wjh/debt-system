package com.smart.bracelet.enums;

/**
 * @author junyunxiao
 * @version 1.0
 * @Description: 操作失败对应的返回码及提示
 * @date 2019/3/27 9:41
 */
public enum FailResultCode {

    /**
     * 系统错误
     */
    FAIL("400", "操作失败"),

    /**
     * 用户名不存在
     */
    USERNAME_NOTFOUND("400", "用户名不存在"),

    /**
     * 密码错误
     */
    PASSWORD_ERR("400", "密码错误"),

    /**
     * 退出登陆失败
     */
    LOGOUT_ERR("400", "退出登陆失败"),

    /**
     * 账户被锁定
     */
    LOCKED("400", "账户被锁定"),

    /**
     * 认证失败
     */
    AUTHENTICATION_FAIL("400", "认证失败"),

    /**
     *token失效
     *
     */
    INVALID_TOKEN("400", "toke失效或非法"),

    /**
     * 验证码错误
     *
     */
    VALIDATE_CODE_ERR("400","验证码错误"),

    /**
     * 尚未进行注册
     */
    SIGN_UPD("419", "尚未进行用户注册"),

    /**
     * 拒绝访问
     */
    ACCESS_DENIED("403", "拒绝访问");

    /**
     * 返回码
     */
    private String code;
    /**
     * 返回消息
     */
    private String message;

    FailResultCode(String code, String message) {
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
