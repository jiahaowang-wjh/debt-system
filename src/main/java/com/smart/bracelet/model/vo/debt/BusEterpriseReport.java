package com.smart.bracelet.model.vo.debt;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 企业报备实体
 */
@Data
public class BusEterpriseReport {
    /**
     * 报备ID
     */
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
     * 报备号
     */
    private String reportNo;

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
    private String companyName;

    /**
     * 社会统一信用代码
     */
    private String creditCode;
    /**
     * 行业属性
     */
    private String industryAttributes;
    /**
     * 法定代表人名称
     */
    private String legalName;
    /**
     * 法定代表人联系电话
     */
    private String legalPhone;
    /**
     * 法定代表人身份证号
     */
    private String legalIdCard;

    /**
     * 选择银行
     */
    @NotBlank(message = "银行不能为空")
    private String bank;

    /**
     * 法定代表人银行卡号
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
     * 注册地址
     */
    private String address;
    /**
     * 企业联系人
     */
    private String contactPerson;
    /**
     * 联系电话
     */
    private String contactPhone;

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
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @NotNull(message = "借款发生时间权不能为空")
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
    @DateTimeFormat(pattern="yyyy-MM-dd")
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
    private String status;

    /**
     * 阶段
     */
    private String stage;
    /**
     * 创建人Id
     */
    @NotNull(message = "创建人Id不能为空")
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
