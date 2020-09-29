package com.smart.bracelet.enums;

/**
 * 和解协议
 */
public enum  DocReconciliation {


    /**
     * 替换字段
     */
    REC_NO("JLS+战略合作公司名称+序号"),
    PERSON_NAME("债务人姓名"),
    DEBT_NAME("债权人姓名"),
    THIS_MONEY("解债金额小写"),
    XUANZE("手动选择"),
    AVG("解债每期货款"),
    DEBT_DAY("解债日期中日的数字"),
    CONT_YAER("yyyy"),
    CONT_MOON("mm"),
    CONT_DAY("dd"),
    ;


    private String name;
    DocReconciliation(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
