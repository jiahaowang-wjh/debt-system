package com.smart.bracelet.model.vo.debt;

import org.springframework.format.annotation.DateTimeFormat;


@lombok.Data
public class QueryDebtVo {
    String debtNo;
    Long debtId;
    String status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    String beginDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    String endDate;
}
