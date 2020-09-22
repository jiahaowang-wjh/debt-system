package com.smart.bracelet.model.vo.assets;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 资产债权转让通知书页面初始化实体
 */
@Data
public class BusAssignmentNoticeShow {

    /**
     * 债务人姓名
     */
    String personName;
    /**
     *债权人姓名
     */
    String debtName;
    /**
     *债务人身份证号
     */
    String idCard;
    /**
     *债事原因
     */
    String personReason;
    /**
     *解债金额
     */
    Float amountThis;

    /**
     *债权转让协议编号
     */
    String assignmentAgreementNo;

    /**
     * 通知书编号
     */
    String noticeNo;

    /**
     * 当前日期
     */
    String contractTime;
}
