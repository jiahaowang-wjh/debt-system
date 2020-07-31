package com.smart.bracelet.model.vo.debt;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DebtChain {

    /**
     * 债事人
     */
    String Report;
    /**
     * 相对人
     */
    String RelativePerson;
    /**
     * 相对人身份证号
     */
    String RelativePersonIdCad;

    /**
     * 父级ID
     */
    int fatherId;

    //相对人
    List<DebtChain> aa;

}
