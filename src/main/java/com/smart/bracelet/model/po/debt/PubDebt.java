package com.smart.bracelet.model.po.debt;

import java.io.Serializable;
import java.util.Date;

/**
 * pub_debt
 * @author 
 */
public class PubDebt implements Serializable {
    /**
     * 解债ID
     */
    private Long debtId;

    /**
     * 报备ID
     */
    private Long reportId;

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
    private Date obligatTime;

    /**
     * 本金
     */
    private String capital;

    /**
     * 利息
     */
    private String interest;

    /**
     * 利率
     */
    private String interestRate;

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
     * 是负债经济使用用途
     */
    private String usage;

    /**
     * 项目责任人
     */
    private String prjectManager;

    /**
     * 姓名
     */
    private String authname;

    /**
     * 身份证号码
     */
    private String card;

    /**
     * 选择银行
     */
    private String bank;

    /**
     * 银行卡号
     */
    private String bankCard;

    /**
     * 银行预留手机号
     */
    private String bankTel;

    /**
     * 手机验证码
     */
    private String telCheck;

    /**
     * 创建人
     */
    private Long createUserId;

    /**
     * 更新人
     */
    private Long updateUserId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getDebtId() {
        return debtId;
    }

    public void setDebtId(Long debtId) {
        this.debtId = debtId;
    }

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public String getIscoordinate() {
        return iscoordinate;
    }

    public void setIscoordinate(String iscoordinate) {
        this.iscoordinate = iscoordinate;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getReportPropert() {
        return reportPropert;
    }

    public void setReportPropert(String reportPropert) {
        this.reportPropert = reportPropert;
    }

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

    public String getData3() {
        return data3;
    }

    public void setData3(String data3) {
        this.data3 = data3;
    }

    public String getData4() {
        return data4;
    }

    public void setData4(String data4) {
        this.data4 = data4;
    }

    public String getData5() {
        return data5;
    }

    public void setData5(String data5) {
        this.data5 = data5;
    }

    public String getData6() {
        return data6;
    }

    public void setData6(String data6) {
        this.data6 = data6;
    }

    public String getData7() {
        return data7;
    }

    public void setData7(String data7) {
        this.data7 = data7;
    }

    public String getData8() {
        return data8;
    }

    public void setData8(String data8) {
        this.data8 = data8;
    }

    public String getData9() {
        return data9;
    }

    public void setData9(String data9) {
        this.data9 = data9;
    }

    public String getData10() {
        return data10;
    }

    public void setData10(String data10) {
        this.data10 = data10;
    }

    public String getData11() {
        return data11;
    }

    public void setData11(String data11) {
        this.data11 = data11;
    }

    public String getCardJust() {
        return cardJust;
    }

    public void setCardJust(String cardJust) {
        this.cardJust = cardJust;
    }

    public String getCardBack() {
        return cardBack;
    }

    public void setCardBack(String cardBack) {
        this.cardBack = cardBack;
    }

    public String getObligatRight() {
        return obligatRight;
    }

    public void setObligatRight(String obligatRight) {
        this.obligatRight = obligatRight;
    }

    public Integer getObligatRightNo() {
        return obligatRightNo;
    }

    public void setObligatRightNo(Integer obligatRightNo) {
        this.obligatRightNo = obligatRightNo;
    }

    public Date getObligatTime() {
        return obligatTime;
    }

    public void setObligatTime(Date obligatTime) {
        this.obligatTime = obligatTime;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    public String getDebt() {
        return debt;
    }

    public void setDebt(String debt) {
        this.debt = debt;
    }

    public Integer getDebtNo() {
        return debtNo;
    }

    public void setDebtNo(Integer debtNo) {
        this.debtNo = debtNo;
    }

    public Date getDebtTime() {
        return debtTime;
    }

    public void setDebtTime(Date debtTime) {
        this.debtTime = debtTime;
    }

    public String getDebtCertificate() {
        return debtCertificate;
    }

    public void setDebtCertificate(String debtCertificate) {
        this.debtCertificate = debtCertificate;
    }

    public String getUploadDebtCertificate() {
        return uploadDebtCertificate;
    }

    public void setUploadDebtCertificate(String uploadDebtCertificate) {
        this.uploadDebtCertificate = uploadDebtCertificate;
    }

    public String getIsResult() {
        return isResult;
    }

    public void setIsResult(String isResult) {
        this.isResult = isResult;
    }

    public String getEconomics() {
        return economics;
    }

    public void setEconomics(String economics) {
        this.economics = economics;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getPrjectManager() {
        return prjectManager;
    }

    public void setPrjectManager(String prjectManager) {
        this.prjectManager = prjectManager;
    }

    public String getAuthname() {
        return authname;
    }

    public void setAuthname(String authname) {
        this.authname = authname;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public String getBankTel() {
        return bankTel;
    }

    public void setBankTel(String bankTel) {
        this.bankTel = bankTel;
    }

    public String getTelCheck() {
        return telCheck;
    }

    public void setTelCheck(String telCheck) {
        this.telCheck = telCheck;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PubDebt other = (PubDebt) that;
        return (this.getDebtId() == null ? other.getDebtId() == null : this.getDebtId().equals(other.getDebtId()))
            && (this.getReportId() == null ? other.getReportId() == null : this.getReportId().equals(other.getReportId()))
            && (this.getIscoordinate() == null ? other.getIscoordinate() == null : this.getIscoordinate().equals(other.getIscoordinate()))
            && (this.getReportType() == null ? other.getReportType() == null : this.getReportType().equals(other.getReportType()))
            && (this.getReportPropert() == null ? other.getReportPropert() == null : this.getReportPropert().equals(other.getReportPropert()))
            && (this.getData1() == null ? other.getData1() == null : this.getData1().equals(other.getData1()))
            && (this.getData2() == null ? other.getData2() == null : this.getData2().equals(other.getData2()))
            && (this.getData3() == null ? other.getData3() == null : this.getData3().equals(other.getData3()))
            && (this.getData4() == null ? other.getData4() == null : this.getData4().equals(other.getData4()))
            && (this.getData5() == null ? other.getData5() == null : this.getData5().equals(other.getData5()))
            && (this.getData6() == null ? other.getData6() == null : this.getData6().equals(other.getData6()))
            && (this.getData7() == null ? other.getData7() == null : this.getData7().equals(other.getData7()))
            && (this.getData8() == null ? other.getData8() == null : this.getData8().equals(other.getData8()))
            && (this.getData9() == null ? other.getData9() == null : this.getData9().equals(other.getData9()))
            && (this.getData10() == null ? other.getData10() == null : this.getData10().equals(other.getData10()))
            && (this.getData11() == null ? other.getData11() == null : this.getData11().equals(other.getData11()))
            && (this.getCardJust() == null ? other.getCardJust() == null : this.getCardJust().equals(other.getCardJust()))
            && (this.getCardBack() == null ? other.getCardBack() == null : this.getCardBack().equals(other.getCardBack()))
            && (this.getObligatRight() == null ? other.getObligatRight() == null : this.getObligatRight().equals(other.getObligatRight()))
            && (this.getObligatRightNo() == null ? other.getObligatRightNo() == null : this.getObligatRightNo().equals(other.getObligatRightNo()))
            && (this.getObligatTime() == null ? other.getObligatTime() == null : this.getObligatTime().equals(other.getObligatTime()))
            && (this.getCapital() == null ? other.getCapital() == null : this.getCapital().equals(other.getCapital()))
            && (this.getInterest() == null ? other.getInterest() == null : this.getInterest().equals(other.getInterest()))
            && (this.getInterestRate() == null ? other.getInterestRate() == null : this.getInterestRate().equals(other.getInterestRate()))
            && (this.getDebt() == null ? other.getDebt() == null : this.getDebt().equals(other.getDebt()))
            && (this.getDebtNo() == null ? other.getDebtNo() == null : this.getDebtNo().equals(other.getDebtNo()))
            && (this.getDebtTime() == null ? other.getDebtTime() == null : this.getDebtTime().equals(other.getDebtTime()))
            && (this.getDebtCertificate() == null ? other.getDebtCertificate() == null : this.getDebtCertificate().equals(other.getDebtCertificate()))
            && (this.getUploadDebtCertificate() == null ? other.getUploadDebtCertificate() == null : this.getUploadDebtCertificate().equals(other.getUploadDebtCertificate()))
            && (this.getIsResult() == null ? other.getIsResult() == null : this.getIsResult().equals(other.getIsResult()))
            && (this.getEconomics() == null ? other.getEconomics() == null : this.getEconomics().equals(other.getEconomics()))
            && (this.getUsage() == null ? other.getUsage() == null : this.getUsage().equals(other.getUsage()))
            && (this.getPrjectManager() == null ? other.getPrjectManager() == null : this.getPrjectManager().equals(other.getPrjectManager()))
            && (this.getAuthname() == null ? other.getAuthname() == null : this.getAuthname().equals(other.getAuthname()))
            && (this.getCard() == null ? other.getCard() == null : this.getCard().equals(other.getCard()))
            && (this.getBank() == null ? other.getBank() == null : this.getBank().equals(other.getBank()))
            && (this.getBankCard() == null ? other.getBankCard() == null : this.getBankCard().equals(other.getBankCard()))
            && (this.getBankTel() == null ? other.getBankTel() == null : this.getBankTel().equals(other.getBankTel()))
            && (this.getTelCheck() == null ? other.getTelCheck() == null : this.getTelCheck().equals(other.getTelCheck()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getUpdateUserId() == null ? other.getUpdateUserId() == null : this.getUpdateUserId().equals(other.getUpdateUserId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDebtId() == null) ? 0 : getDebtId().hashCode());
        result = prime * result + ((getReportId() == null) ? 0 : getReportId().hashCode());
        result = prime * result + ((getIscoordinate() == null) ? 0 : getIscoordinate().hashCode());
        result = prime * result + ((getReportType() == null) ? 0 : getReportType().hashCode());
        result = prime * result + ((getReportPropert() == null) ? 0 : getReportPropert().hashCode());
        result = prime * result + ((getData1() == null) ? 0 : getData1().hashCode());
        result = prime * result + ((getData2() == null) ? 0 : getData2().hashCode());
        result = prime * result + ((getData3() == null) ? 0 : getData3().hashCode());
        result = prime * result + ((getData4() == null) ? 0 : getData4().hashCode());
        result = prime * result + ((getData5() == null) ? 0 : getData5().hashCode());
        result = prime * result + ((getData6() == null) ? 0 : getData6().hashCode());
        result = prime * result + ((getData7() == null) ? 0 : getData7().hashCode());
        result = prime * result + ((getData8() == null) ? 0 : getData8().hashCode());
        result = prime * result + ((getData9() == null) ? 0 : getData9().hashCode());
        result = prime * result + ((getData10() == null) ? 0 : getData10().hashCode());
        result = prime * result + ((getData11() == null) ? 0 : getData11().hashCode());
        result = prime * result + ((getCardJust() == null) ? 0 : getCardJust().hashCode());
        result = prime * result + ((getCardBack() == null) ? 0 : getCardBack().hashCode());
        result = prime * result + ((getObligatRight() == null) ? 0 : getObligatRight().hashCode());
        result = prime * result + ((getObligatRightNo() == null) ? 0 : getObligatRightNo().hashCode());
        result = prime * result + ((getObligatTime() == null) ? 0 : getObligatTime().hashCode());
        result = prime * result + ((getCapital() == null) ? 0 : getCapital().hashCode());
        result = prime * result + ((getInterest() == null) ? 0 : getInterest().hashCode());
        result = prime * result + ((getInterestRate() == null) ? 0 : getInterestRate().hashCode());
        result = prime * result + ((getDebt() == null) ? 0 : getDebt().hashCode());
        result = prime * result + ((getDebtNo() == null) ? 0 : getDebtNo().hashCode());
        result = prime * result + ((getDebtTime() == null) ? 0 : getDebtTime().hashCode());
        result = prime * result + ((getDebtCertificate() == null) ? 0 : getDebtCertificate().hashCode());
        result = prime * result + ((getUploadDebtCertificate() == null) ? 0 : getUploadDebtCertificate().hashCode());
        result = prime * result + ((getIsResult() == null) ? 0 : getIsResult().hashCode());
        result = prime * result + ((getEconomics() == null) ? 0 : getEconomics().hashCode());
        result = prime * result + ((getUsage() == null) ? 0 : getUsage().hashCode());
        result = prime * result + ((getPrjectManager() == null) ? 0 : getPrjectManager().hashCode());
        result = prime * result + ((getAuthname() == null) ? 0 : getAuthname().hashCode());
        result = prime * result + ((getCard() == null) ? 0 : getCard().hashCode());
        result = prime * result + ((getBank() == null) ? 0 : getBank().hashCode());
        result = prime * result + ((getBankCard() == null) ? 0 : getBankCard().hashCode());
        result = prime * result + ((getBankTel() == null) ? 0 : getBankTel().hashCode());
        result = prime * result + ((getTelCheck() == null) ? 0 : getTelCheck().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getUpdateUserId() == null) ? 0 : getUpdateUserId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", debtId=").append(debtId);
        sb.append(", reportId=").append(reportId);
        sb.append(", iscoordinate=").append(iscoordinate);
        sb.append(", reportType=").append(reportType);
        sb.append(", reportPropert=").append(reportPropert);
        sb.append(", data1=").append(data1);
        sb.append(", data2=").append(data2);
        sb.append(", data3=").append(data3);
        sb.append(", data4=").append(data4);
        sb.append(", data5=").append(data5);
        sb.append(", data6=").append(data6);
        sb.append(", data7=").append(data7);
        sb.append(", data8=").append(data8);
        sb.append(", data9=").append(data9);
        sb.append(", data10=").append(data10);
        sb.append(", data11=").append(data11);
        sb.append(", cardJust=").append(cardJust);
        sb.append(", cardBack=").append(cardBack);
        sb.append(", obligatRight=").append(obligatRight);
        sb.append(", obligatRightNo=").append(obligatRightNo);
        sb.append(", obligatTime=").append(obligatTime);
        sb.append(", capital=").append(capital);
        sb.append(", interest=").append(interest);
        sb.append(", interestRate=").append(interestRate);
        sb.append(", debt=").append(debt);
        sb.append(", debtNo=").append(debtNo);
        sb.append(", debtTime=").append(debtTime);
        sb.append(", debtCertificate=").append(debtCertificate);
        sb.append(", uploadDebtCertificate=").append(uploadDebtCertificate);
        sb.append(", isResult=").append(isResult);
        sb.append(", economics=").append(economics);
        sb.append(", usage=").append(usage);
        sb.append(", prjectManager=").append(prjectManager);
        sb.append(", authname=").append(authname);
        sb.append(", card=").append(card);
        sb.append(", bank=").append(bank);
        sb.append(", bankCard=").append(bankCard);
        sb.append(", bankTel=").append(bankTel);
        sb.append(", telCheck=").append(telCheck);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", updateUserId=").append(updateUserId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}