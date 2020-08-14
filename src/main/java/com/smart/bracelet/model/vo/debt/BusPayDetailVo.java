package com.smart.bracelet.model.vo.debt;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * bus_pay_detail
 *
 * @author
 */
@Data
public class BusPayDetailVo implements Serializable {
    private static final long serialVersionUID = -1201383858936745186L;
    /**
     * 支付ID
     */
    @NotNull(message = "支付ID不能为空")
    private Long payId;

    /**
     * 报备ID
     */
    @NotNull(message = "报备ID不能为空")
    private Long reportId;

    /**
     * 支付编号
     */
    @NotBlank(message = "支付编号不能为空")
    private String payNo;

    /**
     * 合同姓名
     */
    @NotBlank(message = "合同姓名不能为空")
    private String contractName;

    /**
     * 打款人姓名
     */
    @NotBlank(message = "打款人姓名不能为空")
    private String payertName;

    /**
     * 凭证
     */
    @NotBlank(message = "凭证不能为空")
    private String voucher;

    /**
     * 费用
     */
    @NotBlank(message = "费用不能为空")
    private String cost;

    /**
     * 标志
     */
    @NotBlank(message = "标志不能为空")
    private String flag;

    /**
     * 状态
     */
    @NotBlank(message = "状态不能为空")
    private String status;
}