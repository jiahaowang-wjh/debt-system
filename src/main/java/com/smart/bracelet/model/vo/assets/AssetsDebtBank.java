package com.smart.bracelet.model.vo.assets;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;

@Data
public class AssetsDebtBank {

    /**
     * 相对人ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    Long relativePerId;
    /**
     * 资产ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    Long propertId;
    /**
     * 报备编号
     */
    String reportNo;
    /**
     * 解债编号
     */
    String debtNo;
    /**
     * 资产评估编号
     */
    String assessmentNo;
    /**
     * 阶段
     */
    String stage;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date createTime;

    /**
     * 状态
     */
    String status;
}
