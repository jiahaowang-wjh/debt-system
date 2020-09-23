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

    String reportPropert;

    String priPhone;

    String corBankPhone;

    String agreementDate;
}
