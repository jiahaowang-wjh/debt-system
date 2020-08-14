package com.smart.bracelet.model.vo.debt;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class DebtInfoQuery {

    /**
     * 债事人
     */
    String debtName;
    /**
     * 报备编号
     */
    String debtNo;
    /**
     * 审核状态
     */
    String status;
    /**
     * 起始日期
     */
    String beginDate;
    /**
     * 截至日期
     */
    String endDate;

}
