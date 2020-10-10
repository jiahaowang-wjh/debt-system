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
    private String unitName;
    /**
     *客户经理
     */
    private String accountManager;
    /**
     *报告完成日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date reportFinashDate;
    /**
     *申请客户名称
     */
    private String accountName;
    /**
     *注册资金
     */
    private Long registeredCapital;
    /**
     *成立时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date foundTime;
    /**
     *经营地址
     */
    private String managementAddr;
    /**
     *经营
     */
    private String management;
    /**
     *业务
     */
    @NotBlank(message = "业务不能为空")
    private String business;
    /**
     *法人名称
     */
    private String legalpersonName;
    /**
     *法人性别
     */
    private String legalpersonSex;
    /**
     *法人年龄
     */
    private String legalpersonAge;
    /**
     *法人学历
     */
    private String legalpersonEdu;
    /**
     *法人婚否
     */
    private String legalpersonMirr;
    /**
     *法人电话
     */
    private String legalpersonTel;
    /**
     *法人公司占股
     */
    private String legalpersonStock;
    /**
     *股东名称
     */
    private String stockName;
    /**
     *股东性别
     */
    private String stockSex;
    /**
     *股东年龄
     */
    private String stockAge;
    /**
     *股东学历
     */
    private String stockEdu;
    /**
     *股东婚否
     */
    private String stockMirr;
    /**
     *股东电话
     */
    private String stockTel;
    /**
     *股东公司占股
     */
    private String stockStock;
    /**
     *股东名称1
     */
    private String stock1Name;
    /**
     *股东性别1
     */
    private String stock1Sex;
    /**
     *股东年龄1
     */
    private String stock1Age;
    /**
     *股东学历1
     */
    private String stock1Edu;
    /**
     *股东婚否1
     */
    private String stock1Mirr;
    /**
     *股东电话1
     */
    private String stock1Tel;
    /**
     *股东公司占股1
     */
    private String stock1Stock;
    /**
     *公司总负债
     */
    private String companyTotalLiab;
    /**
     *总负债率
     */
    private String totalLiabRate;
    /**
     *合计银行
     */
    private String totalBank;
    /**
     *银行1
     */
    private String bank1;
    /**
     *金额1
     */
    private String amount1;
    /**
     *银行2
     */
    private String bank2;
    /**
     *金额2
     */
    private String amount2;
    /**
     *银行3
     */
    private String bank3;
    /**
     *金额3
     */
    private String amount3;
    /**
     *民营金融机构
     */
    private String privateFinance;
    /**
     *小贷公司
     */
    private String smallCompany;
    /**
     *担保公司
     */
    private String guaranteeCompany;
    /**
     *基金公司
     */
    private String fundCompany;
    /**
     *借贷合计
     */
    private Float toloanCount;
    /**
     *是否涉及非法集资
     */
    private String isIllFund;
    /**
     *5万
     */
    private Integer fiftyThousand;
    /**
     *20万
     */
    private Integer twoHundredThousand;
    /**
     *50万
     */
    private Integer fiveHundredThousand;
    /**
     *100万
     */
    private Integer oneMillion;
    /**
     *100万+
     */
    private Integer oneMillionAbove;
    /**
     *项目施工欠款
     */
    private Float projectArrears;
    /**
     *拖欠税款
     */
    private Float defaultTaxes;
    /**
     *拖欠工资
     */
    private Float defaultWages;
    /**
     *拖欠社保金
     */
    private Float defaultSocialsecurity;
    /**
     *应收帐款
     */
    private Float receivableAccount;
    /**
     *应付
     */
    private Float copewith;
    /**
     *涉及司法
     */
    private String involvingJustice;
    /**
     *股权是否质押
     */
    private String stockIspledge;
    /**
     *经营模式
     */
    private String managModel;
    /**
     *经营规模年1
     */
    private Integer managModelYear1;
    /**
     *经营规模元1
     */
    private Float managModelMoney1;
    /**
     *产品毛利1
     */
    private Float prodousGrossprofit1;
    /**
     *纯利1
     */
    private Float netprofit1;
    /**
     *经营规模年2
     */
    private Integer managModelYear2;
    /**
     *经营规模元2
     */
    private Float managModelMoney2;
    /**
     *产品毛利2
     */
    private Float prodousGrossprofit2;
    /**
     *纯利2
     */
    private Float netprofit2;
    /**
     *朝阳行业
     */
    private String sunriseIndustry;
    /**
     *夕阳行业
     */
    private String sunsetIndustry;
    /**
     *新型行业
     */
    private String newIndustry;
    /**
     *未来行业
     */
    private String futureIndustry;
    /**
     *过剩行业
     */
    private String surplusIndustry;
    /**
     *淘汰类
     */
    private String elimination;
    /**
     *土地
     */
    private String land;
    /**
     *土地性质
     */
    private String landNature;
    /**
     *购买价
     */
    private Float purchasePrice;
    /**
     *土地-评估价值
     */
    private Float priceAccessValue;
    /**
     *土地-是否质押
     */
    private String priceIspledge;
    /**
     *土地-是否司法诉讼
     */
    private String priceIsjudicial;
    /**
     *土地-是否查封
     */
    private String priceIsseizure;
    /**
     *土地-详细地址
     */
    private String priceAddr;
    /**
     *房产
     */
    private String houseProperty;
    /**
     *住宅
     */
    private String residence;
    /**
     *商业
     */
    private String busines;
    /**
     *商服
     */
    private String businesService;
    /**
     *房产详细地址
     */
    private String houseAddr;
    /**
     *房产-评估价值
     */
    private Float houseAccessValue;
    /**
     *房产-是否质押
     */
    private String houseIspledge;
    /**
     *房产-是否司法诉讼
     */
    private String houseIsjudicial;
    /**
     *房产-是否查封
     */
    private String houseIsseizure;
    /**
     *住宅1
     */
    private String residence1;
    /**
     *住宅-评估价值
     */
    private String residenceAccessValue;
    /**
     *住宅-是否质押
     */
    private String residenceIspledge;
    /**
     *住宅-是否司法诉讼
     */
    private String residenceIsjudicial;
    /**
     *住宅-是否查封
     */
    private String residenceIsseizure;
    /**
     *商业1
     */
    private String busines1;
    /**
     *商业-评估价值
     */
    private String businesAccessValue;
    /**
     *商业-是否质押
     */
    private String businesIspledge;
    /**
     *商业-是否司法诉讼
     */
    private String businesIsjudicial;
    /**
     *商业-是否查封
     */
    private String businesIsseizure;
    /**
     *厂房
     */
    private String workshop;
    /**
     *厂房-评估价值
     */
    private String workshopAccessValue;
    /**
     *厂房-是否质押
     */
    private String workshopIspledge;
    /**
     *厂房-是否司法诉讼
     */
    private String workshopIsjudicial;
    /**
     *厂房-是否查封
     */
    private String workshopIsseizure;
    /**
     *设备
     */
    private String device;
    /**
     *设备-评估价值
     */
    private String deviceAccessValue;
    /**
     *专业设备
     */
    private String majorDevice;
    /**
     *通用设备
     */
    private String commonDevice;
    /**
     *其它-评估价值
     */
    private String oterAccessValue;
    /**
     *其它-是否质押
     */
    private String oterIspledge;
    /**
     *其它-是否司法诉讼
     */
    private String oterIsjudicial;
    /**
     *其它-是否查封
     */
    private String oterIsseizure;
    /**
     *建设用地规划许可证
     */
    private String buildUselandLicence;
    /**
     *建设工程规划许可证
     */
    private String buildEnginLicence;
    /**
     *建设工程施工许可证
     */
    private String enginConstrucLicence;
    /**
     *投资项目备案证
     */
    private String investmentProjectRecord;
    /**
     *项目预售房许可证
     */
    private String projectPrehouseLicence;
    /**
     *项目建设合同
     */
    private String projectBuildContract;
    /**
     *项目建设公司资质
     */
    private String projectBuildCompany;
    /**
     *营业执照
     */
    private String businessLicense;
    /**
     *税务申报
     */
    private String taxDeclaration;
    /**
     *企业工商报告
     */
    private String enterpriseBusReport;
    /**
     *企业产调证明
     */
    private String enterpriseProducProve;
    /**
     *项目优势
     */
    private String projectAdvantage;
    /**
     *项目弱点
     */
    private String projectWeakness;
    /**
     *项目总体评价
     */
    private String projectPopulation;
    /**
     *债事人评价
     */
    private String debtorEvaluate;
    /**
     *其它补充情况
     */
    private String otherSupplement;
    /**
     *调查结论
     */
    private String investigationConclusion;
    /**
     *调查人
     */
    private String investigationPerson;
    /**
     *日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date investigationDate;
    /**
     *项目总体评价完全满足/基本满足
     */
    private String projectIspopulation;

}