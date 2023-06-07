package com.study.common.exception;


import com.study.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理程序
 *
 * @author yangyanbin
 * @date 2023/06/07
 * @since 20230607
 *
 * @ControllerAdvice: AOP切面，不改变原代码增加功能
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 接口无论那种异常返回统一的结果
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return Result.fail(null);
    }


    /**
     * 自定义异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(BizException.class)
    @ResponseBody
    public Result error(BizException e){
        e.printStackTrace();
        return Result.fail(null);
    }
}
