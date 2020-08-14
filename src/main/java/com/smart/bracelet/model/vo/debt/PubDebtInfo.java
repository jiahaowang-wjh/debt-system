package com.smart.bracelet.model.vo.debt;

import lombok.Data;

@Data
public class PubDebtInfo {
    /**
     * 报备编号
     */
    String reportNo;
    /**
     *民事调解编号
     */
    String civilno;
    /**
     *报备Id
     */
    Long debtId;
    /**
     *解债编号
     */
    String debtNo;
    /**
     *解债状态
     */
    String status;
    /**
     *债事人
     */
    String debtName;
    /**
     *报备Id
     */
    Long reportId;
}
