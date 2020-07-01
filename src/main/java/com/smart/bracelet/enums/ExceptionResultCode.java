package com.smart.bracelet.enums;

/**
 * TODO: 描述信息
 *
 * @author junyunxiao
 * @version 1.0
 * @date 2019/6/21 17:13
 */
public enum ExceptionResultCode {

    VALID_EXCEPTION("405", "参数校验异常"),

    SYS_EXCEPTION("500", "系统发生异常");

    private String code;
    private String message;

    ExceptionResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
