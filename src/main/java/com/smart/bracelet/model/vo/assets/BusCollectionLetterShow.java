package com.smart.bracelet.model.vo.assets;

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


}
