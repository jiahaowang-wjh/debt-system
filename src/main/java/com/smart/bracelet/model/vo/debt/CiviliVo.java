package com.smart.bracelet.model.vo.debt;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class CiviliVo {

    String userName;
    @JsonSerialize(using = ToStringSerializer.class)
    Long userId;
}
