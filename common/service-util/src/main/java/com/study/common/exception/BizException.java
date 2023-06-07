package com.study.common.exception;

import com.study.common.result.ResultCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 业务异常
 *
 * @author yangyanbin
 * @date 2023/06/07
 * @since 20230607
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BizException extends RuntimeException{
    /**
     * 异常code
     */
    private Integer code;

    public BizException(String message,Integer code) {
        super(message);
        this.code = code;
    }

    /**
     * 业务异常
     * 接收枚举类型对象
     * @param resultCodeEnum 枚举结果代码
     */
    public BizException(ResultCodeEnum resultCodeEnum){
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

}
