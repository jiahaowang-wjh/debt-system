package com.smart.bracelet.enums;

/**
 * 线上委托销售
 */
public enum  DocOnlineConsignment {

    ONLINE_NO("agreementNumber"),
    DEBT_NAME("client"),
    DEBT_CARD("idCard"),
    DEBT_ADD("idCardAddress"),
    DEBT_PHONE("phoneNumber"),
    KAISHI_YAER("yyy1"),
    KAISHI_MOON("M1"),
    KAISHI_DAY("d1"),
    JIESHU_YAER("yyy2"),
    JIESHU_MOON("M2"),
    JIESHU_DAY("d2"),
    THIS_MONEY("amount"),
    THIS_MONEY_MAX("amountInWords"),
    JIFEN("fraction"),
    CONT_YAER("yyy3"),
    CONT_MOON("M3"),
    CONT_DAY("d3"),
    ;


    private String name;
    DocOnlineConsignment(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
