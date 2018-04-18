package com.abc.shiro.controller;

import com.abc.shiro.constant.Codes;
import com.abc.shiro.vo.Json;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    //UnauthenticatedException


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Json handleShiroException(Exception e) {
        String eName = e.getClass().getSimpleName();
        return new Json(eName, false, Codes.SHIRO_ERR, "shiro出错", null);
    }


}