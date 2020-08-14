package com.smart.bracelet.model.vo.debt;

import lombok.Data;

@Data
public class BusCivilInfo {
    /**
     * 调解ID
     */
    Long civilId;
    /**
     * 报备ID
     */
    Long reportId;
    /**
     * 报备编号
     */
    String reportNo;
    /**
     * 调解编号
     */
    String civilno;
    /**
     * 债事人
     */
    String debtName;
    /**
     * 调解状态
     */
    String status;
}
