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
 * bus_assignment_agreement
 *
 * @author
 */
@Data
public class BusAssignmentAgreement implements Serializable {
    /**
     * 转让协议ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long assignmentAgreementId;

    /**
     * 转让协议编号
     */
    @NotBlank(message = "转让协议编号不能为空")
    private String assignmentAgreementNo;

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
    Date contractTime;


}