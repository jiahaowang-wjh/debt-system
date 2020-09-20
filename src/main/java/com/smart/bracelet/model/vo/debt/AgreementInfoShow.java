package com.smart.bracelet.model.vo.debt;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 信息分析暨尽调协议
 */
@Data
public class AgreementInfoShow {

    String debtName;

    String idCard;

    String agreementNo;

    String partyA;

    String partyB;

    String reportPropert;

    String priPhone;

    String corBankPhone;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    Date createTime;
}
