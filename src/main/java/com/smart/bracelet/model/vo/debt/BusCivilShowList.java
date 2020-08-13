package com.smart.bracelet.model.vo.debt;
import lombok.Data;

@Data
public class BusCivilShowList {

    /**
     * 民事调解ID
     */
    private Long civilId;

    /**
     * 报备ID
     */
    private Long reportId;

    /**
     * 报备号
     */
    private String reportNo;
    /**
     * 民事调解号
     */
    private String civilno;

    /**
     * 债事人姓名
     */
    private String debtName;

    /**
     * 状态
     */
    private String status;

}
