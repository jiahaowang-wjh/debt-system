package com.smart.bracelet.enums;

/**
 * 债权转让通知书
 */
public enum  DocNotice {

    /**
     * 替换字段
     */
    NOTICE_NO("债权转让协议编号-（2）"),
    DEBT_DAME("debtname"),
    PERSON_NAME("数据库债务人"),
    PERSON_IDCARD("数据库债务人身份证"),
    DEBT_REASON("从天泽系统引用数据"),
    DEBT_AUTHIS_MONEY("数据库解债金额"),
    CON_TIME_YAER("yy%yy"),
    CON_TIME_MOON("m%m"),
    CON_TIME_DAY("d%d"),
    ;

    private String name;
    DocNotice(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
