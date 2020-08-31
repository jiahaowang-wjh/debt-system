package com.smart.bracelet.model.po.assets;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * bus_confirm
 *
 * @author
 */
@Data
public class BusConfirm implements Serializable {

    /**
     * 确认ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long confirmtId;

    /**
     * 资产ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "资产ID不能为空")
    private Long propertId;

    /**
     * 编号
     */
    @NotBlank(message = "编号不能为空")
    private String confirmNo;

    /**
     * 受让方
     */
    @NotBlank(message = "受让方不能为空")
    private String transferee;

    /**
     * 公司名字
     */
    @NotBlank(message = "公司名字不能为空")
    private String companyName;

    /**
     * 联系方式
     */
    @NotBlank(message = "联系方式不能为空")
    private String tel;

    /**
     * 日期
     */
    @NotNull(message = "日期不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date transfereeDate;

    /**
     * 债务人盖章
     */
    @NotBlank(message = "债务人盖章不能为空")
    private String obligorSeal;

    /**
     * 债务人签字
     */
    @NotBlank(message = "债务人签字不能为空")
    private String obligorSign;

    /**
     * 债务人日期
     */
    @NotNull(message = "债务人日期不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date obligorDate;

}