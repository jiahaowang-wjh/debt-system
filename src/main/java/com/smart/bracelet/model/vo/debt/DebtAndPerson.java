package com.smart.bracelet.model.vo.debt;

import lombok.Data;

/**
 * 债事人相对人
 */
@Data
public class DebtAndPerson {
    /**
     * 报备Id
     */
    Long reportId;
    /**
     * 相对人ID
     */
    Long relativePerId;

    /**
     * 债事人身份证号
     */
    String debtIdcard;
    /**
     * 相对人身份证号
     */
    String personIdcard;


}
