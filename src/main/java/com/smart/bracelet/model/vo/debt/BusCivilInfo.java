package com.smart.bracelet.model.vo.debt;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class BusCivilInfo {
    /**
     * 调解ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    Long civilId;

    /**
     * 相对人ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    Long relativePerId;

    /**
     * 报备ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    Long reportId;

    /**
     * 报备编号
     */
    String reportNo;
    /**
     * 调解编号
     */
    String civilno;


    /**
     * 相对人
     */
    String personName;

    /**
     * 调解状态
     */
    String status;
    /**
     *
     */
    String civilType;
}
