package com.study.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * sku类型
 *
 * @author yangyb
 * @date 2023/06/07
 */
@Getter
public enum SkuType {
    COMMON(0,"普通"),
    SECKILL(1,"秒杀" );

    @EnumValue
    private Integer code ;
    private String comment ;

    SkuType(Integer code, String comment ){
        this.code=code;
        this.comment=comment;
    }
}