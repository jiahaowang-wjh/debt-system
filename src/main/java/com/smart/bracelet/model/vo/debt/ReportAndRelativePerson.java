package com.smart.bracelet.model.vo.debt;

import lombok.Data;

@Data
public class ReportAndRelativePerson {
    /**
     * 报备ID
     */
   private Long reportId;

    /**
     *相对人ID
     */
    private Long relativeperId;

    /**
     * 债事人性质
     */
    private String reportPropert;

    /**
     * 相对人性质
     */
    String brpReport;
    /**
     * 债事人信息
     */
    String data1;
    String data2;
    String data3;
    String data4;
    String data5;
    String data6;
    String data7;
    String data8;
    String data9;
    String data10;
    /**
     * 相对人信息
     */
    String brpData1;
    String brpData2;
    String brpData3;
    String brpData4;
    String brpData5;
    String brpData6;
    String brpData7;
    String brpData8;
    String brpData9;
    String brpData10;

    Float amountTotal;
}
