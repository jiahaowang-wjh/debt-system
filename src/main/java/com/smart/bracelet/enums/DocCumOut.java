package com.smart.bracelet.enums;

/**
 * 暨尽协议模板字段
 */
public enum DocCumOut {

    /**
     * 替换字段
     */
    DEBT_NO("TZ+战略合作公司名称+序号"),
    DEBT_NAME("报备人姓名NAME"),
    DEBT_CARD("报备人身份证号码"),
    DEBT_YEAR("yyyy"),
    DEBT_MOON("mm"),
    DEBT_DAY("dd")
    ;


    private String name;

    DocCumOut(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
