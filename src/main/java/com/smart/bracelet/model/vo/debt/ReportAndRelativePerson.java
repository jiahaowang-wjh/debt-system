package com.smart.bracelet.model.vo.debt;

import lombok.Data;

@Data
public class ReportAndRelativePerson {

    /**
     * 报备ID
     */
    Long reportId;
    /**
     *债事人姓名
     */
    String debtName;
    /**
     *相对人ID
     */
    Long relativeperId;
    /**
     *相对人姓名
     */
    String personalName;
}
