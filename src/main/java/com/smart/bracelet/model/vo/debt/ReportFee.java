package com.smart.bracelet.model.vo.debt;

import lombok.Data;

import java.util.Date;

@Data
public class ReportFee {

    /**
     * 当前系统日期
     */
    Date thisTime;
    /**
     * 支付编号
     */
    String payNo;
    /**
     * 债事人姓名
     */
    String debtName;
    /**
     * 分公司名称
     */
    String companyName;
    /**
     * 缴费类型
     */
    String flag;

    /**
     * 报备ID
     */
    Long reportId;

    Float cost;
}
