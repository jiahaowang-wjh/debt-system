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
 * bus_assignment_notice
 *
 * @author
 */
@Data
public class BusAssignmentNotice implements Serializable {
    /**
     * 转让通知ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long assignmentNoticeId;

    /**
     * 资产ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "资产ID不能为空")
    private Long propertId;

    /**
     * 签约日期
     */
    @NotNull(message = "签约日期不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date obligorDate;

    /**
     * 编号
     */
    @NotBlank(message = "编号不能为空")
    private String noticeNo;

    /**
     * 债务人盖章
     */
    private String obligorSeal;

    /**
     * 身份证号码
     */
    private String cardId;

    /**
     * 债务人签字
     */
    private String obligorSign;



}