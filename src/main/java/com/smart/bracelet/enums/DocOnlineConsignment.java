package com.smart.bracelet.enums;

/**
 * 线上委托销售
 */
public enum  DocOnlineConsignment {

    ONLINE_NO("SW+战略合作公司名称+编号"),
    DEBT_NAME("债权人姓名"),
    DEBT_CARD("债权人身份证号码"),
    DEBT_ADD("债权人地址"),
    DEBT_PHONE("债权人电话号码"),
    KAISHI_YAER("开始Y"),
    KAISHI_MOON("开始M"),
    KAISHI_DAY("开始D"),
    JIESHU_YAER("结束Y"),
    JIESHU_MOON("结束M"),
    JIESHU_DAY("结束D"),
    THIS_MONEY("解债金额小写"),
    THIS_MONEY_MAX("解债金额大写"),
    JIFEN("每期积分=解债金额/(12个月/24个月/36个月）"),
    CONT_YAER("yyyy"),
    CONT_MOON("mm"),
    CONT_DAY("dd"),
    ;


    private String name;
    DocOnlineConsignment(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
