package com.smart.bracelet.model.vo.assets;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 催款函页面初始化实体
 */
@Data
public class BusCollectionLetterShow {

    /**
     * 债务人姓名
     */
    String personName;
    /**
     * 报备ID
     */
    Long reportId;
    /**
     *债权人姓名
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
     *解债金额大写
     */
    String moneyMax;

    /**
     * 编号
     */
    String collectionLettertNo;

    /**
     *合同日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    Date contractDate;


}
