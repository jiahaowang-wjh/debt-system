package com.smart.bracelet.model.po.debt;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class CivilShow {
    @JsonSerialize(using = ToStringSerializer.class)
    Long reportId;
    String civilno;
    String status;
    String personName;
}
