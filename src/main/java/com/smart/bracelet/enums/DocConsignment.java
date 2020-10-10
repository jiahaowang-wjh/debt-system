package com.smart.bracelet.enums;

/**
 * 委托销售
 */
public enum DocConsignment {

    CONT_NO("agreementNumber"),
    DEBT_NAME("debtName"),
    DEBT_CARD("idCard"),
    DEBT_ADD("idCardAddress"),
    DEBT_PHONE("phoneNumber"),
    DAIXIAO_YAER("yyy1"),
    DAIXIAO_MOON("M1"),
    DAIXIAO_DAY("d1"),
    DAIXIAO_JIESHU_YAER("yyy2"),
    DAIXIAO_JIESHU_MOON("M2"),
    DAIXIAO_JIESHU_DAY("d2"),
    THIS_MONEY("amount"),
    THIS_MONEY_MAX("amountInWords"),
    AVG_MONEY("money"),
    DEBT_YINHANGKAHAO("bankCard"),
    DEBT_KAIHUHANG("bank"),
    CONT_YAER("yyy3"),
    CONT_MOON("M3"),
    CONT_DAY("d3"),
    ;

    public String getName() {
        return name;
    }

    private String name;

    DocConsignment(String name) {
        this.name = name;
    }

}
