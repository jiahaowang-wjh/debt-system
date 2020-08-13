package com.smart.bracelet.model.vo.debt;

import lombok.Data;

/**
 * 页面债事信息字段封装实体
 */
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
}
