package com.smart.bracelet.enums;

/**
 * 发票
 */
public enum DocReportFee {


    THIS_YAER("yyy1"),
    THIS_MOON("M1"),
    THIS_DAY("d1"),
    DEBT_NO("number1"),
    DEBT_NAME("debtName"),
    COM_NAME("office1"),
    MONEY("consultingMoney"),
    MONEY_MAX("consultingMoneyInWords"),
    ;

    private String name;
    DocReportFee(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
