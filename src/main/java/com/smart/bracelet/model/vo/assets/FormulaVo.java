package com.smart.bracelet.model.vo.assets;

import lombok.Data;

@Data
public class FormulaVo {

    /**
     * 期限
     */
    String deadline;
    /**
     * 解债金额
     */
    String money;
    /**
     * 成本与债权占比
     */
    String debtScale;

    /**
     * 实际实现债权
     */
    String debtActual;
    /**
     * 服务费比例
     */
    String serviceChargeScale;
    /**
     * 化解系数
     */
    String resolveNum;
    /**
     * 解债货款总成本
     */
    String totalCost;
    /**
     * 货款总额
     */
    String totalMoney;
    /**
     * 货款款
     */
    String loan;
    /**
     * 咨询服务费
     */
    String consultingMoney;
    /**
     * 实际获得
     */
    String actualMoney;
    /**
     * 平均每月
     */
    String average;
    /**
     * 回本时间
     * （月）
     */
    String payBack;


}
