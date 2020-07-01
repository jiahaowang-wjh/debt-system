package com.smart.bracelet.userdetails;

import com.smart.bracelet.enums.ExceptionResultCode;
import com.smart.bracelet.enums.FailResultCode;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author junyunxiao
 * @version 1.0
 * @Description: 描述信息
 * @date 2019/12/20 10:58
 */
@RestControllerAdvice
public class CustomerExceptionResolver {

    /**
     * 参数校验异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = BindException.class)
    public Result<String> errorHandler(BindException ex) {
        BindingResult result = ex.getBindingResult();
        StringBuilder errorMsg = new StringBuilder();
        for (ObjectError error : result.getAllErrors()) {
            errorMsg.append(error.getDefaultMessage()).append(", ");
        }
        errorMsg.delete(errorMsg.length() - 2, errorMsg.length());
        return Result.fail(ExceptionResultCode.VALID_EXCEPTION.getCode(), errorMsg.toString());
    }


    /**
     * 参数校验异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public Result<String> validationErrorHandler(ConstraintViolationException ex) {
        List<String> errorInformation = ex.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
        String message = errorInformation.toString().substring(1, errorInformation.toString().length() - 1);
        return Result.fail(ExceptionResultCode.VALID_EXCEPTION.getCode(), message);
    }


    /**
     * 无权访问
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = AccessDeniedException.class)
    public Result<String> userExceptionHandler(AccessDeniedException ex) {
        return Result.fail(FailResultCode.ACCESS_DENIED);
    }


    /**
     * token非法或失效
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = AuthenticationException.class)
    public Result<String> authenticationExceptionHandler(AuthenticationException ex){
        return Result.fail(FailResultCode.INVALID_TOKEN);
    }

    /**
     * 系统异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = CustomerException.class)
    public Result<String> cloudPlatformExceptionHandler(CustomerException ex) {
        String message = ex.getMessage();
        return Result.fail(ExceptionResultCode.SYS_EXCEPTION.getCode(), message);
    }


    /**
     * 运行时异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public Result<String> exceptionHandler(Exception ex) {
        ex.printStackTrace();
        return Result.fail(FailResultCode.FAIL);
    }
}
