package com.smart.bracelet.model.vo.debt;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 私人性质相对人
 */
@Data
public class BusRelativePersonPrivateVo {
    /**
     * 相对人ID
     */
    private Long relativePerId;

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
     * 暨尽调协议编号
     */
    @NotBlank(message = "暨尽调协议编号不能为空")
    private String agreementNo;
    /**
     * 是否从业
     */
    @NotBlank(message = "是否从业不能为空")
    private String ifWork;

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
     * 姓名
     */
    @NotBlank(message = "姓名不能为空")
    private String personalName;

    /**
     * 手机号码
     */
    @NotBlank(message = "手机号码不能为空")
    private String phone;

    /**
     * 身份证号码
     */
    @NotBlank(message = "身份证号码不能为空")
    private String IdCard;

    /**
     * 性别
     */
    @NotBlank(message = "性别不能为空")
    private String sex;

    /**
     * 所在地区
     */
    @NotBlank(message = "所在地区不能为空")
    private String Area;

    /**
     * 电子邮箱
     */
    @NotBlank(message = "电子邮箱不能为空")
    private String Email;

    /**
     * 资产总价值 （元）
     */
    @NotBlank(message = "资产总价值不能为空")
    private String assets;

    /**
     * 资产项数
     */
    @NotBlank(message = "资产项数不能为空")
    private String assetsNumber ;

    /**
     * 可流通资产价值（元）
     */
    @NotBlank(message = "可流通资产价值不能为空")
    private String CirculationAssets;


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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
     * 更新人
     */
    @NotNull(message = "更新人不能为空")
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
