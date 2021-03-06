package com.smart.bracelet.model.vo.assets;

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
public class BusAssignmentNoticeVo implements Serializable {
    /**
     * 转让通知ID
     */
    @NotNull(message = "转让通知ID不能为空")
    private Long assignmentNoticeId;

    /**
     * 资产ID
     */
    @NotNull(message = "资产ID不能为空")
    private Long propertId;

    /**
     * 编号
     */
    @NotBlank(message = "编号不能为空")
    private String noticeNo;

    /**
     * 债务人盖章
     */
    @NotBlank(message = "债务人盖章不能为空")
    private String obligorSeal;

    /**
     * 身份证号码
     */
    @NotBlank(message = "身份证号码不能为空")
    private String cardId;

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