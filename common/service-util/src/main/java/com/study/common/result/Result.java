package com.study.common.result;

import lombok.Data;

/**
 * 统一结果响应
 *
 * @author yangyanbin
 * @date 2023/06/07
 * @since 20230607
 */
@Data
public class Result <T>{

    /**
     * code
     */
    private Integer code;

    /**
     * 消息
     */
    private String message;

    /**
     * 数据
     */
    private T data;

    /**
     * 构造私有化
     */
    public Result() {
    }

    /**
     *  设置数据的方法
     * @param <T>
     * @return
     */
    public static <T> Result<T> build (T data, ResultCodeEnum resultCodeEunm){
        // 创建Result对象，设置值，返回对象
        Result<T> result = new Result<>();
        // 判断返回结果是否需要数据
        if(data != null){
            result.setData(data);
        }
        // 设置其他值
        result.setCode(resultCodeEunm.getCode());
        result.setMessage(resultCodeEunm.getMessage());
        return result;

    }


    /**
     * 成功的方法
     * @param data
     * @param <T>
     * @return
     */
    public static<T> Result<T> ok(T data) {
        Result<T> result = build(data, ResultCodeEnum.SUCCESS);
        return result;
    }

    /**
     * 失败的方法
     */
    public static<T> Result<T> fail(T data) {
        return build(data,ResultCodeEnum.FAIL);
    }
}
