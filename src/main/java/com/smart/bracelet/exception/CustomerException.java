package com.smart.bracelet.exception;

/**
 * @author junyunxiao
 * @version 1.0
 * @date 2019/6/19 14:35
 * @desc: 描述信息
 */
public class CustomerException extends Exception {

    /**
     * 设置异常信息
     *
     * @param message
     */
    public CustomerException(String message) {
        super(message);
    }
}
