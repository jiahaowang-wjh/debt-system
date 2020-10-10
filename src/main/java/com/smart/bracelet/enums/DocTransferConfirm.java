package com.smart.bracelet.enums;

/**
 * 债权转让确认
 */
public enum DocTransferConfirm {

    /**
     * 替换字段
     */
    CONFIRM_NO("agreementNumber"),
    DEBT_NAME("debtName"),
    ASSAGR_NO("agreementNumber2"),
    THIS_YAER("yyy1"),
    THIS_MOON("M1"),
    THIS_DAY("d1"),
    AMOUNT_MONEY("amount"),
    PERSON_NAME("personName"),
    AUTHNAME("guarantee"),
    CONT_THIS_YAER("yyy2"),
    CONT_THIS_MOON("M2"),
    CONT_THIS_DAY("d2")
    ;
    private String name;

    public String getName() {
        return name;
    }

    DocTransferConfirm(String name){
         this.name=name;
    }

}
