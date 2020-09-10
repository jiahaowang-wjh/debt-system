package com.smart.bracelet.model.po.debt;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * bus_investigate_report
 *
 * @author
 */
@Data
public class BusInvestigateReport implements Serializable {


    /**
     *报告ID
     */
    private Long reportId;
    /**
     *解债ID
     */
    @NotNull(message = "解债ID不能为空")
    private Long debtId;
    /**
     *申请单位名称
     */
    @NotBlank(message = "申请单位名称不能为空")
    private String unitName;
    /**
     *客户经理
     */
    @NotBlank(message = "客户经理不能为空")
    private String accountManager;
    /**
     *报告完成日期
     */
    @NotNull(message = "报告完成日期不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date reportFinashDate;
    /**
     *申请客户名称
     */
    @NotBlank(message = "申请客户名称不能为空")
    private String accountName;
    /**
     *注册资金
     */
    @NotNull(message = "注册资金不能为空")
    private Long registeredCapital;
    /**
     *成立时间
     */
    @NotNull(message = "成立时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date foundTime;
    /**
     *经营地址
     */
    @NotBlank(message = "经营地址不能为空")
    private String managementAddr;
    /**
     *经营
     */
    @NotBlank(message = "经营不能为空")
    private String management;
    /**
     *业务
     */
    @NotBlank(message = "业务不能为空")
    private String business;
    /**
     *法人名称
     */
    @NotBlank(message = "法人名称不能为空")
    private String legalpersonName;
    /**
     *法人性别
     */
    @NotBlank(message = "法人性别不能为空")
    private String legalpersonSex;
    /**
     *法人年龄
     */
    @NotBlank(message = "法人年龄不能为空")
    private String legalpersonAge;
    /**
     *法人学历
     */
    @NotBlank(message = "法人学历不能为空")
    private String legalpersonEdu;
    /**
     *法人婚否
     */
    @NotBlank(message = "法人婚否不能为空")
    private String legalpersonMirr;
    /**
     *法人电话
     */
    @NotBlank(message = "法人电话不能为空")
    private String legalpersonTel;
    /**
     *法人公司占股
     */
    @NotBlank(message = "法人公司占股不能为空")
    private String legalpersonStock;
    /**
     *股东名称
     */
    @NotBlank(message = "股东名称不能为空")
    private String stockName;
    /**
     *股东性别
     */
    @NotBlank(message = "股东性别不能为空")
    private String stockSex;
    /**
     *股东年龄
     */
    @NotBlank(message = "股东年龄不能为空")
    private String stockAge;
    /**
     *股东学历
     */
    @NotBlank(message = "股东学历不能为空")
    private String stockEdu;
    /**
     *股东婚否
     */
    @NotBlank(message = "股东婚否不能为空")
    private String stockMirr;
    /**
     *股东电话
     */
    @NotBlank(message = "股东电话不能为空")
    private String stockTel;
    /**
     *股东公司占股
     */
    @NotBlank(message = "股东公司占股不能为空")
    private String stockStock;
    /**
     *股东名称1
     */
    @NotBlank(message = "股东名称1不能为空")
    private String stock1Name;
    /**
     *股东性别1
     */
    @NotBlank(message = "股东性别1不能为空")
    private String stock1Sex;
    /**
     *股东年龄1
     */
    @NotBlank(message = "股东年龄1不能为空")
    private String stock1Age;
    /**
     *股东学历1
     */
    @NotBlank(message = "股东学历1不能为空")
    private String stock1Edu;
    /**
     *股东婚否1
     */
    @NotBlank(message = "股东婚否1不能为空")
    private String stock1Mirr;
    /**
     *股东电话1
     */
    @NotBlank(message = "股东电话1不能为空")
    private String stock1Tel;
    /**
     *股东公司占股1
     */
    @NotBlank(message = "股东公司占股1不能为空")
    private String stock1Stock;
    /**
     *公司总负债
     */
    @NotBlank(message = "公司总负债不能为空")
    private String companyTotalLiab;
    /**
     *总负债率
     */
    @NotBlank(message = "总负债率不能为空")
    private String totalLiabRate;
    /**
     *合计银行
     */
    @NotBlank(message = "合计银行不能为空")
    private String totalBank;
    /**
     *银行1
     */
    @NotBlank(message = "银行1不能为空")
    private String bank1;
    /**
     *金额1
     */
    @NotBlank(message = "金额1不能为空")
    private String amount1;
    /**
     *银行2
     */
    @NotBlank(message = "银行2不能为空")
    private String bank2;
    /**
     *金额2
     */
    @NotBlank(message = "金额2不能为空")
    private String amount2;
    /**
     *银行3
     */
    @NotBlank(message = "银行3不能为空")
    private String bank3;
    /**
     *金额3
     */
    @NotBlank(message = "金额3不能为空")
    private String amount3;
    /**
     *民营金融机构
     */
    @NotBlank(message = "民营金融机构不能为空")
    private String privateFinance;
    /**
     *小贷公司
     */
    @NotBlank(message = "小贷公司不能为空")
    private String smallCompany;
    /**
     *担保公司
     */
    @NotBlank(message = "担保公司不能为空")
    private String guaranteeCompany;
    /**
     *基金公司
     */
    @NotBlank(message = "基金公司不能为空")
    private String fundCompany;
    /**
     *借贷合计
     */
    @NotNull(message = "借贷合计不能为空")
    private Float toloanCount;
    /**
     *是否涉及非法集资
     */
    @NotBlank(message = "是否涉及非法集资不能为空")
    private String isIllFund;
    /**
     *5万
     */
    @NotNull(message = "5万不能为空")
    private Integer fiftyThousand;
    /**
     *20万
     */
    @NotNull(message = "20万不能为空")
    private Integer twoHundredThousand;
    /**
     *50万
     */
    @NotNull(message = "50万不能为空")
    private Integer fiveHundredThousand;
    /**
     *100万
     */
    @NotNull(message = "100万不能为空")
    private Integer oneMillion;
    /**
     *100万+
     */
    @NotNull(message = "100万+不能为空")
    private Integer oneMillionAbove;
    /**
     *项目施工欠款
     */
    @NotNull(message = "项目施工欠款不能为空")
    private Float projectArrears;
    /**
     *拖欠税款
     */
    @NotNull(message = "拖欠税款不能为空")
    private Float defaultTaxes;
    /**
     *拖欠工资
     */
    @NotNull(message = "拖欠工资不能为空")
    private Float defaultWages;
    /**
     *拖欠社保金
     */
    @NotNull(message = "拖欠社保金不能为空")
    private Float defaultSocialsecurity;
    /**
     *应收帐款
     */
    @NotNull(message = "应收帐款不能为空")
    private Float receivableAccount;
    /**
     *应付
     */
    @NotNull(message = "应付不能为空")
    private Float copewith;
    /**
     *涉及司法
     */
    @NotBlank(message = "涉及司法不能为空")
    private String involvingJustice;
    /**
     *股权是否质押
     */
    @NotBlank(message = "股权是否质押不能为空")
    private String stockIspledge;
    /**
     *经营模式
     */
    @NotBlank(message = "经营模式不能为空")
    private String managModel;
    /**
     *经营规模年1
     */
    @NotNull(message = "经营规模年1不能为空")
    private Integer managModelYear1;
    /**
     *经营规模元1
     */
    @NotNull(message = "经营规模元1不能为空")
    private Float managModelMoney1;
    /**
     *产品毛利1
     */
    @NotNull(message = "产品毛利1不能为空")
    private Float prodousGrossprofit1;
    /**
     *纯利1
     */
    @NotNull(message = "纯利1不能为空")
    private Float netprofit1;
    /**
     *经营规模年2
     */
    @NotNull(message = "经营规模年2不能为空")
    private Integer managModelYear2;
    /**
     *经营规模元2
     */
    @NotNull(message = "经营规模元2不能为空")
    private Float managModelMoney2;
    /**
     *产品毛利2
     */
    @NotNull(message = "产品毛利2不能为空")
    private Float prodousGrossprofit2;
    /**
     *纯利2
     */
    @NotNull(message = "纯利2不能为空")
    private Float netprofit2;
    /**
     *朝阳行业
     */
    @NotBlank(message = "朝阳行业不能为空")
    private String sunriseIndustry;
    /**
     *夕阳行业
     */
    @NotBlank(message = "夕阳行业不能为空")
    private String sunsetIndustry;
    /**
     *新型行业
     */
    @NotBlank(message = "新型行业不能为空")
    private String newIndustry;
    /**
     *未来行业
     */
    @NotBlank(message = "未来行业不能为空")
    private String futureIndustry;
    /**
     *过剩行业
     */
    @NotBlank(message = "过剩行业不能为空")
    private String surplusIndustry;
    /**
     *淘汰类
     */
    @NotBlank(message = "淘汰类不能为空")
    private String elimination;
    /**
     *土地
     */
    @NotBlank(message = "土地不能为空")
    private String land;
    /**
     *土地性质
     */
    @NotBlank(message = "土地性质不能为空")
    private String landNature;
    /**
     *购买价
     */
    @NotNull(message = "购买价不能为空")
    private Float purchasePrice;
    /**
     *土地-评估价值
     */
    @NotNull(message = "土地-评估价值不能为空")
    private Float priceAccessValue;
    /**
     *土地-是否质押
     */
    @NotBlank(message = "土地-是否质押不能为空")
    private String priceIspledge;
    /**
     *土地-是否司法诉讼
     */
    @NotBlank(message = "土地-是否司法诉讼不能为空")
    private String priceIsjudicial;
    /**
     *土地-是否查封
     */
    @NotBlank(message = "土地-是否查封不能为空")
    private String priceIsseizure;
    /**
     *土地-详细地址
     */
    @NotBlank(message = "土地-详细地址不能为空")
    private String priceAddr;
    /**
     *房产
     */
    @NotBlank(message = "房产不能为空")
    private String houseProperty;
    /**
     *住宅
     */
    @NotBlank(message = "住宅不能为空")
    private String residence;
    /**
     *商业
     */
    @NotBlank(message = "商业不能为空")
    private String busines;
    /**
     *商服
     */
    @NotBlank(message = "商服不能为空")
    private String businesService;
    /**
     *房产详细地址
     */
    @NotBlank(message = "房产详细地址不能为空")
    private String houseAddr;
    /**
     *房产-评估价值
     */
    @NotNull(message = "房产-评估价值不能为空")
    private Float houseAccessValue;
    /**
     *房产-是否质押
     */
    @NotBlank(message = "房产-是否质押不能为空")
    private String houseIspledge;
    /**
     *房产-是否司法诉讼
     */
    @NotBlank(message = "房产-是否司法诉讼不能为空")
    private String houseIsjudicial;
    /**
     *房产-是否查封
     */
    @NotBlank(message = "房产-是否查封不能为空")
    private String houseIsseizure;
    /**
     *住宅1
     */
    @NotBlank(message = "住宅1不能为空")
    private String residence1;
    /**
     *住宅-评估价值
     */
    @NotBlank(message = "住宅-评估价值不能为空")
    private String residenceAccessValue;
    /**
     *住宅-是否质押
     */
    @NotBlank(message = "住宅-是否质押不能为空")
    private String residenceIspledge;
    /**
     *住宅-是否司法诉讼
     */
    @NotBlank(message = "住宅-是否司法诉讼不能为空")
    private String residenceIsjudicial;
    /**
     *住宅-是否查封
     */
    @NotBlank(message = "住宅-是否查封不能为空")
    private String residenceIsseizure;
    /**
     *商业1
     */
    @NotBlank(message = "商业1不能为空")
    private String busines1;
    /**
     *商业-评估价值
     */
    @NotBlank(message = "商业-评估价值不能为空")
    private String businesAccessValue;
    /**
     *商业-是否质押
     */
    @NotBlank(message = "商业-是否质押不能为空")
    private String businesIspledge;
    /**
     *商业-是否司法诉讼
     */
    @NotBlank(message = "商业-是否司法诉讼不能为空")
    private String businesIsjudicial;
    /**
     *商业-是否查封
     */
    @NotBlank(message = "商业-是否查封不能为空")
    private String businesIsseizure;
    /**
     *厂房
     */
    @NotBlank(message = "厂房不能为空")
    private String workshop;
    /**
     *厂房-评估价值
     */
    @NotBlank(message = "厂房-评估价值不能为空")
    private String workshopAccessValue;
    /**
     *厂房-是否质押
     */
    @NotBlank(message = "厂房-是否质押不能为空")
    private String workshopIspledge;
    /**
     *厂房-是否司法诉讼
     */
    @NotBlank(message = "厂房-是否司法诉讼不能为空")
    private String workshopIsjudicial;
    /**
     *厂房-是否查封
     */
    @NotBlank(message = "厂房-是否查封不能为空")
    private String workshopIsseizure;
    /**
     *设备
     */
    @NotBlank(message = "设备不能为空")
    private String device;
    /**
     *设备-评估价值
     */
    @NotBlank(message = "设备-评估价值不能为空")
    private String deviceAccessValue;
    /**
     *专业设备
     */
    @NotBlank(message = "专业设备不能为空")
    private String majorDevice;
    /**
     *通用设备
     */
    @NotBlank(message = "通用设备不能为空")
    private String commonDevice;
    /**
     *其它-评估价值
     */
    @NotBlank(message = "其它-评估价值不能为空")
    private String oterAccessValue;
    /**
     *其它-是否质押
     */
    @NotBlank(message = "其它-是否质押不能为空")
    private String oterIspledge;
    /**
     *其它-是否司法诉讼
     */
    @NotBlank(message = "其它-是否司法诉讼不能为空")
    private String oterIsjudicial;
    /**
     *其它-是否查封
     */
    @NotBlank(message = "其它-是否查封不能为空")
    private String oterIsseizure;
    /**
     *建设用地规划许可证
     */
    @NotBlank(message = "建设用地规划许可证不能为空")
    private String buildUselandLicence;
    /**
     *建设工程规划许可证
     */
    @NotBlank(message = "建设工程规划许可证不能为空")
    private String buildEnginLicence;
    /**
     *建设工程施工许可证
     */
    @NotBlank(message = "建设工程施工许可证不能为空")
    private String enginConstrucLicence;
    /**
     *投资项目备案证
     */
    @NotBlank(message = "投资项目备案证不能为空")
    private String investmentProjectRecord;
    /**
     *项目预售房许可证
     */
    @NotBlank(message = "项目预售房许可证不能为空")
    private String projectPrehouseLicence;
    /**
     *项目建设合同
     */
    @NotBlank(message = "项目建设合同不能为空")
    private String projectBuildContract;
    /**
     *项目建设公司资质
     */
    @NotBlank(message = "项目建设公司资质不能为空")
    private String projectBuildCompany;
    /**
     *营业执照
     */
    @NotBlank(message = "营业执照不能为空")
    private String businessLicense;
    /**
     *税务申报
     */
    @NotBlank(message = "税务申报不能为空")
    private String taxDeclaration;
    /**
     *企业工商报告
     */
    @NotBlank(message = "企业工商报告不能为空")
    private String enterpriseBusReport;
    /**
     *企业产调证明
     */
    @NotBlank(message = "企业产调证明不能为空")
    private String enterpriseProducProve;
    /**
     *项目优势
     */
    @NotBlank(message = "项目优势不能为空")
    private String projectAdvantage;
    /**
     *项目弱点
     */
    @NotBlank(message = "项目弱点不能为空")
    private String projectWeakness;
    /**
     *项目总体评价
     */
    @NotBlank(message = "项目总体评价不能为空")
    private String projectPopulation;
    /**
     *债事人评价
     */
    @NotBlank(message = "债事人评价不能为空")
    private String debtorEvaluate;
    /**
     *其它补充情况
     */
    @NotBlank(message = "其它补充情况不能为空")
    private String otherSupplement;
    /**
     *调查结论
     */
    @NotBlank(message = "调查结论不能为空")
    private String investigationConclusion;
    /**
     *调查人
     */
    @NotBlank(message = "调查人不能为空")
    private String investigationPerson;
    /**
     *日期
     */
    @NotNull(message = "日期不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date investigationDate;
    /**
     *项目总体评价完全满足/基本满足
     */
    @NotBlank(message = "项目总体评价完全满足/基本满足不能为空")
    private String projectIspopulation;

}