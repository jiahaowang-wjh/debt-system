package com.smart.bracelet.model.vo.debt;

import lombok.Data;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Data
public class DebtChain {
    //相对人
    List<DebtChain> debtChain;
    /**
     * 债事人
     */
    String Report;
    /**
     * 相对人身份证号
     */
    String RelativePersonIdCad;

    /**
     * 金额
     */
    String obligatRight;

    /**
     * 父级ID
     */
    BigInteger fatherId;

    String reportType;

}
