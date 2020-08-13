package com.smart.bracelet.model.vo.debt;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class DebtInfoListShow {

    DebtInfo debtInfo;

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
    @JsonFormat(pattern="yyyy-MM-dd")
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
