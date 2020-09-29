package com.smart.bracelet.enums;

/**
 * 转让协议
 */
public enum DocEransfer {



    /**
     * 替换字段
     */
    ASSNO("JLS+战略合作公司名称+序号"),
    DEBT_NAME("债权人姓名"),
    DEBT_IDCARD("债权人身份证号码"),
    DEBT_ADD("债权人地址"),
    DEBT_PHONE("债权人电话"),
    PERSON_NAME("债务人姓名"),
    PERSON_YARE("借款年"),
    PERSON_MOON("借款月"),
    PERSON_DAY("借款日"),
    CONST_YAER("yyyy"),
    CONST_MOON("mm"),
    CONST_DAY("dd"),
    THIS_YAER("Thisyyyy"),
    THIS_MOON("Thismm"),
    THIS_DAY("Thisdd"),
    AMOUNTTHIS("解债金额"),
    SERVICE_PRIN("引用咨询服务费协议中本金手动填写金额小写"),
    SERVICE_INTST("引用咨询服务费协议中利息手动填写金额小写"),
    SERVICE_MONEY("甲方支付现金金额"),
    ;

    private String name;
    DocEransfer(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
