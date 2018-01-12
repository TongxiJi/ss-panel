package cn.wowspeeder.shadowsocks.controller;

import cn.wowspeeder.shadowsocks.ext.Result;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author:TongxiJi E-MAIL:694270875@qq.com
 * Function:
 * Create Date:十月13,2017
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    public static final int ERROR_CODE_API = 1001;

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handle(MissingServletRequestParameterException exception) {
        System.out.println("BAD_REQUEST:"+exception.getMessage());
        return Result.fail(exception.getMessage());
    }
}