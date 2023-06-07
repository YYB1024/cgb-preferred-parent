package com.study.enums;

import com.alibaba.fastjson.annotation.JSONType;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.databind.deser.std.EnumDeserializer;
import com.fasterxml.jackson.databind.ser.std.EnumSerializer;
import lombok.Getter;

/**
 * 比尔类型
 *
 * @author yangyb
 * @date 2023/06/07
 */
@JSONType(serializer = EnumSerializer.class, deserializer = EnumDeserializer.class, serializeEnumAsJavaBean = true)
@Getter
public enum BillType {
    ORDER(0,"订单佣金"),
    WITHDRAW(1,"提现" ),
    REFUND(1,"订单退款" );

    @EnumValue
    private Integer code ;
    private String comment ;

    BillType(Integer code, String comment ){
        this.code=code;
        this.comment=comment;
    }
}