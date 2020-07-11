package com.smart.bracelet.model.vo.debt;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * pub_debt
 * @author 
 */
@Data
public class PubDebtVo implements Serializable {
    private static final long serialVersionUID = -5410806714315964889L;
    /**
     * 解债ID
     */
    @NotNull(message = "解债Id不能为空")
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
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
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
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
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
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;


}