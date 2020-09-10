package com.smart.bracelet.model.vo.debt;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class CivilAndPseronInfo {

    @JsonSerialize(using = ToStringSerializer.class)
    Long civilId;

    String civilno;

    String personName;
    @JsonSerialize(using = ToStringSerializer.class)
    Long relativePerId;
}
