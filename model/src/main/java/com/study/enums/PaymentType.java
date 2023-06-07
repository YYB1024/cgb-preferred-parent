package com.study.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 付款类型
 *
 * @author yangyb
 * @date 2023/06/07
 */
@Getter
public enum PaymentType {
    ALIPAY(1,"支付宝"),
    WEIXIN(2,"微信" );

    @EnumValue
    private Integer code ;
    private String comment ;

    PaymentType(Integer code, String comment ){
        this.code = code;
        this.comment=comment;
    }

}
