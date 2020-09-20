package com.smart.bracelet.model.vo.debt;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class CumOutInfo {


    /**
     * 债事人
     */
    String debtName;
    /**
     * 身份正
     */
    String idCard;

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
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    Date agreementDate;



}
