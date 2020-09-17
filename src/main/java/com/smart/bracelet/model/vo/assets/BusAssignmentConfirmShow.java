package com.smart.bracelet.model.vo.assets;

import lombok.Data;

import java.util.List;

/**
 * 资产债权转让确认页面初始化实体
 */
@Data
public class BusAssignmentConfirmShow {

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
     *当天日期
     */
    String thisTime;
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

}
