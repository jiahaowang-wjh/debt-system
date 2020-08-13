package com.smart.bracelet.model.vo.debt;

import lombok.Data;

import java.util.Date;

/**
 * 页面债事信息展示(债行)
 */
@Data
public class DebtInfoShow {

    /**
     * 报备ID
     */
    Long reportId;
    /**
     * 报备编号
     */
    String reportNo;
    /**
     * 债事人
     */
    String debtName;
    /**
     * 相对人
     */
    String busRelativeName;
    /**
     * 录入人
     */
    String inputUserName;
    /**
     * 推荐人
     */
    String recomName;

    /**
     * 化解次数
     */
    int resolveCount;

    /**
     * 化解编号
     */
    String resolveNo;

    /**
     * 化解金额
     */
    Float amountCumulative;

    /**
     * 提交时间
     */
    Date subMitDate;

    /**
     * 审核时间
     */
    Date auditDate;

    /**
     * 审批内容
     */
    String approvalContent;

    /**
     * 审核状态
     */
    String status;

}
