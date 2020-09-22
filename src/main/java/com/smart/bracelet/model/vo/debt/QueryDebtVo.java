package com.smart.bracelet.model.vo.debt;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@lombok.Data
public class QueryDebtVo {

    String debtNo;

    Long debtId;

    String status;

    @NotBlank(message = "公司类型不能为空")
    String companyType;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    String beginDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    String endDate;

    @NotNull(message = "公司ID不能为空")
    Long comId;
}
