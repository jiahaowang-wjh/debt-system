package com.smart.bracelet.model.vo.debt;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;

@Data
public class DebtInfo {

    /**
     * 报备ID
     */
    Long reportId;
    /**
     * 报备编号
     */
    String reportNo;
    /**
     * 债事人姓名
     */
    String debtName;
    /**
     * 相对人个数
     */
    int busRelativeCount;
    /**
     * 录入人
     */
    String inputName;
    /**
     * 推荐人
     */
    String recommendName;
    /**
     * 化解次数
     */
    int resolveCount;
    /**
     * 化解金额
     */
    Float cumulativeSum;
    /**
     * 提交时间
     */
    @JsonFormat(pattern = "yyyy-mm-dd")
    Date submitDate;
    /**
     * 审核时间
     */
    @JsonFormat(pattern = "yyyy-mm-dd")
    Date checkDate;
    /**
     * 审批内容
     */
    String checkReason;
    /**
     * 审核状态
     */
    String status;

}