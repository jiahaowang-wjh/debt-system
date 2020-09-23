package com.smart.bracelet.model.vo.debt;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class PubDebtInfo {
    /**
     * 报备Id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    Long reportId;

    /**
     * 报备编号
     */
    String reportNo;
    /**
     * 相对人
     */
    String personName;
    /**
     * 相对人Id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    Long relativePerId;

    /**
     * 民事调解id
     */
    String civilId;
    /**
     * 解债编号
     */
    String debtNo;

    /**
     * 解债ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    Long debtId;

    /**
     * 解债状态
     */
    String status;

}
