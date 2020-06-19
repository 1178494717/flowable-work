package com.github.web.exception;

import com.github.web.response.result.Response;
import com.github.web.response.result.ResponseResult;
import com.github.web.response.result.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @date 2020/6/19
 */
@RestControllerAdvice(annotations={RestController.class, Controller.class})
@Slf4j
public class SpringExceptionHandle {

    @ExceptionHandler(value={DCServiceException.class})
    @ResponseBody
    public <T> ResponseResult<T> sendDCServiceException(DCServiceException exception, HttpServletRequest request){
        String requestURI = request.getRequestURI();
        log.error("occurs error when execute url ={} ,message {}",requestURI,exception.getMessage());
        return Response.makeRsp(ResultCodeEnum.INTERNAL_SERVER_ERROR, exception.getMsg());
    }

    @ExceptionHandler(value={Exception.class})
    @ResponseBody
    public <T> ResponseResult<T> sendException(Exception exception, HttpServletRequest request){
        String requestURI = request.getRequestURI();
        log.error("occurs error when execute url ={} ,message {}",requestURI,exception.getMessage());
        return Response.makeRsp(ResultCodeEnum.INTERNAL_SERVER_ERROR, exception.getMessage());
    }

}
