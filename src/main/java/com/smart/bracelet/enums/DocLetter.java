package com.smart.bracelet.enums;

/**
 * 催款函
 */
public enum DocLetter {

    LETTER_NO("agreementNumber"),
    PERSON_NAME("personName"),
    DEBT_NAME("debtName"),
    ASSAG_NO("agreementNumber2"),
    THIS_MOEY("amount"),
    THIS_MOEY_MAX("amountInWords"),
    CONT_YAER("yyyy"),
    CONT_MOON("MM"),
    CONT_DAY("dd"),
    ;

    private String name;

    DocLetter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
