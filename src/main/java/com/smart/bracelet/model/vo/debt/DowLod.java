package com.smart.bracelet.model.vo.debt;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class DowLod {

    @JsonSerialize(using = ToStringSerializer.class)
    Long debtId;

    String debtName;

    String idCard;

    String priPhone;

    String  croBankPhone;

    String type;

    String personName;

    Float moeny;
}
