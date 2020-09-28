package com.smart.bracelet.enums;

/**
 * 催款函
 */
public enum DocLetter {

    LETTER_NO("JLS+战略合作公司名称+序号"),
    PERSON_NAME("债务人姓名"),
    DEBT_NAME("债权人姓名"),
    ASSAG_NO("债权转让协议编号 "),
    THIS_MOEY("解债金额小写"),
    THIS_MOEY_MAX("解债金额大写"),
    CONT_YAER("yy%yy"),
    CONT_MOON("m%m"),
    CONT_DAY("d%d"),
    ;


    private String name;

    DocLetter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
