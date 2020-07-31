package com.smart.bracelet.model.vo.debt;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 企业新增实体
 */
@Data
public class BusEterpriseReportVo {

    /**
     * 报备ID
     */
    @NotNull(message = "报备ID不能为空")
    private Long reportId;

    /**
     * 所属公司ID
     */
    @NotNull(message = "所属公司ID不能为空")
    private Long companyId;

    /**
     * 推荐人ID
     */
    @NotNull(message = "推荐人ID不能为空")
    private Long userId;

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
    private String reportPropert;

    /**
     * 企业名称
     */
    @NotBlank(message = "企业名称不能为空")
    private String CompanyName;

    /**
     * 社会统一信用代码
     */
    @NotBlank(message = "社会统一信用代码不能为空")
    private String CreditCode;
    /**
     * 行业属性
     */
    @NotBlank(message = "行业属性不能为空")
    private String industryAttributes;
    /**
     * 法定代表人名称
     */
    @NotBlank(message = "法定代表人名称不能为空")
    private String LegalName;
    /**
     * 法定代表人联系电话
     */
    @NotBlank(message = "法定代表人联系电话不能为空")
    private String LegalPhone;
    /**
     * 法定代表人身份证号
     */
    @NotBlank(message = "法定代表人身份证号不能为空")
    private String LegalIdCard;
    /**
     * 注册地址
     */
    @NotBlank(message = "注册地址不能为空")
    private String address;
    /**
     * 企业联系人
     */
    @NotBlank(message = "企业联系人不能为空")
    private String ContactPerson;
    /**
     * 联系电话
     */
    @NotBlank(message = "联系电话不能为空")
    private String ContactPhone;

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
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "借款发生时间权不能为空")
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
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "借款发生时间务不能为空")
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
     * 项目责任人
     */
    @NotBlank(message = "项目责任人不能为空")
    private String prjectManager;

    /**
     * 状态
     */
    @NotBlank(message = "状态不能为空")
    private String status;

    /**
     * 阶段
     */
    @NotBlank(message = "阶段不能为空")
    private String stage;
    /**
     * 创建人Id
     */
    @NotNull(message = "创建人Id不能为空")
    private Long createUserId;

    /**
     *更新人Id
     */
    @NotNull(message = "更新人Id不能为空")
    private Long updateUserId;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}