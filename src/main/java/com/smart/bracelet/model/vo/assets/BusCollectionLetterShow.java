package com.smart.bracelet.model.vo.assets;

import lombok.Data;

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
     *债务人身份证号
     */
    String personCard;

    /**
     * （私人性质）债务人电话
     */
    String priPhone;

    /**
     * （企业/银行性质）债务人电话
     */
    String corBankPhone;

    /**
     * 性质
     */
    String reportPropert;
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
}
