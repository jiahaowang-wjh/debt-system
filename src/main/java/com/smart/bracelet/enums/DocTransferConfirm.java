package com.smart.bracelet.enums;

/**
 * 债权转让确认
 */
public enum DocTransferConfirm {

    /**
     * 替换字段
     */
    CONFIRM_NO("债权转让协议编号-（1）"),
    DEBT_NAME("债权人姓名"),
    ASSAGR_NO("assignmentAgreementNo"),
    THIS_YAER("thisYaer"),
    THIS_MOON("thisMoon"),
    THIS_DAY("thisDay"),
    AMOUNT_MONEY("解债金额"),
    PERSON_NAME("债务人姓名"),
    AUTHNAME("担保人姓名"),
    CONT_THIS_YAER("thisContYaer"),
    CONT_THIS_MOON("thisContMoon"),
    CONT_THIS_DAY("thisContDay")
    ;
    private String name;

    public String getName() {
        return name;
    }

    DocTransferConfirm(String name){
         this.name=name;
    }

}
