package com.smart.bracelet.model.vo.debt;

import lombok.Data;

import java.util.Date;

/**
 * 辅助下载实体
 */
@Data
public class AuxiliaryDownload {

    /**
     * 报备id
     */
    Long reportId;

    /**
     * 相对人Id
     */
    Long relativePerId;

    /**
     * 创建时间
     */
    Date createTime;

    /**
     * 债事人
     */
    String debtName;

    /**
     * 相对人
     */
    String personName;

    /**
     *合同编号
     */
    String assignmentAgreementNo;

    /**
     * 报备费
     */
    String bbCost;

    /**
     * 咨询费
     */
    String zxCost;

    /**
     * 货款费
     */
    String hcCost;

    /**
     * 解债金额
     */
    Float amountCumulative;

    /**
     * 解债年限
     */
    String debtYaer;

    /**
     * 解债类型
     */
    String debtType;

    /**
     * 分公司
     */
    String companyName;

}
