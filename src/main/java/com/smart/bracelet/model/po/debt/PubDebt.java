package com.smart.bracelet.model.po.debt;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * pub_debt
 * @author 
 */
@Data
public class PubDebt implements Serializable {
    private static final long serialVersionUID = -2905470722408884958L;
    /**
     * 解债ID
     */
    private Long debtId;

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
    @NotBlank(message = "数据十不能为空")
    private String data10;

    /**
     * 数据十一
     */
    @NotBlank(message = "数据十一不能为空")
    private String data11;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date obligatTime;

    /**
     * 本金
     */
    @NotBlank(message = "本金不能为空")
    private String capital;

    /**
     * 利息
     */
    @NotBlank(message = "利息不能为空")
    private String interest;

    /**
     * 利率
     */
    @NotBlank(message = "利率不能为空")
    private String interestRate;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
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
     * 姓名
     */
    @NotBlank(message = "姓名不能为空")
    private String authname;

    /**
     * 身份证号码
     */
    @NotBlank(message = "身份证号码不能为空")
    private String card;

    /**
     * 选择银行
     */
    @NotBlank(message = "选择银行不能为空")
    private String bank;

    /**
     * 银行卡号
     */
    @NotBlank(message = "银行卡号不能为空")
    private String bankCard;

    /**
     * 银行预留手机号
     */
    @NotBlank(message = "银行预留手机号不能为空")
    private String bankTel;

    /**
     * 手机验证码
     */
    @NotBlank(message = "手机验证码不能为空")
    private String telCheck;

    /**
     * 创建人
     */
    @NotNull(message = "创建人不能为空")
    private Long createUserId;

    /**
     * 更新人
     */
    @NotNull(message = "更新人不能为空")
    private Long updateUserId;
}