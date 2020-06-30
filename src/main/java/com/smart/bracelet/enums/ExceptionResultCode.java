package com.smart.bracelet.enums;

/**
 * @desc: 描述信息
 *
 * @author junyunxiao
 * @version 1.0
 * @date 2019/6/21 17:13
 */
public enum ExceptionResultCode {

    /**
     * 参数校验异常
     */
    VALID_EXCEPTION("405", "参数校验异常"),

    /**
     * 服务器异常
     */
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


    public String getMessage() {
        return message;
    }

}
