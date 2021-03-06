package com.smart.bracelet.model.po.debt;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * bus_relative_person
 * @author 
 */
@Data
public class BusRelativePerson implements Serializable {
    private static final long serialVersionUID = -7710652267463054094L;
    /**
     * 相对人ID
     */
    private Long relativePerId;
    /**
     * 暨尽调协议编号
     */
    @NotBlank(message = "暨尽调协议编号不能为空")
    private String agreementNo;
    /**
     * 报备ID
     */
    @NotNull(message = "报备ID不能为空")
    private Long reportId;

    /**
     * 是否配合
     */
    @NotBlank(message = "是否配合不能为空")
    private String iscoordinate;

    /**
     * 类型
     */
    @NotBlank(message = "类型不能为空")
    private String reportType;

    /**
     * 性质
     */
    @NotBlank(message = "不能为空")
    private String reportPropert;

    /**
     * 数据一
     */
    @NotBlank(message = "数据一不能为空")
    private String data1;

    /**
     * 数据二
     */
    @NotBlank(message = "数据二不能为空")
    private String data2;

    /**
     * 数据三
     */
    @NotBlank(message = "数据三不能为空")
    private String data3;

    /**
     * 数据四
     */
    @NotBlank(message = "数据四不能为空")
    private String data4;

    /**
     * 数据五
     */
    @NotBlank(message = "数据五不能为空")
    private String data5;

    /**
     * 数据六
     */
    @NotBlank(message = "数据六不能为空")
    private String data6;

    /**
     * 数据七
     */
    @NotBlank(message = "不能为空")
    private String data7;

    /**
     * 数据八
     */
    @NotBlank(message = "数据八不能为空")
    private String data8;

    /**
     * 数据九
     */
    @NotBlank(message = "数据九不能为空")
    private String data9;


    /**
     * 数据十
     */
    private String data10;


    /**
     * 身份证正
     */
    @NotBlank(message = "身份证正不能为空")
    private String cardJust;

    /**
     * 身份证反
     */
    @NotBlank(message = "身份证反不能为空")
    private String cardBack;

    /**
     * 债权
     */
    @NotBlank(message = "债权不能为空")
    private String obligatRight;

    /**
     * 债权笔数
     */
    @NotNull(message = "债权笔数不能为空")
    private Integer obligatRightNo;

    /**
     * 借款发生时间权
     */
    @NotNull(message = "借款发生时间权不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date obligatTime;

    /**
     * 本金
     */
    @NotNull(message = "本金不能为空")
    private Float capital;

    /**
     * 利息
     */
    @NotNull(message = "利息不能为空")
    private Float interest;

    /**
     * 利率
     */
    @NotNull(message = "利率不能为空")
    private Float interestRate;

    /**
     * 债务
     */
    @NotBlank(message = "债务不能为空")
    private String debt;

    /**
     * 债务笔数
     */
    @NotNull(message = "债务笔数不能为空")
    private Integer debtNo;

    /**
     * 借款发生时间务
     */
    @NotNull(message = "借款发生时间务不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date debtTime;

    /**
     * 债事凭证
     */
    @NotBlank(message = "债事凭证不能为空")
    private String debtCertificate;

    /**
     * 上传债事凭证
     */
    @NotBlank(message = "上传债事凭证不能为空")
    private String uploadDebtCertificate;

    /**
     * 是否诉讼及结果
     */
    @NotBlank(message = "是否诉讼及结果不能为空")
    private String isResult;

    /**
     * 目前经济状况
     */
    @NotBlank(message = "目前经济状况不能为空")
    private String economics;

    /**
     * 是负债经济使用用途
     */
    @NotBlank(message = "是负债经济使用用途不能为空")
    private String usage;

    /**
     * 项目责任人
     */
    @NotBlank(message = "项目责任人不能为空")
    private String prjectManager;


    /**
     * 创建人
     */
    @NotNull(message = "创建人不能为空")
    private Long createUserId;


    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 状态
     */
    String status;

}