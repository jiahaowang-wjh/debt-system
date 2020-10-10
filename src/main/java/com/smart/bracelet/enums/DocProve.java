package com.smart.bracelet.enums;

/**
 * 资产确认书
 */
public enum DocProve {

    /**
     * 替换字段
     */
    CONFIRM_NO("agreementNumber"),
    PERSON_NAME("personName"),
    DEBT_NAME("debtName"),
    ASSAG_NO("agreementNumber2"),
    DEBT_YAER("yyy1"),
    DEBT_MOON("M1"),
    DEBT_DAY("d1"),
    THIS_MONEY("amountThis"),
    SERVICE_BENJIN("principal"),
    SERVICE_LIXI("interest"),
    CONT_YAER("yyy2"),
    CONT_MOON("M2"),
    CONT_DAY("d2")
    ;
    private String name;

    DocProve(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
