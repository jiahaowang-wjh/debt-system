package com.smart.bracelet.enums;

/**
 * @author liuzq
 * @version 1.0
 * @date 2020/9/21
 **/
public enum DocReplaceEnum {
    /**
     * 模板中需要替换的字段
     */
    DEBT_NAME("债权人姓名"),
    DEBT_ID_CARD("债权人身份证号码"),
    ID_CARD_ADDRESS("债权人身份证地址"),
    PHONE_NUMBER("债权人电话号码"),
    SITUATION("所属情况"),
    AMOUNT("解债金额引用小写"),
    AMOUNT_IN_WORDS("解债金额引用大写"),
    PRINCIPAL("本金金额"),
    INTEREST("利息金额"),

    ;
    private String name;

    DocReplaceEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
