package com.smart.bracelet.enums;

/**
 * 转让协议
 */
public enum DocEransfer {



    /**
     * 替换字段
     */
    ASSNO("agreementNumber"),
    DEBT_NAME("partyA"),
    DEBT_IDCARD("idCard"),
    DEBT_ADD("idCardAddress"),
    DEBT_PHONE("phoneNumber"),
    PERSON_NAME("personName"),
    PERSON_YARE("yyy1"),
    PERSON_MOON("M1"),
    PERSON_DAY("d1"),
    CONST_YAER("yyy3"),
    CONST_MOON("M3"),
    CONST_DAY("d3"),
    THIS_YAER("yyy2"),
    THIS_MOON("M2"),
    THIS_DAY("d2"),
    AMOUNTTHIS("amount"),
    SERVICE_PRIN("principal"),
    SERVICE_INTST("interest"),
    SERVICE_MONEY("mount2"),
    ;

    private String name;
    DocEransfer(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
