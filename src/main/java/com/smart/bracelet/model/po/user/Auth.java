package com.smart.bracelet.model.po.user;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class Auth {
    /**
     * 权限ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long authId;

    /**
     * 权限名
     */
    private String authname;

}
