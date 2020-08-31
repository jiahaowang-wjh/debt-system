package com.smart.bracelet.model.vo.debt;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * 民事调解信息填写页面
 */
@Data
public class CiviIAndRepShow {
    @JsonSerialize(using = ToStringSerializer.class)
    Long reportId;
    String reportNo;
    String civilno;
    String debtName;
    String status;
}
