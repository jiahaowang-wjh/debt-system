package com.smart.bracelet.model.vo.debt;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * bus_report
 * @author 
 */
@Data
public class BusReportVo implements Serializable {
    private static final long serialVersionUID = -408763984101280244L;
    /**
     * 报备ID
     */
    @NotNull(message = "报备ID不能为空")
    private Long reportId;

    /**
     * 所属公司ID
     */
    private Long companyId;

    /**
     * 报备号
     */
    private String reportNo;

    /**
     * 推荐人ID
     */
    private Long userId;

    /**
     * 是否配合
     */
    private String iscoordinate;

    /**
     * 类型
     */
    private String reportType;

    /**
     * 性质
     */
    private String reportPropert;

    /**
     * 数据一
     */
    private String data1;

    /**
     * 数据二
     */
    private String data2;

    /**
     * 数据三
     */
    private String data3;

    /**
     * 数据四
     */
    private String data4;

    /**
     * 数据五
     */
    private String data5;

    /**
     * 数据六
     */
    private String data6;

    /**
     * 数据七
     */
    private String data7;

    /**
     * 数据八
     */
    private String data8;

    /**
     * 数据九
     */
    private String data9;

    /**
     * 数据十
     */
    private String data10;

    /**
     * 数据十一
     */
    private String data11;

    /**
     * 身份证正
     */
    private String cardJust;

    /**
     * 身份证反
     */
    private String cardBack;

    /**
     * 债权
     */
    private String obligatRight;

    /**
     * 债权笔数
     */
    private Integer obligatRightNo;

    /**
     * 借款发生时间权
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date obligatTime;

    /**
     * 本金
     */
    private Float capital;

    /**
     * 利息
     */
    private Float interest;

    /**
     * 利率
     */
    private Float interestRate;

    /**
     * 债务
     */
    private String debt;

    /**
     * 债务笔数
     */
    private Integer debtNo;

    /**
     * 借款发生时间务
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date debtTime;

    /**
     * 债事凭证
     */
    private String debtCertificate;

    /**
     * 上传债事凭证
     */
    private String uploadDebtCertificate;

    /**
     * 是否诉讼及结果
     */
    private String isResult;

    /**
     * 目前经济状况
     */
    private String economics;

    /**
     * 项目责任人
     */
    private String prjectManager;

    /**
     * 状态
     */
    private String status;

    /**
     * 阶段
     */
    private String stage;
    /**
     * 创建人Id
     */
    private Long createUserId;


    /**
     * 创建时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createTime;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updateTime;

}