package com.smart.bracelet.model.vo.debt;

import lombok.Data;

/**
 * 民事调解信息填写页面
 */
@Data
public class CiviIAndRepShow {
    Long reportId;
    String reportNo;
    String civilno;
    String debtName;
    String status;
}
