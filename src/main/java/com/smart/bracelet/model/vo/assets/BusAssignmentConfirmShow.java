package com.smart.bracelet.model.vo.assets;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 资产债权转让确认页面初始化实体
 */
@Data
public class BusAssignmentConfirmShow {

    @JsonSerialize(using = ToStringSerializer.class)
    Long civilId;
    /**
     * 债权人姓名
     */
    String debtName;
    /**
     *债权转让协议编号
     */
    String assignmentAgreementNo;

    /**
     *解债金额
     */
    Float amountThis;
    /**
     *债务人姓名
     */
    String personName;
    /**
     *担保人姓名
     */
    List<String> authName;

    /**
     * 编号
     */
    String confirmNo;

    /**
     * 签约日期
     */
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    Date contractTime;

    /**
     * 当前系统日期
     */
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    Date thisTime;
}
