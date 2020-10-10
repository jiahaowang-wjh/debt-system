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
    DEBT_NO("agreementNumber"),
    DEBT_NAME("debtName"),
    DEBT_ID_CARD("debtIdCard"),
    ID_CARD_ADDRESS("idCardAddress"),
    PHONE_NUMBER("phoneNumber"),
    SITUATION("situation"),//甲方身份
    AMOUNT("amount"),
    AMOUNT_IN_WORDS("amountInWords"),
    PRINCIPAL("principal"),
    INTEREST("interest"),
    DEBT_AMOUNT_THIS("serviceFee"),
    DEBT_AMOUNT_THIS_MAX("serviceFeeInWords"),
    DEBT_YEAR("yyy1"),
    DEBT_MOON("M1"),
    DEBT_DAY("d1")
    ;
    private String name;

    DocReplaceEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
