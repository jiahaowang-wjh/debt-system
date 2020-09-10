package com.smart.bracelet.model.vo.debt;

import lombok.Data;

@Data
public class DebtMoney {

    Long relativePerId;
    /**
     * 总债额
     */
    Float interestAll;
    /**
     * 本次化解债额
     */
    Float amountCumulative;
}
