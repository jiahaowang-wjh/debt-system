package com.smart.bracelet.model.vo.debt;

import lombok.Data;

@Data
public class DebtAndRepAndCiviI {

    /**
     * 报备ID
     */
    Long reportId;
    /**
     * 解债Id
     */
    Long debtId;
    /**
     * 解债编号
     */
    String debtNo;
    /**
     * 报备编号
     */
    String reportNo;
    /**
     * 民事调解编号
     */
    String civilno;
    /**
     * 债事人
     */
    String debtName;

}
