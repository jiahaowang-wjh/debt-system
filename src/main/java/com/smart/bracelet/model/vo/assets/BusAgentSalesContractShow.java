package com.smart.bracelet.model.vo.assets;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.smart.bracelet.model.po.assets.BusAgentSalesContract;
import com.smart.bracelet.model.po.assets.BusAgentSalesContractModity;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * 页面资产委托代理销售合同初始化实体
 */
@Data
public class BusAgentSalesContractShow {

    /**
     * 债权人姓名
     */
    String debtName;
    /**
     * 债权人身份证号
     */
    String debtIdCard;

    /**
     * 债权人身份证地址(私人)
     */
    String priAdd;

    /**
     * 债权人身份证地址(企业/银行)
     */
    String corBankAdd;

    /**
     * 债权人电话(私人性质)
     */
    String priPhone;

    /**
     * 债权人电话(企业或银行性质)
     */
    String corBankPhone;

    /**
     * 解债年份
     */

    String debtYaer;

    /**
     * 解债开始日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    Date createTime;

    /**
     * 截至日期
     */
    String endTime;

    /**
     * 解债金额
     */
    Float amountThis;
    /**
     * 解债金额大写
     */
    String amountThisMax;

    /**
     * 每期贷款金额
     */
    String averageMoney;

    /**
     * 债权人银行卡号
     */
    String bankCard;
    /**
     * 债权人银行开户行
     */
    String bank;

    /**
     * 债事人性质
     */
    String reportPropert;

    /**
     * 销售合同编号
     */
    String salesNo;

    /**
     * 签约日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    Date contractDate;

    @JsonSerialize(using = ToStringSerializer.class)
    Long salesContractId;
    /**
     * 销售商品
     */
    List<BusAgentSalesContractModity> busAgentSalesContractModity;
}
