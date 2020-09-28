package com.smart.bracelet.enums;

/**
 * 资产确认书
 */
public enum DocProve {

    /**
     * 替换字段
     */
    CONFIRM_NO("债权转让协议编号-（3）"),
    PERSON_NAME("债务人姓名"),
    DEBT_NAME("债权人姓名"),
    ASSAG_NO("assignmentAgreementNo"),
    DEBT_YAER("DebtYaer"),
    DEBT_MOON("DebtMoon"),
    DEBT_DAY("DebtDay"),
    THIS_MONEY("amountThis"),
    SERVICE_BENJIN("引用策划方案服务协议本金小写"),
    SERVICE_LIXI("引用策划方案服务协议利息小写"),
    CONT_YAER("yyyy"),
    CONT_MOON("mm"),
    CONT_DAY("dd")
    ;
    private String name;

    DocProve(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
