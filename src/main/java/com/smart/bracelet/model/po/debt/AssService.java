package com.smart.bracelet.model.po.debt;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class AssService {

    /**
     * 解债iD
     */
    @NotNull(message = "解债ID不能为空")
    Long debtId;

    /**
     * 甲方身份类型类型
     */
    @NotBlank(message = "甲方身份类型类型不能为空")
    String personType;

    /**
     * 本金
     */
    @NotNull(message = "本金不能为空")
    Float servicePrincipal;
    /**
     * 利息
     */
    @NotNull(message = "利息不能为空")
    Float serviceInterest;

    /**
     * 服务协议编号
     */
    String serviceNo;
    /**
     * 服务日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "服务日期不能为空")
    Date serviceDate;

    /**
     * 公司ID
     */
    @NotNull(message = "公司ID不能为空")
    Long comId;
}
