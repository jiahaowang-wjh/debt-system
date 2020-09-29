package com.smart.bracelet.model.vo.assets;

import lombok.Data;

@Data
public class BusAssessmentInit {

    /**
     *债权人性质
     */
    String debtPropert;
    /**
     *债权人姓名
     */
    String debtName;
    /**
     *债权人身份证
     */
    String debtidCard;
    /**
     *债权人电话（私人）
     */
    String debtPhnoe;
    /**
     *债权人电话（企业或银行）
     */
    String debtCorPhone;

    /**
     * 相对人性质
     */
    String personPeropert;

    /**
     *相对人姓名
     */
    String personName;

    /**
     *相对人身份证
     */
    String personIdCard;

    /**
     *相对人手机号（）
     */
    String personPhnoe;

    /**
     * 相对人手机号（）
     */
    String personCorPhone;

    /**
     * 解债金额
     */
    String amountThis;

    /**
     *凭证
     */
    String credentials;

    /**
     * 其他情况说明
     */
    String card;

    /**
     * 负责人
     */
    String companyManag;
}
