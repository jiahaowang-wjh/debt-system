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
    String brpdata1;
    String brpdata2;
    String brpdata3;
    String brpdata4;
    String brpdata5;
    String brpdata6;
    String brpdata7;
    String brpdata8;
    String brpdata9;
    String brpdata10;
}
