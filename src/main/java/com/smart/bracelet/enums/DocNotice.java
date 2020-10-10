package com.smart.bracelet.enums;

/**
 * 债权转让通知书
 */
public enum  DocNotice {

    /**
     * 替换字段
     */
    NOTICE_NO("agreementNumber"),
    DEBT_DAME("debtName"),
    PERSON_NAME("personName"),
    PERSON_IDCARD("idCard"),
    DEBT_REASON("personReason"),//债务原因
    DEBT_AUTHIS_MONEY("amount"),
    CON_TIME_YAER("yyyy"),
    CON_TIME_MOON("MM"),
    CON_TIME_DAY("dd"),
    ;

    private String name;
    DocNotice(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
