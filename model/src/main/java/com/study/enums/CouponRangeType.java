package com.study.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 卡券范围类型
 *
 * @author yangyb
 * @date 2023/06/07
 */
@Getter
public enum CouponRangeType {
    ALL(1,"通用"),
    SKU(2,"SKU" ),
    CATEGORY(3,"分类");

    @EnumValue
    private Integer code ;
    private String comment ;

    CouponRangeType(Integer code, String comment ){
        this.code=code;
        this.comment=comment;
    }

}