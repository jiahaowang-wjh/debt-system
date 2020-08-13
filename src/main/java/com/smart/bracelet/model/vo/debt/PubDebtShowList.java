package com.smart.bracelet.model.vo.debt;

import lombok.Data;
/**
 * 页面解债信息展示
 */
@Data
public class PubDebtShowList {

    /**
     * 报备Id
     */
    private Long reportId;

    /**
     * 解债ID
     */
    private Long debtId;
    /**
     * 报备编号
     */
    private String reportNo;

    /**
     * 民事调解号
     */
    private String civilno;
    /**
     * 解债编号
     */
    private String debtNo;
    /**
     * 解债状态
     */
    private String status;
    /**
     * 债事人
     */
    private String debtName;

}
