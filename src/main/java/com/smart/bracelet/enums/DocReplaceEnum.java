package com.smart.bracelet.enums;

/**
 * @author liuzq
 * @version 1.0
 * @date 2020/9/21
 * 策划方案服务协议
 **/
public enum DocReplaceEnum {
    /**
     * 模板中需要替换的字段
     */
    DEBT_NO("TZ+战略合作公司名称+序号"),
    DEBT_NAME("债权人姓名"),
    DEBT_ID_CARD("债权人身份证号码"),
    ID_CARD_ADDRESS("债权人身份证地址"),
    PHONE_NUMBER("债权人电话号码"),
    SITUATION("手动填写"),//甲方身份
    AMOUNT("解债金额引用小写"),
    AMOUNT_IN_WORDS("解债金额引用大写"),
    PRINCIPAL("手动填写本金"),
    INTEREST("手动填写利息"),
    DEBT_AMOUNT_THIS("服务费小写"),
    DEBT_AMOUNT_THIS_MAX("服务费大写元"),
    DEBT_YEAR("yyyy"),
    DEBT_MOON("mm"),
    DEBT_DAY("dd")
    ;
    private String name;

    DocReplaceEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
