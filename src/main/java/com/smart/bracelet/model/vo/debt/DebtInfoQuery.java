package com.smart.bracelet.model.vo.debt;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class DebtInfoQuery {

    /**
     * 债事人
     */
    String debtName;

    /**
     * 相对人
     */
    String personName;

    /**
     * 报备编号
     */
    String reportNo;
    /**
     * 审核状态
     */
    String status;
    /**
     * 起始日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    String beginDate;
    /**
     * 截至日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    String endDate;

    /**
     * 民事调解编号
     */
    String civilno;

    @NotBlank(message = "公司类型不能为空")
    String companyType;
}
