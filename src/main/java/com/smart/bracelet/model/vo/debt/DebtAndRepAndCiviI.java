package com.smart.bracelet.model.vo.debt;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class DebtAndRepAndCiviI {

    /**
     * 报备ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    Long reportId;
    /**
     * 解债Id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    Long debtId;
    /**
     * 解债编号
     */
    String debtNo;
    /**
     * 报备编号
     */
    String reportNo;
    /**
     * 民事调解编号
     */
    String civilno;
    /**
     * 相对人
     */
    String personName;

}
