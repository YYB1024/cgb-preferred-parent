package com.study.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 优惠券类型
 *
 * @author yangyb
 * @date 2023/06/07
 */
@Getter
public enum CouponType {
    FULL_REDUCTION(1,"满减"),
    CASH(2,"现金卷");

    @EnumValue
    private Integer code;
    private String comment ;

    CouponType(Integer code, String comment ){
        this.code=code;
        this.comment=comment;
    }
}