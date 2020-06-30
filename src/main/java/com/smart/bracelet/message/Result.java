package com.smart.bracelet.message;

import com.smart.bracelet.enums.FailResultCode;
import com.smart.bracelet.enums.SuccessResultCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author junyunxiao
 * @version 1.0
 * @date 2019/6/19 14:35
 * @desc: 描述信息
 */
@Getter
@Setter
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -1277007242641786024L;

    /**
     * 请求返回码
     */
    private String resultCode;

    /**
     * 请求返回消息
     */
    private String resultMessage;

    /**
     * 返回值
     */
    private T data;


    public Result() {
        this.resultCode = SuccessResultCode.SUCCESS.getCode();
        this.resultMessage = SuccessResultCode.SUCCESS.getMessage();
    }

    public Result(T data) {
        this.data = data;
        this.resultCode = SuccessResultCode.SUCCESS.getCode();
        this.resultMessage = SuccessResultCode.SUCCESS.getMessage();
    }

    public Result(String resultCode, String resultMessage) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    public Result(FailResultCode failResultCode) {
        this.resultCode = failResultCode.getCode();
        this.resultMessage = failResultCode.getMessage();
    }

    public Result(String resultMessage) {
        this.resultCode = FailResultCode.FAIL.getCode();
        this.resultMessage = resultMessage;
    }

    public Result(String resultCode, String resultMessage, T data) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.data = data;
    }


    /**
     * 操作成功，无数据返回
     *
     * @return
     */
    public static Result success() {
        return new Result();
    }

    /**
     * 操作成功，有数据返回
     *
     * @return
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>(data);
    }

    /**
     * 操作成功，自定义返回码及消息，并且无返回值
     *
     * @param code
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(SuccessResultCode code) {
        return new Result<T>(code.getCode(), code.getMessage());
    }

    /**
     * 操作成功，自定义返回码及消息，并且有返回值
     *
     * @param resultCode
     * @param resultMessage
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(String resultCode, String resultMessage, T data) {
        return new Result<T>(resultCode, resultMessage, data);
    }

    /**
     * 操作失败，需要返回对应的操作码及消息提示
     *
     * @param failResultCode 错误信息枚举
     * @return
     */
    public static Result fail(FailResultCode failResultCode) {
        return new Result(failResultCode);
    }

    /**
     * 失败处理，自定义错误信息
     *
     * @param resultMessage
     * @return
     */
    public static Result fail(String resultCode, String resultMessage) {
        return new Result(resultCode, resultMessage);
    }

    /**
     * 失败处理，自定义错误信息，自定义提示码，且有返回值
     *
     * @param resultCode
     * @param resultMessage
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> fail(String resultCode, String resultMessage, T data) {
        return new Result<T>(resultCode, resultMessage, data);
    }
}
