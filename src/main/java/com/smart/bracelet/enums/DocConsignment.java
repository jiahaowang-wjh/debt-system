package com.smart.bracelet.enums;

/**
 * 委托销售
 */
public enum DocConsignment {

    CONT_NO("FB+战略合作公司名称+序号"),
    DEBT_NAME("债权人姓名"),
    DEBT_CARD("债权人身份证号码"),
    DEBT_ADD("债权人身份证地址"),
    DEBT_PHONE("债权人电话"),
    DAIXIAO_YAER("代销Y开始"),
    DAIXIAO_MOON("代销M开始"),
    DAIXIAO_DAY("代销D开始"),
    DAIXIAO_JIESHU_YAER("代销Y结束"),
    DAIXIAO_JIESHU_MOON("代销M结束"),
    DAIXIAO_JIESHU_DAY("代销D结束"),
    THIS_MONEY("解债金额小写"),
    THIS_MONEY_MAX("解债金额大写"),
    AVG_MONEY("每期货款金额"),
    DEBT_YINHANGKAHAO("债权人银行账号"),
    DEBT_KAIHUHANG("债权人银行开户行"),
    CONT_YAER("yyyy"),
    CONT_MOON("mm"),
    CONT_DAY("dd"),
    ;

    public String getName() {
        return name;
    }

    private String name;

    DocConsignment(String name) {
        this.name = name;
    }

}
