package com.smart.bracelet.model.vo.debt;

import lombok.Data;

import java.util.Date;

@Data
public class CumOutInfo {

    /**
     * 暨尽编号
     */
    String agreementNo;
    /**
     * 甲方
     */
    String partyA;
    /**
     * 乙方
     */
    String partyB;
    /**
     * 时间
     */
    Date createTime;
}
