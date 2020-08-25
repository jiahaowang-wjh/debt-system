package com.smart.bracelet.model.vo.assets;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * bus_assessment
 *
 * @author
 */
@Data
public class BusAssessmentVo implements Serializable {

    /**
     * 资产评估ID
     */
    @NotNull(message = "不能为空资产评估ID")
    private Long assessmentId;

    /**
     * 资产评估编号
     */
    @NotNull(message = "资产评估编号产评估ID")
    private String assessmentNo;

    /**
     * 资产ID
     */
    @NotNull(message = "资产ID不能为空")
    private Long propertId;

    /**
     * 评估日期
     */
    @NotNull(message = "评估日期不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date assessmentDate;

    /**
     * 凭证
     */
    @NotBlank(message = "凭证不能为空")
    private String credentials;

    /**
     * 其他情况说明
     */
    private String card;

    /**
     * 公司负责人
     */
    @NotBlank(message = "公司负责人不能为空")
    private String companyManag;

    /**
     * 状态
     */
    @NotBlank(message = "状态不能为空")
    private String status;

    /**
     * 审核原因
     */
    private String checkReason;

    /**
     * 审核时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checkDate;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;


}