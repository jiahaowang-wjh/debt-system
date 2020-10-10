package com.smart.bracelet.enums;

/**
 * 和解协议
 */
public enum  DocReconciliation {


    /**
     * 替换字段
     */
    REC_NO("agreementNumber"),
    PERSON_NAME("personName"),
    DEBT_NAME("debtName"),
    THIS_MONEY("amount"),
    XUANZE("situation"),
    AVG("average"),
    DEBT_DAY("days"),
    CONT_YAER("yyy1"),
    CONT_MOON("M1"),
    CONT_DAY("d1"),
    ;


    private String name;
    DocReconciliation(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
