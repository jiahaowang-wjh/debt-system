package com.smart.bracelet.model.vo.debt;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * bus_relative_person
 * @author 
 */
@Data
public class BusRelativePersonVo implements Serializable {
    /**
     * 相对人ID
     */
    @NotNull(message = "相对人ID不能为空")
    private Long relativePerId;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
     * 创建人
     */
    private Long createUserId;

    /**
     * 更新人
     */
    private Long updateUserId;


}