package com.smart.bracelet.model.vo.debt;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * bus_report
 *
 * @author
 */
@Data
public class BusReportListVo implements Serializable {
    private static final long serialVersionUID = -408763984101280244L;
    /**
     * 报备ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "报备ID不能为空")
    private Long reportId;

    /**
     * 报备号
     */
    private String reportNo;

    /**
     * 所属公司ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "所属公司ID不能为空")
    private Long companyId;

    /**
     * 推荐人ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
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
    @NotBlank(message = "性质不能为空")
    private String reportPropert;
//      <------私人----->
    /**
     * 姓名
     */
    private String personalName;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 身份证号码
     */
    private String IdCard;

    /**
     * 性别
     */
    private String sex;

    /**
     * 所在地区
     */
    private String Area;

    /**
     * 电子邮箱
     */
    private String Email;

    /**
     * 资产总价值 （元）
     */
    private String assets;

    /**
     * 是否从业
     */
    private String ifWork;
    /**
     * 资产项数
     */
    private String assetsNumber;

    /**
     * 可流通资产价值（元）
     */
    private String CirculationAssets;

//    <-----企业,银行---->

    /**
     * 企业名称
     */
    private String CompanyName;

    /**
     * 社会统一信用代码
     */
    private String CreditCode;
    /**
     * 行业属性
     */
    private String industryAttributes;
    /**
     * 法定代表人名称
     */
    private String LegalName;
    /**
     * 法定代表人联系电话
     */
    private String LegalPhone;
    /**
     * 法定代表人身份证号
     */
    private String LegalIdCard;
    /**
     * 注册地址
     */
    private String address;
    /**
     * 企业联系人
     */
    private String ContactPerson;
    /**
     * 联系电话
     */
    private String ContactPhone;
//<----工共属性--->
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
     * 更新人Id
     */
    @NotNull(message = "不能为空")
    private Long updateUserId;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}