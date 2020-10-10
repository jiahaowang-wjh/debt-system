package com.smart.bracelet.enums;

/**
 * 暨尽协议模板字段
 */
public enum DocCumOut {

    /**
     * 替换字段
     */
    DEBT_NO("agreementNumber"),
    DEBT_NAME("partyA"),
    DEBT_CARD("reporterIDCard"),
    DEBT_YEAR("yyy1"),
    DEBT_MOON("M1"),
    DEBT_DAY("d1")
    ;


    private String name;

    DocCumOut(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
